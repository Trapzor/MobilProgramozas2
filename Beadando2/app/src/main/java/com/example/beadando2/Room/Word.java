package com.example.beadando2.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    @NonNull
    public String getMWord() {
        return mWord;
    }
}
