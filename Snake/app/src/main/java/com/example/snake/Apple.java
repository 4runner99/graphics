package com.example.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.Random;

class Apple extends GameObject {

    /// Set up the apple in the constructor
    Apple(Context context, Point sr, int s){
        super(context, sr, s, R.drawable.apple);
    }

    // This is called every time an apple is eaten
    @Override
    public void spawn(){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
    }

    // Let SnakeGame know where the apple is
    // SnakeGame can share this with the snake
    Point getLocation(){
        return location;
    }

    // Draw the apple
    @Override
    public void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(bitmap,
                location.x * mSize, location.y * mSize, paint);
    }

}