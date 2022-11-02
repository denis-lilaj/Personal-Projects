package com.example.workout_app;

public class Workout {
    String Name;
    int Image;
    String Information;
    int Repetitions;

    public Workout(String name, int image, String information, int repetitions) {
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
