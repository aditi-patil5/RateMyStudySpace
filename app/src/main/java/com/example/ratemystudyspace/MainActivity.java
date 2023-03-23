package com.example.ratemystudyspace;

import android.os.Bundle;

import com.example.ratemystudyspace.ui.explore.ExploreFragment;
import com.example.ratemystudyspace.ui.favorites.FavoritesFragment;
import com.example.ratemystudyspace.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ratemystudyspace.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView navView;
    private ArrayList<StudySpaceModel> studySpaceModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_explore)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Set up recycler view and StudySpaceFragment model
        RecyclerView recyclerViewExplore = findViewById(R.id.recycler_view);
        setUpStudySpaceModel();
        StudySpaceAdapter adapterView = new StudySpaceAdapter(this, studySpaceModels);
        recyclerViewExplore.setAdapter(adapterView);
        recyclerViewExplore.setLayoutManager(new LinearLayoutManager(this));
    }

    public void changeBottomNavigationTab(Object objType){
        if(objType instanceof ExploreFragment){
            navView.setSelectedItemId(R.id.navigation_explore);
        }
        else if(objType instanceof FavoritesFragment){
            navView.setSelectedItemId(R.id.navigation_favorites);
        }
        else if(objType instanceof HomeFragment){
            System.out.println("Already on Homepage ");
        }
        else {
            System.out.println("Invalid class type");
        }
    }

    protected void setUpStudySpaceModel(){
        String names[] = getResources().getStringArray(R.id.name_list);
        String locations[] = getResources().getStringArray(R.id.location_list);
        float ratings[] = getResources().getStringArray(R.id.rating_list);

        for(int i =0; i < names.length; i++){
            studySpaceModels.add(new StudySpaceModel(names[i], locations[i], ratings[i]));
        }
    }

}