package com.example.workout_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Advanced_Workout_Activity extends AppCompatActivity {

    ListView listView_Advanced_Workout;
    Advanced_Workout_Collector advanced_workout_collector;
    ArrayAdapter arrayAdapter_Advanced_Workout;
    static int visited = 0;
    Button AddNewWorkout;


    ListView getListView_Advanced_Workout_Add;
    SimpleCursorAdapter simpleCursorAdapter;
    WorkoutDBManager workoutDBManager;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;

    String user_Id_retreived;

    ImageView Log_Out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_workout);

        if (visited == 0) {
            advanced_workout_collector = new Advanced_Workout_Collector();
            visited++;
        }

        listView_Advanced_Workout = findViewById(R.id.ListView_Advanced_Workout);
        arrayAdapter_Advanced_Workout = new ArrayAdapter(getApplicationContext(), R.layout.layout_adapter_advanced_workout, R.id.Adapter_TextView_Advanced_Workout, Advanced_Workout_Collector.arrayList_Advanced_Workout);
        listView_Advanced_Workout.setAdapter(arrayAdapter_Advanced_Workout);

        listView_Advanced_Workout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Advanced_Workout_Activity.this, Show_Advanced_Workout.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        String user_Id = bundle.getString("user_Id");
        try {
            user_Id=bundle.getString("user_Id");
        } catch (Exception e)
        {
            System.out.println("Bypassing user_Id, not a crash going on if we go from Add_Workout_Activity to Beginner_Workout_Activity");
        }
        String user_Email = bundle.getString("user_Email");
        String user_Password = bundle.getString("user_Password");

        AddNewWorkout = findViewById(R.id.AddNewWorkout);
        String finalUser_Id = user_Id;
        AddNewWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Advanced_Workout_Activity.this, Add_Advanced_Workout.class);
                intent.putExtra("user_Id", finalUser_Id);
                startActivity(intent);
            }
        });

        getListView_Advanced_Workout_Add = findViewById(R.id.WorkoutAddedListView);
        workoutDBManager = new WorkoutDBManager(getApplicationContext());
        sqLiteDatabase = workoutDBManager.openDB();
        user_Id_retreived = workoutDBManager.get_User_Id(sqLiteDatabase, user_Email, user_Password);

        cursor = workoutDBManager.getWorkouts(sqLiteDatabase, Integer.parseInt(user_Id_retreived));

        simpleCursorAdapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.layout_adapter_added_workouts, cursor, new String[]{"name"}, new int[]{R.id.NameOfWorkout});
        getListView_Advanced_Workout_Add.setAdapter(simpleCursorAdapter);

        String finalUser_Id1 = user_Id;
        getListView_Advanced_Workout_Add.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @SuppressLint("Range")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = (Cursor) getListView_Advanced_Workout_Add.getItemAtPosition(i);
                String _id = cursor.getString(cursor.getColumnIndex("_id"));
                String NameOfWorkout = cursor.getString(cursor.getColumnIndex("name"));
                byte[] Uri = cursor.getBlob(cursor.getColumnIndex("img"));
                String Information = cursor.getString(cursor.getColumnIndex("information"));
                String Repetitions = cursor.getString(cursor.getColumnIndex("repetitions"));

                Intent intent = new Intent(Advanced_Workout_Activity.this, Show_Advanced_Workout_DataBase.class);
                intent.putExtra("workout_Id", _id);
                intent.putExtra("user_Id", finalUser_Id1);
                intent.putExtra("NameOfWorkout", NameOfWorkout);
                intent.putExtra("Uri", Uri);
                intent.putExtra("Information", Information);
                intent.putExtra("Repetitions", Repetitions);
                startActivity(intent);
            }
        });

        Log_Out=findViewById(R.id.LogOut);
        Log_Out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Advanced_Workout_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
      }
}
