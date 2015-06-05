package com.zhao.Activities;

import Util.Image;

import java.util.ArrayList;

import com.zhao.whendoreamonmeetsmario.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class  LoadResourceOfDore 
{
	
	public static ArrayList <Bitmap>mario = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>enemy = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>coin = new ArrayList<Bitmap>();

	
	public static ArrayList <Bitmap>food = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>map = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>tile = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>weapon = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>ui = new ArrayList<Bitmap>();
	
	public static ArrayList <Bitmap>button = new ArrayList<Bitmap>();
	
	public  static Bitmap ladder ;
	
	public static int temp;
	


	public static int musicID[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
	
	
	
	public static void LoadImage(Context context)
	{
		try
		{
			for(int i=1; i<=14; i++)
			{
				mario.add(BitmapFactory.decodeStream(context.getAssets().open("doraemon/mario" + i + ".png")));
				temp++;
			}
			
			for(int i=1; i<=14; i++)
			{
				enemy.add(BitmapFactory.decodeStream(context.getAssets().open("denemy/enemy" + i + ".png")));
				temp++;
			}
			
			for(int i=1; i<=4; i++)
			{
				 coin.add(BitmapFactory.decodeStream(context.getAssets().open("coin/coin" + i + ".png")));
				 temp++;
			}
		
			
			for(int i=1; i<=3; i++)
			{
				 food.add(BitmapFactory.decodeStream(context.getAssets().open("dfood/food" + i + ".png")));
				 temp++;
			}
			
			for(int i=1; i<=4; i++)
			{
				Bitmap m = BitmapFactory.decodeStream(context.getAssets().open("dmap/map" + i +".png"));
				m = Image.FitTheScreenSizeImage(m, LoadActivity.ScreenWidth, LoadActivity.ScreenHeight);
				map.add(m);
				temp++;
			}
			
			for(int i=1; i<=35; i++)
			{
				tile.add(BitmapFactory.decodeStream(context.getAssets().open("dtile/tile" + i + ".png")));
				temp++;
			}
			
			for(int i=1; i<=2; i++)
			{
				weapon.add(BitmapFactory.decodeStream(context.getAssets().open("weapon/weapon" + i + ".png")));
				temp++;
			}
			

			for(int i=1; i<=2; i++)
			{
				 ui.add(BitmapFactory.decodeStream(context.getAssets().open("ui/ui" + i + ".png")));
				 temp++;
			}
			
			for(int i=1; i<=5; i++)
			{
				 Bitmap image = BitmapFactory.decodeStream(context.getAssets().open("button/button" + i + ".png"));
				 float rate = SetButtonSize(LoadActivity.ScreenWidth, LoadActivity.ScreenHeight);
				 image = Image.FitTheImage(image, rate, rate);
				 button.add(image);
				 temp++;
			}
			
			ladder = BitmapFactory.decodeStream(context.getAssets().open("tool/tool.jpg"));
			temp++;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static float SetButtonSize(int w, int h)
	{
		if     (w==320 && h==240 || w==400 && h==240 || w==432 && h==240) return 0.3f;
		else if(w==480 && h==320) return 0.35f;
		else if(w==800 && h==480 || w==854 && h==480) return 0.5f;
		else if(w==960 && h==540 || w==960 && h==640) return 0.6f;
		else if(w>1000 && h >=600 ||w>=600 && h>1000) return 0.8f;
		return 0.4f;
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
}
