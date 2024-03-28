package com.example.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;


import java.util.ArrayList;

public abstract class GameObject implements drawable {
    protected Point location;

    // The range of values we can choose from
    // to spawn an apple
    protected Point mSpawnRange;
    protected int mSize;

    // An image to represent the apple
    protected Bitmap bitmap;

    // The location in the grid of all the segments
    protected ArrayList<Point> segmentLocations;

    // How big is each segment of the snake?
    protected int mSegmentSize;

    // How big is the entire grid
    protected Point mMoveRange;

    // Where is the centre of the screen
    // horizontally in pixels?
    protected int halfWayPoint;

    // For tracking movement Heading
    protected enum Heading {
        UP, RIGHT, DOWN, LEFT
    }

    // Start by heading to the right
    protected Heading heading = Heading.RIGHT;

    // A bitmap for each direction the head can face
    protected Bitmap mBitmapHeadRight;
    protected Bitmap mBitmapHeadLeft;
    protected Bitmap mBitmapHeadUp;
    protected Bitmap mBitmapHeadDown;

    // A bitmap for the body
    protected Bitmap mBitmapBody;


    public GameObject(Context context, Point sr, int s, int resource) {
        location = new Point();
        mSpawnRange = sr;
        mSize = s;
        bitmap = BitmapFactory.decodeResource(context.getResources(), resource);
        bitmap = Bitmap.createScaledBitmap(bitmap, s, s, false);

        // Initialize our ArrayList
        segmentLocations = new ArrayList<>();

        // Initialize the segment size and movement
        // range from the passed in parameters
        mSegmentSize = s;
        mMoveRange = sr;

        // Create and scale the bitmaps
        mBitmapHeadRight = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Create 3 more versions of the head for different headings
        mBitmapHeadLeft = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadUp = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        mBitmapHeadDown = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.head);

        // Modify the bitmaps to face the snake head
        // in the correct direction
        mBitmapHeadRight = Bitmap
                .createScaledBitmap(mBitmapHeadRight,
                        s, s, false);

        // A matrix for scaling
        Matrix matrix = new Matrix();
        matrix.preScale(-1, 1);

        mBitmapHeadLeft = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);

        // A matrix for rotating
        matrix.preRotate(-90);
        mBitmapHeadUp = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);

        // Matrix operations are cumulative
        // so rotate by 180 to face down
        matrix.preRotate(180);
        mBitmapHeadDown = Bitmap
                .createBitmap(mBitmapHeadRight,
                        0, 0, s, s, matrix, true);

        // Create and scale the body
        mBitmapBody = BitmapFactory
                .decodeResource(context.getResources(),
                        R.drawable.body);

        mBitmapBody = Bitmap
                .createScaledBitmap(mBitmapBody,
                        s, s, false);

        // The halfway point across the screen in pixels
        // Used to detect which side of screen was pressed
        halfWayPoint = sr.x * s / 2;
    }
    public void spawn() {}
    public void spawn(int w, int h) {}
}
