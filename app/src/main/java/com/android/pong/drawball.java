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

public class drawball extends View {
	int x = 50;
	int y = 50;
	int score = 0;
	int paddlex, paddley, pg, pg2;
	private int x1 = 10;
	private int y1 = 10;
	boolean contin;

	PongandroidActivity a = new PongandroidActivity();

	public drawball(Context context, boolean contin, int score) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		Paint paint2 = new Paint();
		paint2.setColor(Color.CYAN);
		x += x1;
		y += y1;
		if ((x + 20) > canvas.getWidth() || (x - 20) < 0) {
			x1 *= -1;
		}
		if ((y + 20) > canvas.getHeight() || (y - 20) < 0) {
			y1 *= -1;
		}
		if ((y - 19) <= 0) {
			y1 = 0;
			x1 = 0;
			contin = true;
		}
		if ((y - 20) == pg2) {
			if (((x + 20) <= pg + 30) && ((x - 20) >= paddlex - 30)) {
				y1 *= -1;
				++score;
			}
		}

		/**
		 * pg = paddlex + (canvas.getWidth()/4); pg2 = canvas.getHeight()/20;
		 **/
		// optimized code
		pg = paddlex + 100;
		pg2 = 20;
		// draws
		Rect paddle = new Rect();
		paddle.set(paddlex, 0, pg, pg2);
		canvas.drawRect(paddle, paint2);
		canvas.drawCircle(x, y, 20, paint);
		Paint paint4 = new Paint();
		paint4.setColor(Color.WHITE);
		paint4.setTextSize(30);
		paint4.setStyle(Paint.Style.FILL);
		canvas.drawText("Score: " + score, (canvas.getWidth() - 150),
				(canvas.getHeight() - 30), paint4);
		invalidate();

	}

	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE: {
			paddlex = (int) (event.getX() - 50);
			break;
		}
		}
		return true;
	}

	public void openDialog(int score) {
		try {
			AlertDialog ad = new AlertDialog.Builder(a.getApplicationContext())
					.create();
			ad.setMessage("Your score is " + score);
			ad.setButton("Restart", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Intent i = new Intent(a.getApplicationContext(),
							PongandroidActivity.class);
					a.startActivity(i);
					a.finish();
				}
			});
			ad.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
