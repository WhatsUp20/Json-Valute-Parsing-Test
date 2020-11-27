package com.example.appforfocus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appforfocus.focus.CurrencyResponce;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<CurrencyResponce> responces = new ArrayList<>();

    public List<CurrencyResponce> getPosts() {
        return responces;
    }

    public void setResponces(List<CurrencyResponce> posts) {
        this.responces = responces;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(responces.get(position));
    }

    @Override
    public int getItemCount() {
        return responces.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        TextView textViewUserId;
        TextView textViewId;
        TextView textViewTitle;
        TextView textViewBody;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUserId = itemView.findViewById(R.id.text_view_user_id);
            textViewId = itemView.findViewById(R.id.text_view_id);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewBody = itemView.findViewById(R.id.text_view_body);
        }

        void bind(CurrencyResponce responce) {
            textViewUserId.setText("" + responce.getDate());
            textViewId.setText(""+ responce.getPreviousDate());
            textViewTitle.setText(responce.getPreviousURL());
            textViewBody.setText(responce.getTimestamp());
        }
    }
}
