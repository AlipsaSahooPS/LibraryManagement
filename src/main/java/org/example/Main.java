package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public  class Main {
    public static void main(String[] args) {
        String url = System.getenv("DB_URL");

        String userName = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");
        try{
            Connection connection = DriverManager.getConnection(url,userName,password);
            System.out.println("yes connected");
        }
        catch (Exception e){
            System.out.println(e);
        }
       Library Library = new Library();
       Library.showMenu();
       Library.printAllBooks();

    }
}