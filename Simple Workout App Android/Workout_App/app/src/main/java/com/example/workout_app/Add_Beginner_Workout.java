package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Add_Beginner_Workout extends AppCompatActivity {

    String user_Id;

    String getWorkoutName;
    String getWorkoutImage;
    Bitmap getWorkoutImageBitmap;
    byte[] getWorkoutImageBytes;
    String getWorkoutInformation;
    String getWorkoutRepetitions;

    WorkoutDBManager workoutDBManager;
    SQLiteDatabase sqLiteDatabase;

    ImageView ImagePreview;
    Button ImageChooser;
    int SELECT_PICTURE = 200;
    Button Add_Beginner_Workout;


    EditText AddWorkoutName;
    EditText AddWorkoutInformation;
    EditText AddWorkoutRepetitions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beginner_workout);

        workoutDBManager = new WorkoutDBManager(getApplicationContext());
        sqLiteDatabase = workoutDBManager.openDB();

        ImageChooser = findViewById(R.id.ImageButtonSelector);
        ImagePreview = findViewById(R.id.ImagePreview);

        ImageChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });

        AddWorkoutName = findViewById(R.id.AddWorkoutName);
        AddWorkoutInformation = findViewById(R.id.AddWorkoutInformation);
        AddWorkoutRepetitions = findViewById(R.id.AddRepetitions);

        Add_Beginner_Workout = findViewById(R.id.AddWorkoutButton);

        Bundle bundle = getIntent().getExtras();
        user_Id = bundle.getString("user_Id");

        Add_Beginner_Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWorkoutName = AddWorkoutName.getText().toString();
                getWorkoutInformation = AddWorkoutInformation.getText().toString();
                getWorkoutRepetitions = AddWorkoutRepetitions.getText().toString();

                if (!getWorkoutName.equals("") && !getWorkoutInformation.equals("") && !getWorkoutRepetitions.equals("") && getWorkoutImage != null) {
                    Workout_DB workout_db = new Workout_DB(getWorkoutName, getWorkoutImageBytes, getWorkoutInformation, getWorkoutRepetitions);
                    workoutDBManager.addWorkout(sqLiteDatabase, workout_db, Integer.parseInt(user_Id));

                    Toast.makeText(getApplicationContext(), "Workout added successfully! Redirecting...", Toast.LENGTH_LONG).show();

                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            startActivity(new Intent(Add_Beginner_Workout.this, Beginner_Workout_Activity.class));
                        }
                    }, 3000);

                }

                if (getWorkoutName.equals("") || getWorkoutInformation.equals("") || getWorkoutRepetitions.equals("") || getWorkoutImage == null) {
                    Toast.makeText(getApplicationContext(), "Please complete all fields and add an image as well!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    void imagechooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();

                if (null != selectedImageUri) {

                    try {
                        getWorkoutImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        getWorkoutImageBytes=getBytes(getWorkoutImageBitmap);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    getWorkoutImage = selectedImageUri.toString();
                    Toast.makeText(getApplicationContext(), "Image Selected", Toast.LENGTH_LONG).show();
                    ImagePreview.setImageBitmap(getWorkoutImageBitmap);

                }
            }
        }
    }

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, stream);
        return stream.toByteArray();
    }
}


