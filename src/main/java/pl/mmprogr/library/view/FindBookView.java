package pl.mmprogr.library.view;

import pl.mmprogr.library.model.book.Book;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FindBookView {
	private final static Scanner scanner = new Scanner(System.in);

	public static String takeDataToFindBookByAuthor() {
		System.out.println("You chose 'find books by author' option");
		System.out.println("Type author, who books you want to find: ");
		return scanner.nextLine();
	}

	public static String takeDataToFindBookByTitle() {
		System.out.println("You chose 'find books by title' option");
		System.out.println("Type title, that book you want to find: ");
		return scanner.nextLine();
	}

	public static String takeDataToFindBookByIsbnNumber() {
		System.out.println("You chose 'find books by ISBDN number' option");
		System.out.println("Type ISBDN, that book you want to find: ");
		return scanner.nextLine();
	}

	public static void listBooks(List<Optional<Book>> books) {
		for(Optional<Book> book: books){
			book.ifPresent(b -> System.out.println(b.toString()));
		}
	}

	public static void booksNotFound() {
		System.out.println("We have no book, that you want to find! ");
	}
}
