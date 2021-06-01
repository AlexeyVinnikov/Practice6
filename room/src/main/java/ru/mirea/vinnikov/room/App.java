package ru.mirea.vinnikov.room;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static ru.mirea.vinnikov.room.App instance;
    private ru.mirea.vinnikov.room.AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, ru.mirea.vinnikov.room.AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static ru.mirea.vinnikov.room.App getInstance() {
        return instance;
    }
    public ru.mirea.vinnikov.room.AppDatabase getDatabase() {
        return database;
    }
}
