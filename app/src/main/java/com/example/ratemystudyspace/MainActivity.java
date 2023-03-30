package com.example.ratemystudyspace;
import java.util.HashSet;

import android.os.Bundle;

import com.example.ratemystudyspace.databinding.ActivityMainBinding;
import com.example.ratemystudyspace.recyclerview.StudySpaceAdapter;
import com.example.ratemystudyspace.ui.add.AddFragment;
import com.example.ratemystudyspace.ui.explore.ExploreFragment;
import com.example.ratemystudyspace.ui.favorites.FavoritesFragment;
import com.example.ratemystudyspace.ui.filter.FilterFragment;
import com.example.ratemystudyspace.ui.home.HomeFragment;
import com.example.ratemystudyspace.ui.review.ReviewFragment;
import com.example.ratemystudyspace.ui.space.SpaceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private HashSet<String> favoriteStudySpaces = new HashSet<>();
    private ActivityMainBinding binding;
    private BottomNavigationView navView;

    private StudySpaceAdapter exploreAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_favorites, R.id.navigation_explore, R.id.navigation_review, R.id.navigation_filter)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
    public void addToFavorites(String studySpaceId) {
        favoriteStudySpaces.add(studySpaceId);
    }

    public HashSet<String> getFavoriteStudySpaces() {
        return favoriteStudySpaces;
    }
    public void changeBottomNavigationTab(Object objType){
        if(objType instanceof ExploreFragment){
            navView.setSelectedItemId(R.id.navigation_explore);
        }
        else if(objType instanceof FavoritesFragment){
            navView.setSelectedItemId(R.id.navigation_favorites);
        }
        // new
        else if(objType instanceof ReviewFragment){
            navView.setSelectedItemId(R.id.navigation_review);
        }
        else if(objType instanceof FilterFragment){
            navView.setSelectedItemId(R.id.navigation_filter);
        }
        else if(objType instanceof HomeFragment){
            System.out.println("Already on Homepage ");
        }
        else {
            System.out.println("Invalid class type");
        }
    }

    public void changeBottomNavigationTab(Object objType, Bundle args){
        if(objType instanceof SpaceFragment){
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.spaceOverview, args);
        }
        else if(objType instanceof ReviewFragment){
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.navigation_review,args);
        }
        else {
            System.out.println("Invalid class type");
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.navigateUp();
    }

    public void setExploreAdapter(StudySpaceAdapter exploreAdapter){
        this.exploreAdapter = exploreAdapter;
    }

    public StudySpaceAdapter getExploreAdapter(){
        return this.exploreAdapter;
    }
}