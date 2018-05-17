package pl.mmprogr.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.mmprogr.library.configurationProperties.MessagesConfigurationProperties;
import pl.mmprogr.library.controller.book.BookController;
import pl.mmprogr.library.controller.book.BookLendingController;

import java.util.Scanner;

@SpringBootApplication
@EnableConfigurationProperties(MessagesConfigurationProperties.class)
public class LibraryApplication implements CommandLineRunner {
	private final BookController bookController;
	private final BookLendingController bookLendingController;

	@Autowired
	public LibraryApplication(BookController bookController, BookLendingController bookLendingController) {
		this.bookController = bookController;
		this.bookLendingController = bookLendingController;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LibraryApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		String pathToFile = "";
		boolean isPathCorrect = false;

		System.out.println("----------------------------------------------");
		while (true) {
			while (!isPathCorrect) {
				System.out.println("Type path to file with books: ");
				pathToFile = scanner.nextLine();
				if (pathToFile.equals("exit")) {
					return;
				}
				isPathCorrect = bookController.loadBooksDataFromFile(pathToFile);
			}
			bookController.setPathToFile(pathToFile);

			System.out.println("Choose action: ");
			System.out.println("0: show all books ");
			System.out.println("1: add book ");
			System.out.println("2: remove book ");
			System.out.println("3: find books by author ");
			System.out.println("4: find book by title ");
			System.out.println("5: find book by Isbn number ");
			System.out.println("6: borrow book");
			String line = scanner.nextLine();
			switch (line) {
				case "0": {
					bookController.showAllBooks();
				}
				break;
				case "1": {
					bookController.addBookToLibrary();
				}
				break;
				case "2": {
					bookController.removeBookFromLibrary();
				}
				break;
				case "3":
				case "4":
				case "5":{
					bookController.findBooksBy(line);
				}
				break;
				case "6": {
					bookLendingController.borrowBook();
				}
				break;
				case "exit": {
					return;
				}
			}
		}
	}
}
