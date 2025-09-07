package com.example.trabajoprctico2.ui.book;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajoprctico2.databinding.ActivityBookBinding;

public class BookActivity extends AppCompatActivity {
    private ActivityBookBinding activityBookBinding;
    private BookActivityViewModel bookActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityBookBinding = ActivityBookBinding.inflate(getLayoutInflater());
        bookActivityViewModel = new ViewModelProvider(this).get(BookActivityViewModel.class);

        setContentView(activityBookBinding.getRoot());

        bookActivityViewModel.getMutableBook().observe(
                this,
                book -> {
                    activityBookBinding.tvBookTitle.setText(book.getTitle());
                    activityBookBinding.tvBookAuthor.setText(book.getAuthor());
                    activityBookBinding.tvBookPagesQuantity.setText(String.valueOf(book.getPagesQuantity()));
                    activityBookBinding.tvBookPublishYear.setText(String.valueOf(book.getPublishYear()));
                    activityBookBinding.tvBookDescription.setText(book.getDescription());
                    activityBookBinding.ivBookImage.setImageResource(book.getImageResId());
                    activityBookBinding.ivBookImage.setContentDescription("Portada de " + book.getTitle());
                }
        );

        bookActivityViewModel.extractIntentData(getIntent());
    }
}