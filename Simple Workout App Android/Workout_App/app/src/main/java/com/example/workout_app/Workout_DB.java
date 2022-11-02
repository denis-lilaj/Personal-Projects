package com.example.workout_app;

import android.graphics.Bitmap;

public class Workout_DB {
    String Name;
    byte[] Image;
    String Information;
    String Repetitions;

    public Workout_DB(String name, byte[] image, String information, String repetitions) {
        Name = name;
        Image = image;
        Information = information;
        Repetitions = repetitions;
    }

    @Override
    public String toString() {
        return Name;
    }
}
