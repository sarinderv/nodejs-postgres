package com.cmpe277.hackathon.mainactivity.ui.macroeconomic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MacroeconomicViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MacroeconomicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Macroeconomic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}