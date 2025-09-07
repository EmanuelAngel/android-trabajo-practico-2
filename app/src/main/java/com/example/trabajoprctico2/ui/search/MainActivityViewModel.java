package com.example.trabajoprctico2.ui.search;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trabajoprctico2.models.BookModel;
import com.example.trabajoprctico2.models.BookRepository;

import java.util.Optional;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<BookModel> mutableBook;
    private MutableLiveData<String> mutableFindResultMessage;
    private final BookRepository bookRepository = new BookRepository();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<BookModel> getMutableBook() {
        if (mutableBook == null) {
            mutableBook = new MutableLiveData<>();
        }

        return mutableBook;
    }

    public LiveData<String> getMutableFindResultMessage() {
        if (mutableFindResultMessage == null) {
            mutableFindResultMessage = new MutableLiveData<>();
        }

        return mutableFindResultMessage;
    }

    public void findBookByTitle(String title) {
        if (title == null) {
            mutableFindResultMessage.setValue("Ingrese un título para buscar");

            return;
        }

        String trimmedTitle = title.trim();

        if (trimmedTitle.isEmpty()) {
            mutableFindResultMessage.setValue("El título no puede estar vacío");

            return;
        }

        String searchTitle = trimmedTitle.toLowerCase();

        Optional<BookModel> result = bookRepository.searchByTitle(searchTitle);

        if (result.isPresent()) {
            var book = result.get();

            mutableBook.setValue(book);

            /*
            El profe Pablo prefiere que usemos intents en las activities, así que trabajaré de
            esa forma, en lugar de manejar el intent acá.
            */
        } else {
            mutableFindResultMessage.setValue("No se ha encontrado el libro con el título: " + title);
        }
    }
}
