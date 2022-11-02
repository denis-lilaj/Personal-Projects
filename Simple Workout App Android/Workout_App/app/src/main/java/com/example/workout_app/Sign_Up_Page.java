package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Sign_Up_Page extends AppCompatActivity {
    int SELECT_PICTURE = 200;

    ImageView imageView;
    EditText userName;
    EditText userEmail;
    EditText userPassword;
    Spinner typeOfWorkout;

    String getImageView;
    String getUserName;
    String getUserEmail;
    String getUserPassword;


    WorkoutDBManager workoutDBManager;
    SQLiteDatabase sqLiteDatabase;

    Button SignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        workoutDBManager = new WorkoutDBManager(getApplicationContext());
        sqLiteDatabase = workoutDBManager.openDB();

        imageView = findViewById(R.id.SignUpImage);
        userName = findViewById(R.id.UserName);
        userEmail = findViewById(R.id.UserEmail);
        userPassword = findViewById(R.id.UserPassword);
        typeOfWorkout=findViewById(R.id.Spinner);
        SignUpButton=findViewById(R.id.SignUpButton);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagechooser();
            }
        });


        SignUpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getUserName=userName.getText().toString();
                getUserEmail=userEmail.getText().toString();
                getUserPassword=userPassword.getText().toString();

              if(typeOfWorkout.getSelectedItem().toString().equals("Beginner Workout")) {
                  User user = new User(getUserName, getImageView, getUserEmail, getUserPassword, "Beginner Workout");
                  workoutDBManager.addUser(sqLiteDatabase, user);
              }

              else if(typeOfWorkout.getSelectedItem().toString().equals("Advanced Workout")) {
                  User user = new User(getUserName, getImageView, getUserEmail, getUserPassword, "Advanced Workout");
                  workoutDBManager.addUser(sqLiteDatabase, user);
              }

                Toast.makeText(getApplicationContext(),"Success! Please wait while we send you to the log in page",Toast.LENGTH_LONG).show();

                new Timer().schedule(new TimerTask(){
                    public void run() {
                        startActivity(new Intent(Sign_Up_Page.this, Log_In_Page.class));
                    }
                }, 3000 );
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
                getImageView=selectedImageUri.toString();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    Toast.makeText(getApplicationContext(), "Image Selected", Toast.LENGTH_LONG).show();
                    imageView.setImageURI(selectedImageUri);
                }
            }
        }
    }
}
