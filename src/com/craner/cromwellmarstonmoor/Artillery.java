package com.craner.cromwellmarstonmoor;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Artillery {

	/*- Arty cannot move, disorder, rally, or be eliminated. 
	- Arty do not participate in normal combat, but bombard in their own friendly phase instead. 
	- Arty do not have ZOC and are not affected by ZOC or stacking. 
	- Each Arty Unit bombards alone. 
	- To bombard, trace LOS from Arty to target Unit. 
	- Range is infinite (treat ranges >6 as 6). 
	 - LOS blocked by woods/plump, close, town, train, hilltop hexes and Units or Arty. 
	 - LOS is never blocked by Leaders. 
	 - Arty in hilltop firing into non-hilltop hexes: ignore blocking terrain more than half the range away. 
	 - Arty in hilltop firing into hilltop hexes: ignore blocking hexes except plump, and those occupied by Units/Arty. 
	 - If LOS falls down a hexside, it is blocked only if both hexes of that hexside are blocking terrain. 
	 - Roll 1d6. DRM +1 if target in woods, close or train hex. Cross index range and modified roll. 
	- Units can only be disordered by Arty, never eliminated (so bombarding a disordered Unit has no effect). 
	- Can target same enemy Unit with several different Arty. 
	- Can resolve each bombardment before deciding on target of next Arty Unit (so can target an enemy Unit with several Arty in turn 
	until it is disordered, and so not waste shots). 
	- Arty are controlled by the last player whose Units (not Leaders) entered the hex. Flip (re)captured Arty to indicate control. 
	- Captured Arty count for demoralization and VP purposes.*/
	
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
