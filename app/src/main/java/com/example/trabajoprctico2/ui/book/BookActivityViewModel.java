package com.example.trabajoprctico2.ui.book;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trabajoprctico2.models.BookModel;

public class BookActivityViewModel extends AndroidViewModel {
    private MutableLiveData<BookModel> mutableBook;

    public BookActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<BookModel> getMutableBook() {
        if (mutableBook == null) {
            mutableBook = new MutableLiveData<>();
        }

        return mutableBook;
    }

    public void extractIntentData(@NonNull Intent intent) {
        var book = intent.getSerializableExtra("book", BookModel.class);

        if (book != null) {
            mutableBook.setValue(book);
        }
    }
}
