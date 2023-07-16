package com.example.librarymanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.librarymanager.Book;
import com.example.librarymanager.R;
import com.example.librarymanager.Utils;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private final String TAG = "BookActivity";

    private ImageView bookImg;
    private MaterialButton readingThisBttn, alreadyReadBttn, addToWishlistBttn, likeBttn, backBttn;
    private TextView bookName, author, pages, price, shortDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookImg = findViewById(R.id.bookActivityBookImage);

        readingThisBttn = findViewById(R.id.readingThisBttn);
        alreadyReadBttn = findViewById(R.id.alReadyReadBttn);
        addToWishlistBttn = findViewById(R.id.addToWishlistBttn);
        likeBttn = findViewById(R.id.likeBttn);

        bookName = findViewById(R.id.bookName);
        author = findViewById(R.id.authorName);
        pages = findViewById(R.id.pages);
        price = findViewById(R.id.price);
        shortDescrip = findViewById(R.id.shortDescriptionBookActivity);

        backBttn = findViewById(R.id.backBttn);
        backBttn.setOnClickListener((view -> {
            startActivity(new Intent(this, AllBooksActivity.class));
        }));

        Intent incomingIntent = getIntent();
        int bookId = incomingIntent.getIntExtra("bookId", -1);
        Book incomingBook = Utils.getInstance().getBookById(bookId);

        //TODO: fix whatever bugs happening there
        setData(incomingBook);
        handleCurrentlyReading(incomingBook);
        handleAlreadyRead(incomingBook);
        handleAddToWishlist(incomingBook);
        handleLikedBooks(incomingBook);
    }

    private void setData(Book book) {
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImg);
        bookName.setText(book.getName());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        price.setText(String.valueOf(book.getPrice()));
        shortDescrip.setText(getString(R.string.emptyPlaceHolder) + book.getShortDescription());
    }

    private void handleCurrentlyReading(Book incomingBook) {
        ArrayList<Book> currentlyReading = Utils.getInstance().getReadingBooks();

        for (Book book: currentlyReading) {
            if (book.getId() == incomingBook.getId()) readingThisBttn.setEnabled(false);
        }
        readingThisBttn.setOnClickListener(view -> {
            if (readingThisBttn.isEnabled()) {
                Utils.getInstance().getReadingBooks().add(incomingBook);
                readingThisBttn.setEnabled(false);
                Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAlreadyRead(Book incomingBook) {
        ArrayList<Book> alreadyRead = Utils.getInstance().getReadBooks();

        for (Book book: alreadyRead) {
            if (book.getId() == incomingBook.getId()) alreadyReadBttn.setEnabled(false);
        }
        alreadyReadBttn.setOnClickListener(view -> {
            if (alreadyReadBttn.isEnabled()) {
                Utils.getInstance().getReadBooks().add(incomingBook);
                alreadyReadBttn.setEnabled(false);
                Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAddToWishlist(Book incomingBook) {
        ArrayList<Book> wishlist = Utils.getInstance().getWishlistBooks();

        for (Book book: wishlist) {
            if (book.getId() == incomingBook.getId()) addToWishlistBttn.setEnabled(false);
        }
        addToWishlistBttn.setOnClickListener(view -> {
            if (addToWishlistBttn.isEnabled()) {
                Utils.getInstance().getWishlistBooks().add(incomingBook);
                addToWishlistBttn.setEnabled(false);
                Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleLikedBooks(Book incomingBook) {
        ArrayList<Book> likedBooks = Utils.getInstance().getLikedBooks();

        for (Book book: likedBooks) {
            if (book.getId() == incomingBook.getId()) likeBttn.setEnabled(false);
        }
        likeBttn.setOnClickListener(view -> {
            if (likeBttn.isEnabled()) {
                Utils.getInstance().getLikedBooks().add(incomingBook);
                likeBttn.setEnabled(false);
                Toast.makeText(this, "Book added successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}