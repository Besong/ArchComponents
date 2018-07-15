package com.example.besong_anongernest.roomwordsample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Besong-Anong Ernest on 7/9/2018.
 */

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deletAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>>  getAllWords();
}
