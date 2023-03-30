package com.example.ratemystudyspace.ui.filter;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ratemystudyspace.MainActivity;
import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentFilterBinding;
import com.example.ratemystudyspace.recyclerview.StudySpaceAdapter;
import com.example.ratemystudyspace.ui.explore.ExploreFragment;
import com.example.ratemystudyspace.ui.explore.ExploreViewModel;

import java.util.ArrayList;

public class FilterFragment extends Fragment {

    private ExploreViewModel exploreViewModel;

    private FragmentFilterBinding binding;

    public static FilterFragment newInstance() {
        return new FilterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFilterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);
        setOnClickFilter();
        return root;
    }

    public void setOnClickFilter(){
        binding.filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudySpaceAdapter adapter = ((MainActivity) getActivity()).getExploreAdapter();
                adapter.resetListToDefault();  // reset data to contain all the data (if we apply filter multiple times)
                ArrayList<StudySpaceModel> allItems = adapter.getStudySpaceModelList();
                ArrayList<StudySpaceModel> filteredList = new ArrayList<>();
                applyFilters(allItems,filteredList);
                adapter.setStudySpaceModelList(filteredList);
                ((MainActivity)getActivity()).changeBottomNavigationTab(new ExploreFragment());
            }
        });
    }

    private ArrayList<StudySpaceModel> applyFilters(ArrayList<StudySpaceModel> allData,ArrayList<StudySpaceModel> filteredList){
        boolean loud = binding.filterNoiseOption1.isChecked();
        boolean medium = binding.filterNoiseOption2.isChecked();
        boolean quiet = binding.filterNoiseOption3.isChecked();
        boolean groupStudy = binding.filterTypestudyOption1.isChecked();
        boolean individualStudy = binding.filterTypestudyOption2.isChecked();
        boolean naturalLight = binding.filterAmenityOption1.isChecked();
        boolean outlet = binding.filterAmenityOption2.isChecked();
        boolean whiteboard = binding.filterAmenityOption3.isChecked();
        float rating = binding.ratingBar.getRating();

        for(StudySpaceModel space : allData){
            if(loud && space.isLoud()){
                filteredList.add(space);
                continue;
            }
            if(quiet &&  space.isQuiet()){
                filteredList.add(space);
                continue;
            }
            if(medium && space.isMedium()){
                filteredList.add(space);
                continue;
            }
            if(naturalLight && space.isNaturalLight()){
                filteredList.add(space);
                continue;
            }
            if(outlet && space.isOutlets()){
                filteredList.add(space);
                continue;
            }
            if(whiteboard && space.isWhiteboards()){
                filteredList.add(space);
                continue;
            }
            if(groupStudy && !space.isIndividual()){
                filteredList.add(space);
                continue;
            }
            if(individualStudy && space.isIndividual()){
                filteredList.add(space);
                continue;
            }
            if((rating != 0.0) && (space.getRating() >= rating)){
                filteredList.add(space);
                continue;
            }
        }
        return filteredList;
    }

}