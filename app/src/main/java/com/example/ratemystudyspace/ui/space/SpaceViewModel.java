package com.example.ratemystudyspace.ui.space;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ratemystudyspace.StudySpaceModel;

public class SpaceViewModel extends ViewModel {
    private final MutableLiveData<String> mName;
    private final MutableLiveData<Integer> mImage;
//    private final MutableLiveData<Float> mImage;

    public SpaceViewModel() {
        mName = new MutableLiveData<>();
        mImage = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mName;
    }
}