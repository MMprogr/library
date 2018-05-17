package pl.mmprogr.library.view;

import org.springframework.stereotype.Component;
import pl.mmprogr.library.model.book.Book;

import java.util.Arrays;
import java.util.List;

@Component
public class BooksListView {
	public static void listBooks(List<Book> books) {
		System.out.format("List of books in library: %n %s %n", Arrays.toString(new List[]{books}));
	}

	public static void typedWrongPathToFile() {
		System.out.format("Wrong path to file! %n");
	}
}
