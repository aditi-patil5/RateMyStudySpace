package com.example.ratemystudyspace.ui.explore;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
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

import com.example.ratemystudyspace.MainActivity;
import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.recyclerview.RecyclerViewInterface;
import com.example.ratemystudyspace.recyclerview.StudySpaceAdapter;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentExploreBinding;
import com.example.ratemystudyspace.ui.filter.FilterFragment;
import com.example.ratemystudyspace.ui.space.SpaceFragment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class ExploreFragment extends Fragment implements RecyclerViewInterface {

    private FragmentExploreBinding binding;
    private StudySpaceAdapter adapterView;
    private ArrayList<StudySpaceModel> studySpaceModels;

    private MainActivity mainActivity;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExploreViewModel exploreViewModel =
                new ViewModelProvider(this).get(ExploreViewModel.class);

        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if(mainActivity == null){
            mainActivity = (MainActivity) getActivity();
        }

        // Set up recycler view and StudySpaceFragment model
        Context context = getContext();
        RecyclerView recyclerViewExplore = binding.recyclerView;
        if(studySpaceModels == null){
            studySpaceModels = new ArrayList<>();
            setUpStudySpaceModel();
        }

        this.adapterView = ((MainActivity) getActivity()).getExploreAdapter();
        if(this.adapterView == null) {              // if the main activity's adapter is not initialized then initialize it
            setUpAdapter(context);                  // note: this should be performed only once
        }

        recyclerViewExplore.setAdapter(this.adapterView);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(context));

        setOnClickEventForButtons();
        return root;
    }

    private void setUpAdapter(Context context){
        this.adapterView = new StudySpaceAdapter(context, studySpaceModels, this);
        mainActivity.setExploreAdapter(adapterView);
    }

    protected void setUpStudySpaceModel(){
        int[] images = {R.drawable.lind_hall,R.drawable.wise_owl_cafe,R.drawable.toaster};
        String names[] = getResources().getStringArray(R.array.name_list);
        String locations[] = getResources().getStringArray(R.array.location_list);
        String ratings[] = getResources().getStringArray(R.array.rating_list);
        TypedArray reviews=  getResources().obtainTypedArray(R.array.reviews_list);
        TypedArray whiteboard = getResources().obtainTypedArray(R.array.whiteboard);
        TypedArray outlets = getResources().obtainTypedArray(R.array.outlets);
        TypedArray naturalLight = getResources().obtainTypedArray(R.array.natural_light);
        TypedArray loud = getResources().obtainTypedArray(R.array.loud);
        TypedArray medium = getResources().obtainTypedArray(R.array.medium);
        TypedArray quiet = getResources().obtainTypedArray(R.array.quiet);
        TypedArray isIndividual = getResources().obtainTypedArray(R.array.is_individual);

        for(int i =0; i < names.length; i++){
            int resId = reviews.getResourceId(i,-1);
            if(resId >= 0){
                ArrayList<String> review = new ArrayList<>(Arrays.asList(getResources().getStringArray(resId)));
                studySpaceModels.add(new StudySpaceModel(names[i],
                        locations[i],
                        Float.parseFloat(ratings[i]),
                        images[i],
                        review,
                        loud.getBoolean(i, false),
                        medium.getBoolean(i, false),
                        quiet.getBoolean(i, false),
                        isIndividual.getBoolean(i, true),
                        naturalLight.getBoolean(i, false),
                        whiteboard.getBoolean(i, false),
                        outlets.getBoolean(i, false)
                ));
            }
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
        arguments.putString("reviews", model.getReviewsString());
        mainActivity.changeBottomNavigationTab(new SpaceFragment(),arguments);

    }
    public void setOnClickEventForButtons(){
        binding.gotoFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeBottomNavigationTab(new FilterFragment());
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}