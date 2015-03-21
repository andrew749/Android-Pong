package com.android.pong;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

public class twoplayer extends View {
	int x = 50;
	int y = 50;
	int score = 0;
	int paddlex, paddley, pg, pg2;
	int player2paddlex = 0;
	int p2x, p2y, p2h;
	private int x1 = 10;
	private int y1 = 10;
	boolean contin;
	PongandroidActivity a = new PongandroidActivity();

	public twoplayer(Context context, boolean contin, int score) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		Paint paint2 = new Paint();
		paint2.setColor(Color.CYAN);
		Paint paint3 = new Paint();
		paint3.setColor(Color.GREEN);
		Paint paint5 = new Paint();
		paint5.setColor(Color.YELLOW);
		x += x1;
		y += y1;
		if ((x + 20) > canvas.getWidth() || (x - 20) < 0) {
			x1 *= -1;
		}
		if ((y - 19) <= 0) {
			y1 = 0;
			x1 = 0;
		}
		if ((y - 20) == pg2) {
			if (((x + 20) <= pg + 30) && ((x - 20) >= paddlex - 30)) {
				y1 *= -1;
			}
		}
		if ((y + 20) == p2h) {
			if (((x + 20) <= p2x + 30) && ((x - 20) >= player2paddlex - 30)) {
				y1 *= -1;
			}
		}
		if ((y + 19) >= canvas.getHeight()) {
			y1 = 0;
			x1 = 0;

		}
		pg = paddlex + 100;
		pg2 = 20;
		p2x = player2paddlex + 100;
		p2h = (canvas.getHeight() - 20);
		p2y = canvas.getHeight();
		Rect paddle = new Rect();
		Rect player2 = new Rect();
		player2.set(player2paddlex, p2h, p2x, p2y);
		paddle.set(paddlex, 0, pg, pg2);
		canvas.drawRect(paddle, paint2);
		canvas.drawRect(player2, paint5);
		canvas.drawLine(0, (canvas.getHeight() / 2), canvas.getWidth(),
				(canvas.getHeight() / 2), paint3);
		canvas.drawCircle(x, y, 20, paint);
		Paint paint4 = new Paint();
		paint4.setColor(Color.WHITE);
		paint4.setTextSize(30);
		paint4.setStyle(Paint.Style.FILL);
		invalidate();

	}

	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			int pointerCount = event.getPointerCount();
			for (int i = 0; i < pointerCount; i++) {

				if (event.getY(i) > (p2h / 2)) {
					player2paddlex = (int) event.getX(i);
				} else if (event.getY(i) < (p2h / 2)) {
					paddlex = (int) event.getX(i);
				}
			}
			invalidate();
		}
		return true;
	}

}
