package com.example.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public abstract class GameObject {
    protected Point location;

    // The range of values we can choose from
    // to spawn an apple
    protected Point mSpawnRange;
    protected int mSize;

    // An image to represent the apple
    protected Bitmap bitmap;


    public GameObject(Context context, Point sr, int s, int resource) {
        location = new Point();
        mSpawnRange = sr;
        mSize = s;
        bitmap = BitmapFactory.decodeResource(context.getResources(), resource);
        bitmap = Bitmap.createScaledBitmap(bitmap, s, s, false);

    }

    // Draw the apple
    abstract void draw(Canvas canvas, Paint paint);

    abstract void spawn();
}
