package com.zhao.Activities;


import java.io.IOException;
import java.io.StreamCorruptedException;

import com.zhao.whendoreamonmeetsmario.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity
{
	public void SetScreenToFull()
    {
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
    }
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.SetScreenToFull();
	super.setContentView(R.layout.menu);
	unlock u=new unlock(this);
		Button s=(Button) findViewById(R.id.chapter1);
		Button s1=(Button) findViewById(R.id.chapter2);
		Button s2=(Button) findViewById(R.id.chapter3);
		s.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MenuActivity.this, StoryActivity.class);  
 
				intent.putExtra("level", 0);
				startActivity(intent);  
			}
		});
		try {
			if(u.readLevel()==0){
				s1.setBackgroundResource(R.drawable.unlock);
				s2.setBackgroundResource(R.drawable.unlock);
			}else if(u.readLevel()==1){
				s2.setBackgroundResource(R.drawable.unlock);
				s1.setOnClickListener(new OnClickListener(){
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MenuActivity.this, StoryActivity.class);  
					 
						intent.putExtra("level", 1);
						startActivity(intent);  
					}
				});
			}else{
				s2.setOnClickListener(new OnClickListener(){
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MenuActivity.this, StoryActivity.class);  
						  
						intent.putExtra("level", 2);
						startActivity(intent);  
					}
				});
				s1.setOnClickListener(new OnClickListener(){
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(MenuActivity.this, StoryActivity.class);  
						
						intent.putExtra("level", 1);
						startActivity(intent);  
					}
				});
			}
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		Button s3=(Button) findViewById(R.id.exit);
		s3.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MenuActivity.this.finish();
			}
		});
	}
	
}
