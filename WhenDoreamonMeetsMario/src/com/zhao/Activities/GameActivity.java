package com.zhao.Activities;


import com.zhao.doraemonworld.DoraemonWorld;
import com.zhao.marioworld.MarioWorld;
import com.zhao.whendoreamonmeetsmario.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.LinearLayout;


public class GameActivity extends Activity 
{
	Handler h;
	private Display display;
    public static int ScreenWidth;
    public static int ScreenHeight;
  

    public void GetScreenSize()
    {
        display = getWindowManager().getDefaultDisplay();
       // ScreenWidth = display.getWidth();
      //  ScreenHeight = display.getHeight();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        ScreenWidth = dm.widthPixels;
        ScreenHeight = dm.heightPixels/2;
    }

    public void SetScreenToFull()
    {
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
    }
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		final MarioWorld mv;
		final int gamelevel;
		final DoraemonWorld dv;
		this.SetScreenToFull();
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.gamepanel);

		Intent in=getIntent();
		gamelevel=in.getIntExtra("nextLevel", 0);
		LinearLayout l1=(LinearLayout) findViewById(R.id.v1);
		LinearLayout l2=(LinearLayout) findViewById(R.id.v2);
		mv=new MarioWorld(this,gamelevel);
		dv=new DoraemonWorld(this,gamelevel);
		l1.addView(mv);
		l2.addView(dv);
		h=new Handler();
		Runnable r=new Runnable(){

			@Override
			public void run() {
				if(mv.getPass()==0||dv.getPass()==0){
					h.postDelayed(this, 500);
				}else{
					unlock u=new unlock(GameActivity.this);
					u.setLevel(gamelevel+1);
					Intent next=new Intent(GameActivity.this,StoryActivity.class);
					
					next.putExtra("level", gamelevel+1);
					startActivity(next);
					GameActivity.this.finish();
				}
				// TODO Auto-generated method stub
			/*	while(mv.getPass()==0||dv.getPass()==0){
				
				}
				Intent next=new Intent(MarioActivity.this,StoryActivity.class);
				
				next.putExtra("level", gamelevel+1);
				startActivity(next);
				MarioActivity.this.finish();*/
	}
			
		};
		h.postDelayed(r, 500);
	}

}
