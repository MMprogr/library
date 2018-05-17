package pl.mmprogr.library.view;

import java.util.Scanner;

public class RemoveBookFromLibraryView{
	public static void bookDoesNotExist(){
		System.out.println("We have no book with this title! ");
	}

	public static void bookSuccessfullyRemoved(){
		System.out.println("Successfully removed book from library! ");
	}

	public static String takeDataToRemoveBook() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("You chose 'remove book' option");
		System.out.println("Type book's title, that you want to delete: ");
		return scanner.nextLine();
	}
}
