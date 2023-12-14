package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    String Book_Name, Book_Author, Category;
     float BookPrice = 0.0f;

    public Book(String book_Name, String book_Author, float bookPrice, Date published, String category) {
        Book_Name = book_Name;
        Book_Author = book_Author;
        BookPrice = bookPrice;
        this.published = published;
        Category = category;

    }

    public Book(BufferedReader buff){
        try {
            System.out.println("Enter the Book Name:");
            String bookName = buff.readLine();

            System.out.println("Enter the Author:");
            String author = buff.readLine();

            System.out.println("Enter the Book Price:");
            float price = Float.parseFloat(buff.readLine());

            System.out.println("Enter the Category:");
            String category = buff.readLine();

            java.util.Date publishedDate = new java.util.Date();


//            Book newBook = new Book(bookName, author, price, publishedDate, category);

            System.out.println("Book added successfully!");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }
    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        Category = Category;
    }


    public String getBook_Author() {
        return Book_Author;
    }

    public void setBook_Author(String book_Author) {
        Book_Author = book_Author;
    }

    public float getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(float bookPrice) {
        BookPrice = bookPrice;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    Date published;
}
