package com.example.ratemystudyspace.ui.filter;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.databinding.FragmentExploreBinding;
import com.example.ratemystudyspace.databinding.FragmentFilterBinding;
import com.example.ratemystudyspace.ui.explore.ExploreViewModel;

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
                // TODO: Do filter operations

                // TODO: remove these
                System.out.println(exploreViewModel.getText().getValue());
                exploreViewModel.setText("Filter is making changes");
                System.out.println(exploreViewModel.getText().getValue());
            }
        });
    }

}