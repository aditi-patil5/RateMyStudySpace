package com.example.ratemystudyspace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudySpaceAdapter extends RecyclerView.Adapter<StudySpaceAdapter.MyViewHolder>{

    protected Context context;
    protected ArrayList<StudySpaceModel> studySpaceModels;

    public StudySpaceAdapter(Context context, ArrayList<StudySpaceModel> studySpaceModels){
        this.context = context;
        this.studySpaceModels = studySpaceModels;
    }

    @NonNull
    @Override
    public StudySpaceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new StudySpaceAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudySpaceAdapter.MyViewHolder holder, int position) {
        holder.name.setText(studySpaceModels.get(position).getName());
        holder.rating.setText(Float.toString(studySpaceModels.get(position).getRating()));
        holder.rating.setText(studySpaceModels.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return studySpaceModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, rating, location;

         public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);
        }
    }
}
