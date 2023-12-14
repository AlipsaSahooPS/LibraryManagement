package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library implements Stock {
    BufferedReader buff;
    InputStreamReader isr;
    boolean flag = true;
    static int choice;
    ArrayList<Book> allBook = new ArrayList<Book>();

    public Library() {
        isr = new InputStreamReader(System.in);
        buff = new BufferedReader(isr);

//        for (int i = 1; i <= 10; i++) {
//            String Book_Name = "Book" + i;
//            String Book_Author = "Author" + i;
//            float BookPrice = i * 10.0f;
//            java.util.Date publishedDate = new java.util.Date();
//
//            Book book = new Book(Book_Name, Book_Author, BookPrice, publishedDate);
//            allBook.add(book);
//        }
    }

//    public static void main(String[] args) {
//        Library obj = new Library();
//        obj.showMenu();
//    }

    public void showMenu() {
        while (flag) {
            System.out.println("Welcome to Library");
            System.out.println("Select the operations you want to perform \n1. Add Book \n2. Update Book \n3. Delete Book \n4. Print All Books \n5. Exit");

            try {
                // Read user's choice
                choice = Integer.parseInt(buff.readLine());
                Book book;
                // Process the user's choice
                switch (choice) {
                    case 1:
                        System.out.println("Add Book operation selected");
                        book = new Book(buff);
                        addBook(book);
                        break;
                    case 2:
                        System.out.println("Update Book operation selected");
                        book = new Book(buff);
                        updateBook(book);
                        break;
                    case 3:
                        System.out.println("Delete Book operation selected");
//                        deleteBook(book);
                        break;
                    case 4:
                        System.out.println("Print All Books operation selected");
                        printAllBooks();
                        break;
                    case 5:
                        System.out.println("Exiting the Library");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        flag = false; // Stop the infinite loop for an invalid choice
                        break;
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addBook(Book book) {
        allBook.add(book);
    }

    @Override
    public void updateBook(Book book) {
        try {
            System.out.println("Enter the index of the book you want to update:");
            int index = Integer.parseInt(buff.readLine());

            if (index >= 0 && index < allBook.size()) {
                Book existingBook = allBook.get(index);

                System.out.println("Enter the new Book Name:");
                String newBookName = buff.readLine();

                System.out.println("Enter the new Author:");
                String newAuthor = buff.readLine();

                System.out.println("Enter the new Book Price:");
                float newPrice = Float.parseFloat(buff.readLine());

                // Update the book details
                existingBook.setBook_Name(newBookName);
                existingBook.setBook_Author(newAuthor);
                existingBook.setBookPrice(newPrice);

                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book) {
        try {
            System.out.println("Enter the index of the book you want to delete:");
            int index = Integer.parseInt(buff.readLine());

            if (index >= 0 && index < allBook.size()) {
                Book deletedBook = allBook.remove(index);
                System.out.println("Book deleted successfully: " + deletedBook.getBook_Name());
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


    void printAllBooks() {
        System.out.println("List of Books in the Library:");
        for (Book book : allBook) {
            System.out.println("Book Name: " + book.getBook_Name());
            System.out.println("Author: " + book.getBook_Author());
            System.out.println("Price: " + book.getBookPrice());
            System.out.println("Published Date: " + book.getPublished());
            System.out.println();
        }
    }

    @Override
    public void findBooksBySearch() {
        System.out.println("Select search criteria: \n1. By Name \n2. By Cost \n3. By Category \n4. By Cost Range");
        try {
            int searchChoice = Integer.parseInt(buff.readLine());

            switch (searchChoice) {
                case 1:
                    System.out.println("Enter the name of the book:");
                    String searchName = buff.readLine();
                    var booksByName = findBooksByName(searchName);
                    displaySearchResults(booksByName);
                    if (Objects.equals(booksByName, "Not Found")) System.out.println("Not Found");
                    break;
                case 2:
                    System.out.println("Enter the cost of the book:");
                    float searchCost = Float.parseFloat(buff.readLine());
                    var booksByCost = findBooksByCost(searchCost);
                    displayBookCost(booksByCost);
                    break;
                case 3:
                    System.out.println("Enter the category of the book:");
                    String searchCategory = buff.readLine();
                    var booksByCategory = findBooksByCategory(searchCategory);
                    displayBookCategory(booksByCategory);
                    break;
                case 4:
                    System.out.println("Enter the minimum cost:");
                    float minCost = Float.parseFloat(buff.readLine());
                    System.out.println("Enter the maximum cost:");
                    float maxCost = Float.parseFloat(buff.readLine());
                    var booksInCostRange = findBooksInCostRange(minCost, maxCost);
                    displayBookCostRange(booksInCostRange);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid search criteria.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float findBooksInCostRange(float minCost, float maxCost) {
        return 0f;
    }

    public String findBooksByCategory(String searchCategory) {
        return "Alipsa";
    }

    public float findBooksByCost(float searchCost) {
        return 0f;
    }


    public String findBooksByName(String searchName) {
        for (Book book : allBook) {
            if (book.getBook_Name().equalsIgnoreCase(searchName)) {
                return book.getBook_Name();
            }
        }
        return "Not Found";


    }

    public float displayBookCost(Float booksByCost) {

        return 0f;
    }

    public String displaySearchResults(String booksByName) {
        return "Alipsa";
    }

    public  String displayBookCategory(String booksByCategory){
        return "Alipsa";
    }
    public float displayBookCostRange(float booksInCostRange) {
        return 0f;
    }

}

