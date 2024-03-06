package com.example.subhunter;

import android.util.Log;

import java.util.Random;

public class Submarine {
    private int subHorizontalPosition;
    private int subVerticalPosition;
    private int gridWidth;
    private int gridHeight;
    private int shotsTaken;

    public Submarine(int gridWidth, int gridHeight){
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        Log.d("Test", "Test" + gridWidth + gridHeight);
        newLocation();
    }

    public void newLocation(){
        Random random = new Random();
        subHorizontalPosition = random.nextInt(gridWidth);
        subVerticalPosition = random.nextInt(gridHeight);
    }
    // Getter method for horizontal position
    public int getHorizontalPosition() {
        return subHorizontalPosition;
    }

    // Getter method for vertical position
    public int getVerticalPosition() {
        return subVerticalPosition;
    }
    void newGame() {
        Submarine sub = new Submarine(gridWidth, gridHeight);
        shotsTaken = 0;

        Log.d("Debugging", "In newGame" + gridWidth + " " + gridHeight);
    }
}