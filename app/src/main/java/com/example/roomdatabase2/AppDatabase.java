package com.example.roomdatabase2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,UserTest.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    // Database name to be used
    //public static final String NAME = "databaseName"; zie ook MainActivity

}

