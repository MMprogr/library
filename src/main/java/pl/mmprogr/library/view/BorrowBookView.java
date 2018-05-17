package pl.mmprogr.library.view;

import pl.mmprogr.library.model.user.User;
import pl.mmprogr.library.model.user.UserBuilder;

import java.util.Scanner;

public class BorrowBookView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String takeDataToFindBookByTitleToBorrow() {
		System.out.println("You chose 'borrow' option");
		System.out.println("Type title, which book you want to borrow: ");
		return scanner.nextLine();
	}

	public static User takeUserDataToBorrowBook() {
		System.out.println("Book is available for you ");
		System.out.println("I need your credentials ");
		System.out.println("Type your first name: ");
		String firstname = scanner.nextLine();
		System.out.println("Type your last name: ");
		String lastname = scanner.nextLine();
		System.out.println("Okay. Book is yours");
		return new UserBuilder()
				.withFirstname(firstname)
				.withLastname(lastname)
				.build();
	}

	public static void noAvailableBookToBorrow() {
		System.out.println("Oh. There is no available book, which you want to borrow. Everyone has been borrowed");
	}
}
