package com.example.subhunter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class drawGraphics {

    private int numberVerticalPixels;
    private int numberHorizontalPixels;

    private int blockSize;

    private ImageView gameView;
    private Bitmap blankBitmap;
    private Canvas canvas;
    private Paint paint;

    public drawGraphics(ImageView gameView, int numberHorizontalPixels, int numberVerticalPixels) {
        this.gameView = gameView;

        // Initialize other size-based variables and objects here based on the screen resolution
        blankBitmap = Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(blankBitmap);
        paint = new Paint();
    }

    public void drawGrid(int blockSize, int gridWidth, int gridHeight) {
        gameView.setImageBitmap(blankBitmap);

        // Wipe the screen with a white color
        canvas.drawColor(Color.argb(255, 255, 255, 255));

        // Change the paint color to black
        paint.setColor(Color.argb(255, 0, 0, 0));

        // Draw the vertical lines of the grid
        for(int i = 0; i < gridWidth; i++){
            canvas.drawLine(blockSize * i, 0,
                    blockSize * i, numberVerticalPixels,
                    paint);
        }

        // Draw the horizontal lines of the grid
        for(int i = 0; i < gridHeight; i++){
            canvas.drawLine(0, blockSize * i,
                    numberHorizontalPixels, blockSize * i,
                    paint);
        }

        // Add the code for drawing the grid lines here
    }

    public void drawPlayerShot(float horizontalTouched, float verticalTouched, int blockSize) {
        canvas.drawRect(horizontalTouched * blockSize,
                verticalTouched * blockSize,
                (horizontalTouched * blockSize) + blockSize,
                (verticalTouched * blockSize)+ blockSize,
                paint );

        // Add the code for drawing the player's shot here
    }

    public void drawScoreAndDistance(int blockSize, int shotsTaken, int distanceFromSub) {
        paint.setTextSize(blockSize * 2);
        paint.setColor(Color.argb(255, 0, 0, 255));
        canvas.drawText(
                "Shots Taken: " + shotsTaken +
                        "  Distance: " + distanceFromSub,
                blockSize, blockSize * 1.75f,
                paint);
        // Add the code for drawing the score and distance text here
    }

    public void drawBoom() {
        gameView.setImageBitmap(blankBitmap);

        // Wipe the screen with a red color
        canvas.drawColor(Color.argb(255, 255, 0, 0));

        // Draw some huge white text
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setTextSize(blockSize * 10);

        canvas.drawText("BOOM!", blockSize * 4,
                blockSize * 14, paint);

        // Draw some text to prompt restarting

    }

    public void drawRestartPrompt(int blockSize) {
        paint.setTextSize(blockSize * 2);
        canvas.drawText("Take a shot to start again",
                blockSize * 8,
                blockSize * 18, paint);

        // Start a new game
        newGame();
        // Add the code for drawing the "BOOM!" message here
        // Add the code for drawing the restart prompt text here
    }

    public void drawColor(int color) {
        // Set the canvas color and draw it on the ImageView
        canvas.drawColor(color);
        gameView.setImageBitmap(blankBitmap);
    }

    public Paint getPaint() {
    }

    public Canvas getCanvas() {
    }


}
