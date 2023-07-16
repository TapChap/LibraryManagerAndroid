package com.example.librarymanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class BookActivity extends AppCompatActivity {

    private ImageView bookImg;
    private MaterialButton readingThisBttn, allreadyReadBttn, addToWishlistBttn, likeBttn, backBttn;
    private TextView bookName, author, pages, price, shortDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookImg = findViewById(R.id.bookActivityBookImage);

        readingThisBttn = findViewById(R.id.readingThisBttn);
        allreadyReadBttn = findViewById(R.id.allReadyReadBttn);
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

        int bookId = getIntent().getIntExtra("bookId", -1);
        setData(Utils.getInstance().getBookById(bookId));
    }

    private void setData(Book book) {
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(bookImg);
        bookName.setText(book.getName());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        price.setText(String.valueOf(book.getPrice()));
        shortDescrip.setText(getString(R.string.emptyPlaceHolder) + book.getShortDescription());
    }
}