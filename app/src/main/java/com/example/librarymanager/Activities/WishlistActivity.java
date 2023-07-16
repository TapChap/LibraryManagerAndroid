package com.example.librarymanager.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.librarymanager.BookRecViewAdapter;
import com.example.librarymanager.R;
import com.example.librarymanager.Utils;

public class WishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        RecyclerView recyclerView = findViewById(R.id.booksRecViewWishlist);
        BookRecViewAdapter adapter = new BookRecViewAdapter(this);

        adapter.setBooks(Utils.getInstance().getWishlistBooks());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}