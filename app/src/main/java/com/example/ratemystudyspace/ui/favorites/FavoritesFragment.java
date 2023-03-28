package com.example.ratemystudyspace.ui.favorites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratemystudyspace.MainActivity;
import com.example.ratemystudyspace.R;
import com.example.ratemystudyspace.StudySpaceModel;
import com.example.ratemystudyspace.databinding.FragmentFavoritesBinding;
import com.example.ratemystudyspace.recyclerview.RecyclerViewInterface;
import com.example.ratemystudyspace.recyclerview.StudySpaceAdapter;
import com.example.ratemystudyspace.ui.explore.ExploreFragment;

import java.util.ArrayList;

public class FavoritesFragment extends Fragment implements RecyclerViewInterface {

    private FragmentFavoritesBinding binding;
    private ArrayList<StudySpaceModel> studySpaceModels;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel =
                new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        favoritesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Set up recycler view and StudySpaceFragment model
        Context context = getContext();
        RecyclerView recyclerViewFavorites = binding.mRecyclerView;
        if(studySpaceModels == null){
            studySpaceModels = new ArrayList<>();
            setUpStudySpaceModel();
        }
        StudySpaceAdapter adapterView = new StudySpaceAdapter(context, studySpaceModels, this);
        recyclerViewFavorites.setAdapter(adapterView);
        recyclerViewFavorites.setLayoutManager(new LinearLayoutManager(context));

        setOnClickEventForButtons();
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
        Navigation.findNavController(getView()).navigate(R.id.action_navigation_favorites_to_spaceOverview,arguments);

    }

    public void setOnClickEventForButtons(){
        binding.addFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).changeBottomNavigationTab(new ExploreFragment());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}