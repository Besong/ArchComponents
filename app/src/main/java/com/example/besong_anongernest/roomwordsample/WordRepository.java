package com.example.besong_anongernest.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Besong-Anong Ernest on 7/9/2018.
 */

/**
 * Repository provides abstract access to different data sources. (Local database and network calls)
 */
public class WordRepository {
    //Member variables for data access object
    private WordDao mWordDao;

    //Member variable for list of words
    private LiveData<List<Word>> mAllWords;

    //Constructor that get handles of database operation and initialization of member variables

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    //Add wrapper for getAllWords() method
       LiveData<List<Word>> getAllWords(){
        return mAllWords;
       }
    //Add wrapper for insert() method
    //This operation is performed on a non-UI thread or app crashes

    public void insert(Word word){
           new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground( final Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
