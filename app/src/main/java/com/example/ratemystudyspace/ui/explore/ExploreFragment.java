package com.example.ratemystudyspace.ui.explore;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.recyclerview.RecyclerViewInterface;
import com.example.ratemystudyspace.recyclerview.StudySpaceAdapter;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentExploreBinding;

import java.util.ArrayList;

public class ExploreFragment extends Fragment implements RecyclerViewInterface {

    private FragmentExploreBinding binding;
    private ArrayList<StudySpaceModel> studySpaceModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExploreViewModel exploreViewModel =
                new ViewModelProvider(this).get(ExploreViewModel.class);

        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up recycler view and StudySpaceFragment model
        Context context = getContext();
        RecyclerView recyclerViewExplore = binding.recyclerView;
        if(studySpaceModels == null){
            studySpaceModels = new ArrayList<>();
            setUpStudySpaceModel();
        }
        StudySpaceAdapter adapterView = new StudySpaceAdapter(context, studySpaceModels, this);
        recyclerViewExplore.setAdapter(adapterView);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(context));

//        final TextView textView = binding.textNotifications;
//        exploreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    protected void setUpStudySpaceModel(){
        int[] images = {R.drawable.lind_hall,R.drawable.wise_owl_cafe,R.drawable.toaster};
        String names[] = getResources().getStringArray(R.array.name_list);
        String locations[] = getResources().getStringArray(R.array.location_list);
        String ratings[] = getResources().getStringArray(R.array.rating_list);

        for(int i =0; i < names.length; i++){
            studySpaceModels.add(new StudySpaceModel(names[i],
                    locations[i],
                    Float.parseFloat(ratings[i]),
                    images[i]));
        }
    }

    @Override
    public void onClick(int position) {
        StudySpaceModel model = studySpaceModels.get(position);
        Bundle arguments = new Bundle();
        arguments.putInt("image",model.getImageMain());
        arguments.putFloat("rating",model.getRating());
        arguments.putString("name", model.getName());
        arguments.putString("location", model.getLocation());
        Navigation.findNavController(getView()).navigate(R.id.action_navigation_explore_to_spaceOverview,arguments);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}