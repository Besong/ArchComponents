package com.example.besong_anongernest.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Besong-Anong Ernest on 7/9/2018.
 */

@Database(entities = {Word.class}, version = 1)

public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

    //Make Database a Singleton; to prevent multiple instances of the database to be opened at the same time
    public static WordRoomDatabase getDatabase (final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){
                if (INSTANCE == null){
                    //Create database here
                    INSTANCE = Room.databaseBuilder(context,
                            WordRoomDatabase.class, "word_database").build();
                }
            }
        }

        return INSTANCE;
    }
}

