package com.tts;

import java.util.ArrayList;

public class Library {

	 // Add the missing implementation to this class
	private String streetName;
	private ArrayList<Book> books = new ArrayList<>();
	private static final String hours = "Libraries are open daily from 9am to 5pm.";
	
	public Library(String name) {
		this.streetName = name;
	}
		
	public void addBook(Book bookName) {
		books.add(bookName);
	}
	
	public static void printOpeningHours() {
		System.out.print(hours);
	}
	
	public void printAddress() {
		System.out.println(this.streetName);
	}
	
	public void borrowBook(String bookName) {
		
		for (Book b : this.books) {
			
			if (b.getTitle().equals(bookName)) {
				
				if (b.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;					
				} 
				
				b.borrowed();
				System.out.printf("You successfully borrowed %s \n", bookName);
				return;				
			}
			
		}
		System.out.println("Sorry, this book is not in our catalog.");
		
	}

	public void printAvailableBooks() {
		int count = 0;
		
		for (Book b : this.books) {
			if (!b.isBorrowed()) {
				System.out.println(b.getTitle());
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No books in catalog.");
		}
	}
	
	public void returnBook(String bookName) {
		for (Book b : this.books) {
			
			if (b.getTitle().equals(bookName)) {
				
				if (b.isBorrowed()) {
					
					b.returned();
					System.out.printf("You successfully returned %s \n", bookName);
					return;
					
				}
				
				System.out.println("Book was never borrowed, return error!");
				return;
			}
			
		}
		
		System.out.println("Book is not part of our library, return error!");
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
	
}
