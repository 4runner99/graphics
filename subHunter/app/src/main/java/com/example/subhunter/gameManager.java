package com.example.subhunter;

import android.util.Log;

import java.util.Random;


public class gameManager {

    private int subHorizontalPosition;
    private int subVerticalPosition;

    private int shotsTaken;

    private final int gridWidth = 40;

    private final int gridHeight = 40;

    void newGame(){
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "In newGame");

    }
}
