package pl.mmprogr.library.repo.book;

import org.springframework.stereotype.Repository;
import pl.mmprogr.library.model.book.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookRepo {
	private List<Book> books;

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> findAllBooks(){
		return books;
	}

	public void add(Book book){
		books.add(book);
	}
	public void remove(Book book){
		books.remove(book);
	}
	public List<Optional<Book>> findByAuthor(String author){
		return books.stream()
				.filter(b -> b.getAuthor().equals(author))
				.map(Optional::of)
				.collect(Collectors.toList());
	}
	public List<Optional<Book>> findByTitle(String title){
		return books.stream()
				.filter(b -> b.getTitle().equals(title))
				.map(Optional::of)
				.collect(Collectors.toList());
	}
	public List<Optional<Book>> findByIsbnNumber(String IsbnNumber){
		return books.stream()
				.filter(b -> b.getIsbnNumber().equals(IsbnNumber))
				.map(Optional::of)
				.collect(Collectors.toList());
	}
}
