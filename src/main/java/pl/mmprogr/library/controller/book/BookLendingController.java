package pl.mmprogr.library.controller.book;

import org.springframework.stereotype.Controller;
import pl.mmprogr.library.model.book.Book;
import pl.mmprogr.library.model.book.BookBuilder;
import pl.mmprogr.library.model.user.User;
import pl.mmprogr.library.service.book.BookService;
import pl.mmprogr.library.view.BorrowBookView;
import pl.mmprogr.library.view.FindBookView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class BookLendingController {
	private final BookController bookController;
	private final BookService bookService;

	public BookLendingController(BookController bookController, BookService bookService) {
		this.bookController = bookController;
		this.bookService = bookService;
	}

	public void borrowBook() {
		List<Optional<Book>>potentiallyBooksToBorrow = bookService.findByTitle(BorrowBookView.takeDataToFindBookByTitleToBorrow());

		if (potentiallyBooksToBorrow == null || potentiallyBooksToBorrow.isEmpty()) {
			FindBookView.booksNotFound();
		} else {
			for (Optional<Book> book : potentiallyBooksToBorrow) {
				Optional<Book> bookAvailableToLend = book.filter(b -> b.getLender() == null);
				if (bookAvailableToLend.isPresent()) {
					User user = BorrowBookView.takeUserDataToBorrowBook();
					Book borrowedBook = new BookBuilder()
							.withAuthor(bookAvailableToLend.get().getAuthor())
							.withIsbnNumber(bookAvailableToLend.get().getIsbnNumber())
							.withTitle(bookAvailableToLend.get().getTitle())
							.withDateOfLastRental(LocalDate.now())
							.withLender(user)
							.build();
					bookService.remove(bookAvailableToLend.get());
					bookService.add(borrowedBook);
					bookController.updateFile();
					return;
				}
			}
			BorrowBookView.noAvailableBookToBorrow();
		}
	}
}
