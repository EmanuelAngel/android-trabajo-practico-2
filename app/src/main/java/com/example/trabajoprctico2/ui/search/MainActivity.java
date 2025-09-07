package com.example.trabajoprctico2.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajoprctico2.databinding.ActivityMainBinding;
import com.example.trabajoprctico2.ui.book.BookActivity;

// ...
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        setContentView(activityMainBinding.getRoot());

        mainActivityViewModel.getMutableFindResultMessage().observe(
                this,
                message -> Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        );

        activityMainBinding.btSearchBook.setOnClickListener(
                view -> mainActivityViewModel.findBookByTitle(
                        activityMainBinding.etSearchBook.getText().toString()
                )
        );

        mainActivityViewModel.getMutableBook().observe(
                this,
                book -> {
                    var goToBook = new Intent(this, BookActivity.class);

                    goToBook.putExtra("book", book);

                    startActivity(goToBook);
                }
        );
    }
}