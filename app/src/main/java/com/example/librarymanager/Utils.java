package com.example.librarymanager;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Book>
            allBooks = new ArrayList<>(),
            readBooks = new ArrayList<>(),
            readingBooks = new ArrayList<>(),
            wishlistBooks = new ArrayList<>(),
            likedBooks = new ArrayList<>();
    public static synchronized Utils getInstance(){
        if (instance == null) instance = new Utils();
        return instance;
    }

    private Utils(){
        initAllBooksList();
    }

    private void initAllBooksList() {
        // todo: add more books

        allBooks.add(new Book(1, 852, "Harry Potter", "J.K. Rowling", "https://online.flipbuilder.com/fdyv/bgdb/files/mobile/1.jpg?200831041711", 125, "The books follow Harry's and his friends adventures and battles vs The Lord Voldemort."));
        allBooks.add(new Book(2, 561, "Mr.Feynman", "Richard Feynman", "https://upload.wikimedia.org/wikipedia/en/d/d2/SurelyYoureJokingMrFeynman.PNG", 399, "Stories from the Life of Richard Feynman, a brilliant Physicist, and a Strange man"));
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public ArrayList<Book> getReadBooks() {
        return readBooks;
    }

    public ArrayList<Book> getReadingBooks() {
        return readingBooks;
    }

    public ArrayList<Book> getWishlistBooks() {
        return wishlistBooks;
    }

    public ArrayList<Book> getLikedBooks() {
        return likedBooks;
    }

    public Book getBookById(int id){
        for (Book book: allBooks) {
            if (book.getId() == id) return book;
        }
        return new Book();
    }
}
