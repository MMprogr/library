package pl.mmprogr.library.view;

import org.springframework.stereotype.Component;
import pl.mmprogr.library.model.book.Book;
import pl.mmprogr.library.model.book.BookBuilder;
import pl.mmprogr.library.validator.BookValidator;

import java.util.Scanner;

@Component
public class AddBookToLibraryView{
	public static Book takeDataToAddBook() {
		Scanner scanner = new Scanner(System.in);
		BookValidator bookValidator = new BookValidator();

		System.out.println("You chose 'add book' option");
		System.out.println("Type title: ");
		String title = scanner.nextLine();
		System.out.println("Type author: ");
		String author = scanner.nextLine();
		while(bookValidator.isNumberInText(author)){
			System.out.println("Ops! Author name can not contains numbers");
			System.out.println("Type author name again: ");
			author = scanner.nextLine();
		}
		System.out.println("Type ISBN Number: ");
		String isbnNumber = scanner.nextLine();
		return new BookBuilder()
				.withTitle(title)
				.withAuthor(author)
				.withIsbnNumber(isbnNumber)
				.withDateOfLastRental(null)
				.withLender(null)
				.build();
	}
}
