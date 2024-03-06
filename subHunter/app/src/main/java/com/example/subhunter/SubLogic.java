package com.example.subhunter;

public class SubLogic {

    int gridWidth;
    int gridHeight;
    int blockSize;
    int numberHorizontalPixels;
    int numberVerticalPixels;
    private float horizontalTouched;
    private float verticalTouched;
    private int horizontalGap;
    private int verticalGap;
    private int distanceFromSub;
    private boolean hit;
    Submarine sub;

    public SubLogic(int gridWidth, int gridHeight, int blockSize) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.blockSize = blockSize;
        this.numberHorizontalPixels = numberHorizontalPixels;
        this.numberVerticalPixels = numberVerticalPixels;
        this.sub = new Submarine(gridWidth, gridHeight);
    }

    public void newGame() {
        sub = new Submarine(gridWidth, gridHeight);
    }

    public boolean ifHit(float touchX, float touchY) {
        horizontalTouched = (int) touchX / blockSize;
        verticalTouched = (int) touchY / blockSize;

        // Did the shot hit the sub?
        hit = horizontalTouched == sub.getHorizontalPosition()
                && verticalTouched == sub.getVerticalPosition();

        return hit;
    }

    public int distanceFromSub(float touchX, float touchY) {
        // Convert the float screen coordinates
        // into int grid coordinates
        horizontalTouched = (int) touchX / blockSize;
        verticalTouched = (int) touchY / blockSize;
        // How far away horizontally and vertically
        // was the shot from the sub
        horizontalGap = (int) horizontalTouched -
                sub.getHorizontalPosition();
        verticalGap = (int) verticalTouched -
                sub.getVerticalPosition();

        // Use Pythagoras's theorem to get the
        // distance travelled in a straight line
        distanceFromSub = (int) Math.sqrt(
                ((horizontalGap * horizontalGap) +
                        (verticalGap * verticalGap)));
        return distanceFromSub;
    }
    public int getBlockSize() {
        blockSize = numberHorizontalPixels / gridWidth;

        return blockSize;
    }

    public float getHorizontalTouched() {
        return horizontalTouched;
    }

    public float getVerticalTouched() {
        return verticalTouched;
    }

    public int getDistanceFromSub() {
        return distanceFromSub;
    }
}