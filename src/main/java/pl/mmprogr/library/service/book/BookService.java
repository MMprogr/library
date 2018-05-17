package pl.mmprogr.library.service.book;

import org.springframework.stereotype.Service;
import pl.mmprogr.library.model.book.Book;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
	void setBooks(List<Book> books);

	List<Book> findAllBooks();

	void add(Book book);

	void remove(Book book);

	List<Optional<Book>>findByAuthor(String author);

	List<Optional<Book>> findByTitle(String title);

	List<Optional<Book>> findByIsbnNumber(String IsbnNumber);
}
