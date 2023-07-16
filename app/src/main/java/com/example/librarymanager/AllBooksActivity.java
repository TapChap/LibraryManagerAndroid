package com.example.librarymanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecycleView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BookRecViewAdapter(this);
        booksRecycleView = findViewById(R.id.booksRecView);

        adapter.setBooks(Utils.getInstance().getAllBooks());
        booksRecycleView.setAdapter(adapter);
        booksRecycleView.setLayoutManager(new LinearLayoutManager(this));
        booksRecycleView.setHasFixedSize(true);
    }
}