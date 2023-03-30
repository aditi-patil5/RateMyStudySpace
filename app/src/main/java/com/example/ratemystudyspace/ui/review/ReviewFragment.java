package com.example.ratemystudyspace.ui.review;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ratemystudyspace.MainActivity;
import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.databinding.FragmentFilterBinding;
import com.example.ratemystudyspace.ui.space.SpaceFragment;

public class ReviewFragment extends Fragment {

    private ReviewViewModel mViewModel;
    private MainActivity mainActivity;

    private Bundle args;

    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        if(mainActivity == null){
            mainActivity = (MainActivity) getActivity();
        }

        args = new Bundle();
        args.putInt("image",getArguments().getInt("image"));
        args.putString("name",getArguments().getString("name" ));
        args.putString("location",getArguments().getString("location"));
        args.putFloat("rating", getArguments().getFloat("rating"));
        args.putString("reviews",getArguments().getString("reviews"));

        Button submitBttn = view.findViewById(R.id.submit_review_add);
        submitBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeBottomNavigationTab(new SpaceFragment(),args);
            }
        });

        return view;

    }


}