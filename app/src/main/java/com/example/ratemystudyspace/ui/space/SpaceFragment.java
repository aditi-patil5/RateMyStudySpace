package com.example.ratemystudyspace.ui.space;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentSpaceOverviewBinding;

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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}