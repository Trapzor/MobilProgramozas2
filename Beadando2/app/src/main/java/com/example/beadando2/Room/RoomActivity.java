package com.example.beadando2.Room;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.beadando2.R;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    EditText roomAddText;
    Button roomAddButton;
    RecyclerView roomRView;

    WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        roomAddText = findViewById(R.id.roomEditText);
        roomAddButton = findViewById(R.id.roomAddWordButton);

        roomRView = findViewById(R.id.roomRecyclerView);

        final WordListAdapter adapter = new WordListAdapter(this);
        roomRView.setAdapter(adapter);
        roomRView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel = new ViewModelProvider(this,
                new ViewModelProvider.Factory() {
                    @NonNull
                    @Override
                    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                        return (T) new WordViewModel(getApplication());
                    }
                }).get(WordViewModel.class);

        mWordViewModel.getmAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.setWords(words);
            }
        });

        roomAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word(roomAddText.getText().toString());
                mWordViewModel.insert(word);
            }
        });
    }
}