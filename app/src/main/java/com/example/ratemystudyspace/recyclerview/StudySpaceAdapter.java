package com.example.ratemystudyspace.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.StudySpaceModel;

import java.util.ArrayList;

public class StudySpaceAdapter extends RecyclerView.Adapter<StudySpaceAdapter.MyViewHolder>{

    protected Context context;
    protected RecyclerViewInterface recyclerViewInterface;

    protected ArrayList<StudySpaceModel> studySpaceModels;

    public StudySpaceAdapter(Context context, ArrayList<StudySpaceModel> studySpaceModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.studySpaceModels = studySpaceModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public StudySpaceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new StudySpaceAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull StudySpaceAdapter.MyViewHolder holder, int position) {
        holder.name.setText(studySpaceModels.get(position).getName());
        holder.rating.setRating(studySpaceModels.get(position).getRating());
        holder.location.setText(studySpaceModels.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return studySpaceModels.size();
    }

    // Allow the classes that filter the recycler view to change the list element by setting the filtered list
    public void setStudySpaceModelList(ArrayList<StudySpaceModel> newStudySpaceModels) {
        studySpaceModels.clear();
        studySpaceModels.addAll(newStudySpaceModels);
        notifyDataSetChanged();
    }

    public ArrayList<StudySpaceModel> getStudySpaceModelList(){
        return (ArrayList<StudySpaceModel>) studySpaceModels.clone();  // return a copy of the list
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, location;
        RatingBar rating;

         public MyViewHolder(@NonNull View itemView, @NonNull RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);

            // Set onclick events for items
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onClick(pos);
                    }
                }
            });
        }
    }
}
