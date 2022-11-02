package com.example.workout_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class WorkoutDBManager extends SQLiteOpenHelper {
    public WorkoutDBManager(@Nullable Context context) {
        super(context, "WorkoutDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table User (" +
                "_id integer primary key autoincrement , " +
                "name text , " +
                "img text, " +
                "email text, " +
                "pass text, " +
                "workout_type text);");


        sqLiteDatabase.execSQL("create table Workout(" +
                "_id integer primary key autoincrement , " +
                "name text , " +
                "img image, " +
                "information text, " +
                "repetitions text, " +
                "user_id integer);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public SQLiteDatabase openDB(){
        SQLiteDatabase sqLiteDatabase = null;

        try {
            sqLiteDatabase = getWritableDatabase();
        }

        catch (Exception e) {

        }
        return sqLiteDatabase;
    }

    public void addUser(SQLiteDatabase sqLiteDatabase, User user)
    {
        ContentValues uservalues=new ContentValues();
        uservalues.put("name",user.Name);
        uservalues.put("img",user.Uri);
        uservalues.put("email",user.Email);
        uservalues.put("pass",user.Password);
        uservalues.put("workout_type",user.TypeOfWorkout);
        sqLiteDatabase.insert("User",null,uservalues);
    }


    public void addWorkout(SQLiteDatabase sqLiteDatabase, Workout_DB workout_db, int user_Id)
    {
        ContentValues uservalues=new ContentValues();

        uservalues.put("name",workout_db.Name);
        uservalues.put("img",workout_db.Image);
        uservalues.put("information",workout_db.Information);
        uservalues.put("repetitions",workout_db.Repetitions);
        uservalues.put("user_id",user_Id);

        sqLiteDatabase.insert("Workout",null,uservalues);

    }


    @SuppressLint("Range")
    public String match_credentials(SQLiteDatabase sqLiteDatabase, String email, String password) {

        String getTypeOfWorkout = null;
        Cursor cursor = sqLiteDatabase.rawQuery("select * from User", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex("email")).equals(email) && cursor.getString(cursor.getColumnIndex("pass")).equals(password)) {
                getTypeOfWorkout = cursor.getString(cursor.getColumnIndex("workout_type"));
            }
            cursor.moveToNext();
        }
          return  getTypeOfWorkout;
    }


    @SuppressLint("Range")
    public String get_User_Id(SQLiteDatabase sqLiteDatabase, String email, String password) {

        String id=null;
        Cursor cursor = sqLiteDatabase.rawQuery("select * from User", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex("email")).equals(email) && cursor.getString(cursor.getColumnIndex("pass")).equals(password)) {
                id = cursor.getString(cursor.getColumnIndex("_id"));
            }
                cursor.moveToNext();
        }
        return  id;
    }


    public Cursor getWorkouts(SQLiteDatabase sqLiteDatabase, int user_id){
        Cursor cursor=sqLiteDatabase.rawQuery("select * from Workout where user_id"+"="+user_id,null);
        return cursor;
    }



    public void EditWorkout(SQLiteDatabase sqLiteDatabase, Workout_DB workout_db, int user_id , int _id)
    {
        ContentValues workoutvalues=new ContentValues();

        workoutvalues.put("name",workout_db.Name);
      //  workoutvalues.put("img",workout_db.Image);
        workoutvalues.put("information",workout_db.Information);
        workoutvalues.put("repetitions",workout_db.Repetitions);

        sqLiteDatabase.update("Workout",workoutvalues,"user_id="+user_id+ " and _id="+_id,null);


    }

    public void DeleteWorkout(SQLiteDatabase sqLiteDatabase,int user_id, int _id)
    {
        sqLiteDatabase.execSQL("delete from Workout where user_id="+user_id+ " and _id="+_id);
    }



}
