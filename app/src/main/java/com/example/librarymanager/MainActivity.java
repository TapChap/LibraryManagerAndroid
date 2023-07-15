package com.example.librarymanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ShapeableImageView profileImage;
    private TextView myLibraryTxt, developedByTxt;
    private MaterialButton seeAllBooksBttn, currentlyReadingBttn, alreadyReadBttn, myWishlistBttn, myFavoritesBttn, aboutBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // defining all the UI elements
        profileImage = findViewById(R.id.profilePic);

        myLibraryTxt = findViewById(R.id.myLibrarytxt);
        developedByTxt = findViewById(R.id.developedByTxt);

        seeAllBooksBttn = findViewById(R.id.seeAllBooksBttn);
        currentlyReadingBttn = findViewById(R.id.currentlyReadingBttn);
        alreadyReadBttn = findViewById(R.id.allReadyReadBttn);
        myWishlistBttn = findViewById(R.id.myWishlistBttn);
        myFavoritesBttn = findViewById(R.id.myFavoritesBttn);
        aboutBttn = findViewById(R.id.aboutBttn);

        aboutBttn.setOnClickListener(this);
        seeAllBooksBttn.setOnClickListener(this);
        myWishlistBttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.aboutBttn) switchToActivity(AboutActivity.class);
        if (id == R.id.seeAllBooksBttn) switchToActivity(AllBooksActivity.class);
        if (id == R.id.myWishlistBttn) switchToActivity(bookActivity.class);
    }

    public void switchToActivity(Class<?> targetClass){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }
}