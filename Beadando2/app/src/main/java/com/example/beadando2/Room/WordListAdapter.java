package com.example.beadando2.Room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder{
        final TextView wordItemView;

        WordViewHolder(View itemView){
            super(itemView);
            wordItemView = itemView.findViewById(android.R.id.text1);
        }
    }

    private LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if(mWords != null){
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getMWord());
        }else{
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords != null)
            return mWords.size();
        else
            return 0;
    }

}
