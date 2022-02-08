package com.example.montp.ui.attestation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AttestationViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AttestationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is attestation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
