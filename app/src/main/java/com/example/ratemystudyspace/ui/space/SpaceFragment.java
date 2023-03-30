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
import android.widget.ArrayAdapter;

import com.example.ratemystudyspace.MainActivity;
import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentSpaceOverviewBinding;
import com.example.ratemystudyspace.ui.explore.ExploreFragment;
import com.example.ratemystudyspace.ui.favorites.FavoritesFragment;
import com.example.ratemystudyspace.ui.review.ReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class SpaceFragment extends Fragment {

    private FragmentSpaceOverviewBinding binding;
    private ArrayAdapter<String> reviewAdapter;

    private Bundle args;

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
        String[] reviewsArr = getArguments().getString("reviews").split(";");
        ArrayList reviews = new ArrayList<>(Arrays.asList(reviewsArr));

        args = new Bundle();
        args.putInt("image",getArguments().getInt("image"));
        args.putString("name",getArguments().getString("name" ));
        args.putString("location",getArguments().getString("location"));
        args.putFloat("rating", getArguments().getFloat("rating"));
        args.putString("reviews",getArguments().getString("reviews"));

        reviewAdapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, reviews);
        binding.reviewList.setAdapter(reviewAdapter);
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
                String studySpaceName = getArguments().getString("name"); // Assuming image resource ID is unique for each study space
                ((MainActivity) getActivity()).addToFavorites(studySpaceName);
                ((MainActivity) getActivity()).changeBottomNavigationTab(new FavoritesFragment());
            }
        });

        // Set click listener for the addReview button
        binding.addReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeBottomNavigationTab(new ReviewFragment(),args);
            }
        });
    }
}