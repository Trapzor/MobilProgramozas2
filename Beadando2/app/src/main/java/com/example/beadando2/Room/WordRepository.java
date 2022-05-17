package com.example.beadando2.Room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Context context){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(context);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getAllWords(){
            return mAllWords;
    }

    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }

}


