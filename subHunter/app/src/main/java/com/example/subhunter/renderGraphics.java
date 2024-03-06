package com.example.subhunter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class renderGraphics {
    private Bitmap blankBitmap;
    private Canvas canvas;
    private Paint paint;
    private int blockSize;
    private int gridWidth;
    private int gridHeight;
    private int numberHorizontalPixels;
    private int numberVerticalPixels;
    private ImageView gameView;

    public renderGraphics(int numberHorizontalPixels, int numberVerticalPixels, int blockSize, int gridWidth) {
        this.setNumberHorizontalPixels(numberHorizontalPixels);
        this.setNumberVerticalPixels(numberVerticalPixels);
        this.setBlockSize(blockSize);
        this.setGridWidth(gridWidth);

        setBlankBitmap(Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888));
        setCanvas(new Canvas(getBlankBitmap()));
        setPaint(new Paint());
    }

    public Bitmap drawGrid() {
        getCanvas().drawColor(Color.argb(255, 255, 255, 255));

        // Change the paint color to black
        getPaint().setColor(Color.argb(255, 0, 0, 0));

        // Draw the vertical lines of the grid
        for (int i = 0; i < getGridWidth(); i++) {
            getCanvas().drawLine(getBlockSize() * i, 0,
                    getBlockSize() * i, getNumberVerticalPixels(),
                    getPaint());
        }

        // Draw the horizontal lines of the grid
        setGridHeight(getNumberVerticalPixels() / getBlockSize());
        for (int i = 0; i < getGridHeight(); i++) {
            getCanvas().drawLine(0, getBlockSize() * i,
                    getNumberHorizontalPixels(), getBlockSize() * i,
                    getPaint());
        }

        return getBlankBitmap();
    }

    public void drawPlayerShot(float horizontalTouched, float verticalTouched, int distanceFromSub, int shotsTaken) {
        getCanvas().drawRect(horizontalTouched * getBlockSize(),
                verticalTouched * getBlockSize(),
                (horizontalTouched * getBlockSize()) + getBlockSize(),
                (verticalTouched * getBlockSize()) + getBlockSize(),
                getPaint());

        // Re-size the text appropriate for the score and distance text
        getPaint().setTextSize(getBlockSize() * 2);
        getPaint().setColor(Color.argb(255, 0, 0, 255));
        getCanvas().drawText(
                "Shots Taken: " + shotsTaken +
                        "  Distance: " + distanceFromSub,
                getBlockSize(), getBlockSize() * 1.75f,
                getPaint());
    }

    public Bitmap showBoomscreen (){


        // Wipe the screen with a red color
        getCanvas().drawColor(Color.argb(255, 255, 0, 0));

        // Draw some huge white text
        getPaint().setColor(Color.argb(255, 255, 255, 255));
        getPaint().setTextSize(getBlockSize() * 10);

        getCanvas().drawText("BOOM!", getBlockSize() * 4,
                getBlockSize() * 14, getPaint());

        // Draw some text to prompt restarting
        getPaint().setTextSize(getBlockSize() * 2);
        getCanvas().drawText("Take a shot to start again",
                getBlockSize() * 8,
                getBlockSize() * 18, getPaint());


        return getBlankBitmap();

    }

    public Bitmap getBlankBitmap() {
        return blankBitmap;
    }

    public void setBlankBitmap(Bitmap blankBitmap) {
        this.blankBitmap = blankBitmap;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }

    public int getNumberHorizontalPixels() {
        return numberHorizontalPixels;
    }

    public void setNumberHorizontalPixels(int numberHorizontalPixels) {
        this.numberHorizontalPixels = numberHorizontalPixels;
    }

    public int getNumberVerticalPixels() {
        return numberVerticalPixels;
    }

    public void setNumberVerticalPixels(int numberVerticalPixels) {
        this.numberVerticalPixels = numberVerticalPixels;
    }

    public ImageView getGameView() {
        return gameView;
    }

    public void setGameView(ImageView gameView) {
        this.gameView = gameView;
    }
}