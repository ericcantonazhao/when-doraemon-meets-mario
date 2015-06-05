package com.zhao.Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;





import android.content.Context;

public class unlock {
	private Context con;
	public unlock(Context c){
		con=c;
	}
	public int readLevel() throws StreamCorruptedException, IOException, ClassNotFoundException{
		File fileDir=con.getFilesDir();
		String add1=fileDir.getParent() + java.io.File.separator + fileDir.getName()+"/Record.ser";
		File file = new File(add1);
		 if (!file.exists()) {

			 return 0;
		  }else{
			  FileInputStream fis=new FileInputStream(add1);
			  ObjectInputStream os=new ObjectInputStream(fis);
			  Integer r=(Integer) os.readObject();
			  os.close();
			  return r;
			  
		  }
	}
	public void setLevel(int l){
		File fileDir=con.getFilesDir();
		String add1=fileDir.getParent() + java.io.File.separator + fileDir.getName()+"/Record.ser";
		File f=new File(add1);
		if(f.exists()){
			f.delete();
		}	
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(add1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer r=l;
		try {
			os.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
