package com.example.librarymanager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class BookActivity extends AppCompatActivity {

    private ImageView bookImg;
    private MaterialButton readingThisBttn, allreadyReadBttn, addToFavBttn, likeBttn, backBttn;
    private TextView bookName, author, pages, price, shortDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookImg = findViewById(R.id.bookActivityBookImage);

        readingThisBttn = findViewById(R.id.readingThisBttn);
        allreadyReadBttn = findViewById(R.id.allReadyReadBttn);
        addToFavBttn = findViewById(R.id.addToFavBttn);
        likeBttn = findViewById(R.id.likeBttn);

        bookName = findViewById(R.id.bookName);
        author = findViewById(R.id.authorName);
        pages = findViewById(R.id.pages);
        price = findViewById(R.id.price);
        shortDescrip = findViewById(R.id.shortDescriptionBookActivity);

        backBttn = findViewById(R.id.backBttn);

        // TODO: set the data from the recycler view book
        Book book = new Book(2, 561, "Mr.Feynman", "Richard Feynman", getString(R.string.mrFeynmanUrl), 399,  getString(R.string.mrFeynmanShortDescrip));
        setData(book);
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