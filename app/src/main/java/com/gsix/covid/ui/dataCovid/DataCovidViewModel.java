package com.gsix.covid.ui.dataCovid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataCovidViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DataCovidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}