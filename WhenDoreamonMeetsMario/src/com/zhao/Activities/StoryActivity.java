package com.zhao.Activities;


import com.zhao.whendoreamonmeetsmario.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class StoryActivity extends Activity {
	int storyposition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		final ImageView story=(ImageView) findViewById(R.id.story);
		Intent i=getIntent();
		final int level;
		level=i.getIntExtra("level",0);
		//Button skip=(Button) findViewById(R.id.skip);
	/*	skip.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				startGame(level);
			}
		});
		
		*/
		if(level==0){
			story.setBackgroundResource(R.drawable.sa1);
			storyposition=R.drawable.sa1;
			story.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					storyposition++;
					if(storyposition<=R.drawable.sa4){
						story.setBackgroundResource(storyposition);
					}else{
						startGame(level);
					}
				}
			});
			
		}else if(level==1){
			startGame(level);
		}else if(level==2){
			startGame(level);
		}else if(level==3){
			
		}
		
	}
	public void startGame(int level){
		Intent in=new Intent(this,GameActivity.class);
		in.putExtra("nextLevel", level);
		startActivity(in);
		StoryActivity.this.finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.story, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
