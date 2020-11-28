package com.example.appforfocus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<Valutes> responces = new ArrayList<Valutes>() {
    };

    public List<Valutes> getResponces() {
        return responces;
    }

    public void setResponces(List<Valutes> responces) {
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

        TextView textViewId;
        TextView textViewNumCode;
        TextView textViewCharCode;
        TextView textViewNominal;
        TextView textViewName;
        TextView textViewValue;
        TextView textViewPrevious;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_view_id);
            textViewNumCode = itemView.findViewById(R.id.text_view_num_code);
            textViewCharCode = itemView.findViewById(R.id.text_view_char_code);
            textViewNominal = itemView.findViewById(R.id.text_view_nominal);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewValue = itemView.findViewById(R.id.text_view_value);
            textViewPrevious = itemView.findViewById(R.id.tex_view_previous);
        }

        void bind(Valutes valutes) {
            textViewId.setText(valutes.getID());
            textViewNumCode.setText(valutes.getNumCode());
            textViewCharCode.setText(valutes.getCharCode());
            textViewNominal.setText("" + valutes.getNominal());
            textViewName.setText(valutes.getName());
            textViewValue.setText("" + valutes.getValue());
            textViewPrevious.setText("" + valutes.getPrevious());

        }
    }
}
