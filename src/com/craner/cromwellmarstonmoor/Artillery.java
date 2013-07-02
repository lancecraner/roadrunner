package com.craner.cromwellmarstonmoor;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Artillery {

	private String name;
	private int startHex = 0;
	private Rect displayRect;

    Bitmap bitmap;
	
	public void setstartHex(int startHex){
		this.startHex = startHex;
	}
	
	public int getstartHex(){
		return this.startHex;
	}
	
	public void setname(String name){
		this.name = name;
	}
		
	public String getname(){
		return this.name;
	}
	
	public void setDisplayRect(Rect displayRect){
        this.displayRect = displayRect;
    }

    public Rect getDisplayRect(){
        return this.displayRect;
    }
    
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap(){
        return this.bitmap;
    }
}
