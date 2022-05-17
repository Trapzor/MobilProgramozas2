package com.example.beadando2.Room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();

    }

    LiveData<List<Word>> mAllWords;
    WordRepository mRepository;

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

}
