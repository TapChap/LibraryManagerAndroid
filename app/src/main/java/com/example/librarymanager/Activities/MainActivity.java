package com.example.librarymanager.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanager.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ShapeableImageView profileImage;
    private TextView myLibraryTxt, developedByTxt;
    private MaterialButton seeAllBooksBttn, currentlyReadingBttn, alreadyReadBttn, myWishlistBttn, myLikedBttn, aboutBttn;

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
        alreadyReadBttn = findViewById(R.id.alReadyReadBttn);
        myWishlistBttn = findViewById(R.id.myWishlistBttn);
        myLikedBttn = findViewById(R.id.myLikedBttn);
        aboutBttn = findViewById(R.id.aboutBttn);

        seeAllBooksBttn.setOnClickListener(this);
        currentlyReadingBttn.setOnClickListener(this);
        alreadyReadBttn.setOnClickListener(this);
        myWishlistBttn.setOnClickListener(this);
        myLikedBttn.setOnClickListener(this);
        aboutBttn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.aboutBttn) switchToActivity(AboutActivity.class);
        if (id == R.id.seeAllBooksBttn) switchToActivity(AllBooksActivity.class);
        if (id == R.id.currentlyReadingBttn) switchToActivity(AlreadyReadBookActivity.class);
        if (id == R.id.alReadyReadBttn) switchToActivity(AlreadyReadBookActivity.class);
        if (id == R.id.myWishlistBttn) switchToActivity(AlreadyReadBookActivity.class);
        if (id == R.id.myLikedBttn) switchToActivity(AlreadyReadBookActivity.class);
    }

    public void switchToActivity(Class<?> targetClass){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }
}