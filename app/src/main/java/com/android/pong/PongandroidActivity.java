package com.android.pong;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class PongandroidActivity extends Activity {
	boolean continu;
	int score;
	drawball game;
	twoplayer game2;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		game = new drawball(getApplicationContext(), continu, score);
		game2=new twoplayer(getApplicationContext(),continu,score);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Button p1=new Button(this);
		Button p2=new Button(this);
		LinearLayout ll=new LinearLayout(this);
		ll.setOrientation(1);
		ll.addView(p1);
		ll.addView(p2);
		p1.setText("1 player");
		p2.setText("2 players");
		setContentView(ll);
		p1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(game);
			}
		});
		p2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(game2);

			}
		});
		

	}
	
}