package com.example.snake;
import android.graphics.Canvas;
import android.graphics.Paint;
public interface GameState {

    void spawn();

    void spawn(int w, int h);

    void draw(Canvas canvas, Paint paint);

}
