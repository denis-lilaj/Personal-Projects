package com.example.workout_app;

import android.net.Uri;

public class User {
    String Name;
    String Uri;
    String Email;
    String Password;
    String TypeOfWorkout;

    public User(String name, String uri, String email, String password, String typeOfWorkout) {
        Name = name;
        Uri = uri;
        Email = email;
        Password = password;
        TypeOfWorkout = typeOfWorkout;
    }
}
