package pl.mmprogr.library.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.mmprogr.library.model.book.Book;
import pl.mmprogr.library.service.book.BookService;
import pl.mmprogr.library.service.book.LoadBooksFromFileService;
import pl.mmprogr.library.service.book.SaveBooksToFileService;
import pl.mmprogr.library.view.AddBookToLibraryView;
import pl.mmprogr.library.view.BooksListView;
import pl.mmprogr.library.view.FindBookView;
import pl.mmprogr.library.view.RemoveBookFromLibraryView;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
	private final LoadBooksFromFileService loadBooksFromFileService;
	private final SaveBooksToFileService saveBooksToFileService;
	private final BookService bookService;
	private String pathToFile;

	@Autowired
	public BookController(LoadBooksFromFileService loadBooksFromFileService, SaveBooksToFileService saveBooksToFileService, BookService bookService) {
		this.loadBooksFromFileService = loadBooksFromFileService;
		this.saveBooksToFileService = saveBooksToFileService;
		this.bookService = bookService;
	}

	public boolean loadBooksDataFromFile(String pathToFile) {
		List<Book> books = loadBooksFromFileService.load(pathToFile);
		if (books != null) {
			bookService.setBooks(books);
			BooksListView.listBooks(books);
			return true;
		} else {
			BooksListView.typedWrongPathToFile();
			return false;
		}
	}

	public void showAllBooks() {
		BooksListView.listBooks(bookService.findAllBooks());
	}

	public void updateFile() {
		saveBooksToFileService.save(bookService.findAllBooks(), pathToFile);
	}

	public void addBookToLibrary() {
		Book book = AddBookToLibraryView.takeDataToAddBook();
		bookService.add(book);
		updateFile();
	}

	public void removeBookFromLibrary() {
		String titleToRemove = RemoveBookFromLibraryView.takeDataToRemoveBook();
		Optional<Book> bookToRemove = bookService.findByTitle(titleToRemove).get(0);
		if (bookToRemove.isPresent()) {
			bookService.remove(bookToRemove.get());
			RemoveBookFromLibraryView.bookSuccessfullyRemoved();
			updateFile();
		} else {
			RemoveBookFromLibraryView.bookDoesNotExist();
		}
	}

	public void findBooksBy(String typeOfFind) {
		List<Optional<Book>> books = null;
		switch (typeOfFind){
			case "3":{
				books = bookService.findByAuthor(FindBookView.takeDataToFindBookByAuthor());
			}
			break;
			case "4":{
				books = bookService.findByTitle(FindBookView.takeDataToFindBookByTitle());
			}
			break;
			case "5":{
				books = bookService.findByIsbnNumber(FindBookView.takeDataToFindBookByIsbnNumber());
			}
			break;
		}
		if(books != null && books.get(0).isPresent()){
			FindBookView.listBooks(books);
		} else{
			FindBookView.booksNotFound();
		}
	}

	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}
}
