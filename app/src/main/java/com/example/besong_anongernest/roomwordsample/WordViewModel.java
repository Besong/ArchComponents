package com.example.besong_anongernest.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Besong-Anong Ernest on 7/9/2018.
 */

//Provides data to the UI and survive configuration changes
public class WordViewModel extends AndroidViewModel {

    //Member variable to hold reference to Repository
    private WordRepository mRepository;

    //Live Data private member variable to cache list of words
    private LiveData<List<Word>> mAllWords;

    //Constructor to get reference to Repository and list of words
    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }
    //Getter method for all list of words. This hides implementation from the UI
    LiveData<List<Word>> getAllWords(){
        return this.mAllWords;
    }
    //Wrapper Repository insert method. This hides implementation from the UI
    public void insert(Word word) { mRepository.insert(word); }

}
