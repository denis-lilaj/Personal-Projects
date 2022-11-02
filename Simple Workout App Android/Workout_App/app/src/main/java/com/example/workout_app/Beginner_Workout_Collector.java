package com.example.workout_app;

import java.util.ArrayList;

public class Beginner_Workout_Collector {

    static ArrayList<Workout> arrayList_Beginner_Workout=new ArrayList<>();

    Beginner_Workout_Collector(){
        arrayList_Beginner_Workout.add(new Workout("Squats",R.drawable.squats,"Stand with your feet shoulder-width apart, toes slightly out, core braced, and chest up. Initiate a basic squat movement — hips back, knees bent, ensuring they fall out, not in. Pause when your thighs reach about parallel to the ground. Push through your entire foot to return to start.",10));
        arrayList_Beginner_Workout.add(new Workout("Push-Ups",R.drawable.pushups,"Lie down on the floor face down, with hands slightly wider than shoulder-width. Keep your body straight and raise it by extending your arms. Lower body to the floor by bending your arm and pushing it back up by extending the arm",10));
        arrayList_Beginner_Workout.add(new Workout("Sit-Ups",R.drawable.situps,"Lie on your back, with knees bent and feet firmly on the ground. Place your hands behind your head, or place each hand on the opposite shoulder, so arms cross over the front of your body. Slowly lift your upper body off the ground, keeping your chin tucked into your chest as you do so. Lift your body up towards your thighs, so you're essentially sitting upright. Get back to the ground using that position and repeat",10));
        arrayList_Beginner_Workout.add(new Workout("Bicep Curls",R.drawable.bicepcurls,"Sitting or standing, hold a pair of dumbbells by your side, palms facing forward. Bend your elbow, pulling your hand(s) towards your shoulder slowly and with control. Your upper arm and wrist should stay still; only move your forearm from the elbow joint. Curl all the way up, leaving a little space between your hands and shoulders. Pause, and lower down slowly all the way to the bottom.",10));
        arrayList_Beginner_Workout.add(new Workout("Tricep Dips",R.drawable.tricepdips,"Place your hands behind you onto a chair, so that your fingers face forward and extend your legs as well as start bending your elbows.Then, lower your body until your arms are at a 90-degree angle and lift your body back up until your arms are straight. Repeat",10));
    }
}
