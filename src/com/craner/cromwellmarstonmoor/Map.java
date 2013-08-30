package com.craner.cromwellmarstonmoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import android.graphics.Rect;
import android.util.Log;


public class Map {
	
	ArrayList<String> map;
	
	// Constants for visible map row and columns to return
	//int MAXROW = 7;
	//int MAXCOLUMN = 18;
	
	public Map(ArrayList<String> map){
		this.map = map;
	}
	
	
	/**
	 * Return complete Map with units correctly positioned 
	 * 
	 * @param hashMapTerrain
	 * @param units
	 * @return
	 */
	public ArrayList<Terrain> returnMap(HashMap<String, Terrain> hashMapTerrain, ArrayList<Unit> units){
		
		ArrayList<Terrain> returnMap = new ArrayList<Terrain>();
		
		String col = map.get(0);
		String[] array = col.split(","); 
		
		// Loop through Map to return whole map
		for (int i = 0; i< 31; i++){
			col = map.get(i);
			array = col.split(",");
			array = Arrays.copyOfRange(array, 0, array.length);
			 
			for (int j=0;j < 22;j++) 
			{ 
			    String t = array[j];
			    String[] maptile = t.split("/"); 
			    // Find the correct Tile
	    		Terrain newTile = new Terrain(hashMapTerrain.get(maptile[1]));
	    		newTile.setTerrainNumber(Integer.parseInt(maptile[0]));
	    		//Log.d("TERRAIN", maptile[0]);
	    		newTile.setDisplayRect(setTileDisplayRect(i,j));
	    		checkUnitInTile(newTile, units);
	    		returnMap.add(newTile);
			} 
		}
		
		return returnMap;
	}
	
	
	
	/**
	 * Return complete map
	 * 
	 * @param startrow
	 * @param startcolumn
	 * @param terrain
	 * @param units
	 * @return
	 */
	// TODO Don't think I need this anymore? 
	public ArrayList<Terrain> returnMap(int startrow, int startcolumn, ArrayList<Terrain> terrain, ArrayList<Unit> units){
		
		ArrayList<Terrain> returnMap = new ArrayList<Terrain>();
		
		String col = map.get(0);
		String[] array = col.split(","); 
		
		// Loop through Map to return whole map
		for (int i = startcolumn; i< 31; i++){
			col = map.get(i);
			array = col.split(",");
			array = Arrays.copyOfRange(array, startcolumn, array.length);
			 
			for (int j=startrow;j < 22;j++) 
			{ 
			    String t = array[j];
			    String[] maptile = t.split("/"); 
			    for (Terrain tile : terrain){
			    	String terraintype = tile.getTileNumber();
			    	if (terraintype.equals(maptile[1])){
			    		Terrain newTile = new Terrain(tile);
			    		newTile.setTerrainNumber(Integer.parseInt(maptile[0]));
			    		//Log.d("TERRAIN", maptile[0]);
			    		newTile.setDisplayRect(setTileDisplayRect((i - startcolumn),(j - startrow)));
			    		checkUnitInTile(newTile, units);
			    		returnMap.add(newTile);
			    		break;
			    	}
			    }
			} 
		}
		
		return returnMap;
	}
	
	/**
	 * Work out where Tile should be displayed on canvas
	 * 
	 * @param column
	 * @param row
	 * @return - Drawing Rect
	 */
	private Rect setTileDisplayRect(int column, int row){
		
		int left = 0;
		int top = 0;
		int right = 86;
		int bottom = 76;
		
		if (column%2 == 0){
			left  += (65 * column);
			top += (76 * row);
			right = (left + 86);
			bottom = (top + 76);
		}
		else{
			left  += (65 * column);
			top += 38 + (76 * row);
			right = (left + 86);
			bottom = (top + 76);
		}
		
		Rect rect = new Rect(left, top, right, bottom);
	
		return rect;
	}
	
	/**
	 * See if Unit is in location of Tile
	 * If yes then store the unit within the Tile
	 * 
	 * @param tile - Tile to check
	 * @param units - All units in game
	 * @return - Unit if found
	 */
	private Unit checkUnitInTile(Terrain tile, ArrayList<Unit> units){
		Unit unitInHex = null;
		
		for (Unit unit : units){
			if (unit.getHex() == tile.getTerrainNumber()){
				unitInHex = unit;
				tile.setUnitInTile(unitInHex);
			}
		}
		
		return unitInHex;
	}
}
