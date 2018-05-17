package pl.mmprogr.library.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmprogr.library.model.book.Book;
import pl.mmprogr.library.repo.book.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MyBookService implements BookService{
	private final BookRepo bookRepo;

	@Autowired
	public MyBookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public void setBooks(List<Book> books) {
		bookRepo.setBooks(books);
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepo.findAllBooks();
	}

	@Override
	public void add(Book book) {
		bookRepo.add(book);
	}

	@Override
	public void remove(Book book) {
		bookRepo.remove(book);
	}

	@Override
	public List<Optional<Book>> findByAuthor(String author) {
		return bookRepo.findByAuthor(author);
	}

	@Override
	public List<Optional<Book>> findByTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	@Override
	public List<Optional<Book>> findByIsbnNumber(String IsbnNumber) {
		return bookRepo.findByIsbnNumber(IsbnNumber);
	}
}
