package com.example.librarymanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecycleView;
    private BooksRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BooksRecViewAdapter(this);
        booksRecycleView = findViewById(R.id.booksRecView);


        // why do i not see the images in the url's when i run the app?
        // they dont show in the emulator either
        // i have internet connection
        // i have the internet permission in the manifest
        // i have the glide dependency in the gradle file
        // fix it


        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, 852, "Harry Potter", "J K Rowling", getString(R.string.harryPotterUrl), getString(R.string.harryPotterShortDescrip)));
        books.add(new Book(2, 561, "Mr.Feynman", "Richard Feynman", getString(R.string.mrFeynmanUrl), getString(R.string.mrFeynmanShortDescrip)));

        adapter.setBooks(books);
        booksRecycleView.setAdapter(adapter);
        booksRecycleView.setLayoutManager(new LinearLayoutManager(this));
        booksRecycleView.setHasFixedSize(true);
    }
}