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
        setOnClick();
        return root;
    }

    public void setOnClick(){
        binding.filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudySpaceAdapter adapter = ((MainActivity) getActivity()).getExploreAdapter();
                ArrayList<StudySpaceModel> allItems = adapter.getStudySpaceModelList();
                ArrayList<StudySpaceModel> filteredList = new ArrayList<>();
                // TODO: Do filter operations
                adapter.setStudySpaceModelList(filteredList);
                Navigation.findNavController(getView()).navigate(R.id.action_navigation_filter_to_navigation_explore);
            }
        });
    }

}