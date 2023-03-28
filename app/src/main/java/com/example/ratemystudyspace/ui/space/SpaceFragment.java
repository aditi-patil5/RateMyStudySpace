package com.example.ratemystudyspace.ui.space;

import androidx.fragment.app.FragmentTransaction;
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
import com.example.ratemystudyspace.databinding.FragmentSpaceOverviewBinding;
import com.example.ratemystudyspace.ui.explore.ExploreFragment;
import com.example.ratemystudyspace.ui.favorites.FavoritesFragment;
import com.example.ratemystudyspace.ui.review.ReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SpaceFragment extends Fragment {

    private FragmentSpaceOverviewBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SpaceViewModel spaceViewModel =
                new ViewModelProvider(this).get(SpaceViewModel.class);

        binding = FragmentSpaceOverviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.imageSpace.setImageResource(getArguments().getInt("image"));
        binding.titleSpace.setText(getArguments().getString("name"));
        binding.locationSpace.setText(getArguments().getString("location"));
        binding.ratingBar.setRating(getArguments().getFloat("rating"));
        setOnClickEventForButtons();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setOnClickEventForButtons(){
        binding.addFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeBottomNavigationTab(new FavoritesFragment());
            }
        });

        // Set click listener for the addReview button
        binding.addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeBottomNavigationTab(new ReviewFragment());
            }
        });

    }
}