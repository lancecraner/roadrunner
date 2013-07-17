package com.craner.cromwellmarstonmoor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
//import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author lcraner
 *
 */
public class GameBoard extends View {

    Context mContext; // Context is passed into some of the other classes to load up bitmap
    ArrayList<Terrain> terrain; // loaded with details on each individual Terrain Tile type
    ArrayList<Terrain> wholeMap; // Contains the whole map 
    ArrayList<String> map; // Contains Hex/Tile details
    //ArrayList<String> tileCoordinates;
    ArrayList<Unit> units; // Contains all the Games Units
    //ArrayList<Unit> Unit; // Contains all the Games Units
    ArrayList<Leader> leaders; // Contains all the Games Leaders
    Map visiblemap; // Used to help display just the visible map onscreen
    int startRow = 0; // Start row to display on screen
    int startColumn = 0; // Start column to display on screen
    boolean mapchanged = true; // Flag to say something changed on the screen to update
    boolean unitSelected = false; // Flag to indicate if a unit has been selected
    //Terrain terrainSelected;
    Terrain unitTerrainSelected; // Selected Hex unit wants to move to
    int X_MOVE = 0; // Used when working out screen scrolling
    int Y_MOVE = 0; // Used when working out screen scrolling
    boolean odd = false; // Used to indicate if first column of hexes are odd numbered
    // Constants 
    int MAX_MAP_ROWS = 22;
    int MAX_ROW_DISPLAY = 15;
    int MAX_COLUMN_DISPLAY = 13;
    Paint paint;
    
    		
    

    public GameBoard(Context context, AttributeSet attrs) {
        super(context, attrs);

            // Initialise Game
            mContext = context;
            // Load in Units
            loadUnits(R.raw.units);
            // Load in Leaders
            loadLeaders(R.raw.leaders);
            // Load in Terrain Tiles
            loadTerrain(R.raw.terrainmodifiers);
            // Load in map - Hex numbers/Tile Type
            loadMap(R.raw.map);
            // Create Map in Memory
            visiblemap = new Map(map);
            wholeMap = visiblemap.returnMap(startRow, startColumn, terrain, units);
            // Don't need this anymore
            terrain = null;
            
            paint = new Paint();
    }

    @Override
    synchronized public void onDraw(Canvas canvas) {
        //create canvas
    	if (mapchanged){
    		
    		// check if we are near map boundaries
			if (startColumn > (MAX_COLUMN_DISPLAY)){
				startColumn = MAX_COLUMN_DISPLAY;
			}
			if (startRow > MAX_ROW_DISPLAY){
				startRow = MAX_ROW_DISPLAY;
			}
			
			
			// Check if start column is odd or even as effects layout
			if (startColumn%2 == 1){
				odd = true;
			}else{
				odd = false;
			}
			
			// Array to hold units that will be visible on screen
			ArrayList<Unit> unitsToDisplay = new ArrayList<Unit>();
				
			// Loop through Map to return visible map
			for (int i = startColumn; i< 18 + startColumn; i++){
				
				for (int j=startRow;j < 7 + startRow;j++) 
				{ 
					canvas.drawBitmap(wholeMap.get((MAX_MAP_ROWS * i) + j).getBitmap(), null, setTileDisplayRect(i - startColumn, j - startRow, odd), null);
					//Log.d("TERRAIN", Integer.toString(wholeMap.get((MAX_MAP_ROWS * i)+j).getTerrainNumber()));
					// Check if Terrain holds units as we need to display them last over the map bitmap
	    			if (wholeMap.get((MAX_MAP_ROWS * i) + j).getUnitInTile() != null){
	    				// Set the display Rect for the Units
	    				wholeMap.get((MAX_MAP_ROWS * i) + j).setDisplayRect(setTileDisplayRect(i - startColumn, j - startRow, odd));
	    				wholeMap.get((MAX_MAP_ROWS * i) + j).setUnitInTileRect();
	    				unitsToDisplay.add(wholeMap.get((MAX_MAP_ROWS * i) + j).getUnitInTile());
	    			}
				} 
			}
    		// After Map has been displayed overlay units
    		for (Unit unit : unitsToDisplay){
    			if (unit.getmovementAllowance() != 0){
    				canvas.drawBitmap(unit.getBitmap(), null, unit.getDisplayRect(), null);
    			}else{
    				paint.setAlpha(150);
    				canvas.drawBitmap(unit.getBitmap(), null, unit.getDisplayRect(), paint);
    			}
    		}
    		
    		// Reset flag
    		mapchanged = false;
    	}
    }
    
    // Work out where Tile should be displayed on canvas
    // Depending on whether tile is odd numbered or even number effects display position
 	private Rect setTileDisplayRect(int column, int row, boolean bit){
 		
 		int left = 0;
 		int top = 0;
 		int right = 86;
 		int bottom = 76;
 		if (!bit){
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
 		}else{
 			if (column%2 == 0){
 				left  += (65 * column);
	 			top += 38 + (76 * row);
	 			right = (left + 86);
	 			bottom = (top + 76);
	 		}
	 		else{
	 			left  += (65 * column);
	 			top += (76 * row);
	 			right = (left + 86);
	 			bottom = (top + 76);
	 		}
 		}
 		
 		Rect rect = new Rect(left, top, right, bottom);
 	
 		return rect;
 	}

    public void loadTerrain(int resourceId) {
        // The InputStream opens the resourceId and sends it to the buffer
        InputStream is = this.getResources().openRawResource(resourceId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine = null;

        try {
            // While the BufferedReader readLine is not null
        	terrain = new ArrayList<Terrain>();
            while ((readLine = br.readLine()) != null) {
                Terrain terrainTile = new Terrain(readLine, this.mContext );
                terrain.add(terrainTile);
                //Log.d("TERRAIN", readLine);
            }

            // Close the InputStream and BufferedReader
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadMap(int resourceId) {
        // The InputStream opens the resourceId and sends it to the buffer
        InputStream is = this.getResources().openRawResource(resourceId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine = null;

        try {
            // While the BufferedReader readLine is not null
        	map = new ArrayList<String>();
            while ((readLine = br.readLine()) != null) {
            	map.add(readLine);
               
                //Log.d("MAP", readLine);
            }

            // Close the InputStream and BufferedReader
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadLeaders(int resourceId) {
        // The InputStream opens the resourceId and sends it to the buffer
        InputStream is = this.getResources().openRawResource(resourceId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine = null;

        try {
            // While the BufferedReader readLine is not null
        	leaders = new ArrayList<Leader>();
            while ((readLine = br.readLine()) != null) {
            	Leader leader = new Leader(readLine, this.mContext );
            	leaders.add(leader);
               
                //Log.d("UNITS", readLine);
            }

            // Close the InputStream and BufferedReader
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadUnits(int resourceId) {
        // The InputStream opens the resourceId and sends it to the buffer
        InputStream is = this.getResources().openRawResource(resourceId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readLine = null;

        try {
            // While the BufferedReader readLine is not null
        	units = new ArrayList<Unit>();
        	
            while ((readLine = br.readLine()) != null) {
            	Unit unit = new Unit(readLine, this.mContext );
            	units.add(unit);
               
                //Log.d("UNITS", readLine);
            }

            // Close the InputStream and BufferedReader
            is.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {

    	int action = event.getAction();
    	if(action == MotionEvent.ACTION_DOWN){
    		// Get co-ordinates where touched
	        int X = (int)event.getX();
	        int Y = (int)event.getY();
	        // Set global variables so can check later if should scroll screen
	        X_MOVE = X;
	        Y_MOVE = Y;
	        
	        if (startColumn%2 == 1){
				odd = true;
			}
	        // Find the Hex touched
	        int selectedHex = findSelectedHex(X, Y, odd);
	        
	        // Update if Unit on the Hex 
	        boolean flag = updateSelectedHex(selectedHex);
	        if(flag){
	        	return true;
	        }
	        
    	}
    	
    	if(action == MotionEvent.ACTION_MOVE){
    		// Get co-ordinates where touched
	        int x = (int)event.getX();
	        int y = (int)event.getY();
	        
	        // Ignore if mapchanged still true as means screen not updated from previous time
	        if (!mapchanged){
		        if (y > Y_MOVE){
		        	// Decide how many Hexes to scroll down
		        	int hexesToScroll = (y - Y_MOVE)/76;
		        	//Log.d("UNITS", Integer.toString(hexesToScroll));
		        	startRow += hexesToScroll;
		        	if (startRow > 16){
		        		startRow = 16;
		        	}
		        	mapchanged = true;
		        	invalidate();
		        	
		        }
		        
		        if (y < Y_MOVE){
		        	// Decide how many Hexes to scroll down
		        	int hexesToScroll = (Y_MOVE - y)/76;
		        	//Log.d("UNITS", Integer.toString(hexesToScroll));
		        	startRow -= hexesToScroll;
		        	if (startRow < 0){
		        		startRow = 0;
		        	}
		        	mapchanged = true;
		        	invalidate();
		        	
		        }
		        
		        if (x < X_MOVE){
		        	// Decide how many Hexes to scroll down
		        	int hexesToScroll = (X_MOVE - x)/65;
		        	//Log.d("UNITS", Integer.toString(hexesToScroll));
		        	startColumn -= hexesToScroll;
		        	if (startColumn < 0){
		        		startColumn = 0;
		        	}
		        	mapchanged = true;
		        	invalidate();
		        	
		        }
		        
		        if (x > X_MOVE){
		        	// Decide how many Hexes to scroll down
		        	int hexesToScroll = (x - X_MOVE)/65;
		        	//Log.d("UNITS", Integer.toString(hexesToScroll));
		        	startColumn += hexesToScroll;
		        	if (startColumn > 14){
		        		startColumn = 14;
		        	}
		        	mapchanged = true;
		        	invalidate();
		        	
		        }
	        }
	        
	        
    	}
    	
    	
    	return true;
    }
    
    /**
     * Called from onTouch event
     * Finds the hex that the user touched
     * 
     * @param X - X Coordinates
     * @param Y - Y Coordinates
     * @param bit - Used to indicate odd or even row due to Hex placement
     * @return The hex number
     */
    private int findSelectedHex(int X, int Y, boolean bit){
    	
    	int tileWidth = 65;
    	int tileHeight = 76;
    	
    	// Divide x by 65 to work out what row
        int selectedColumn = X/tileWidth;
        int selectedRow = 0;
        
        // Row is slightly harder due to shift in position ever other column
        if (!bit){
	        if (selectedColumn%2 == 0){
	        	selectedRow = Y/tileHeight;
	        }
	        else{
	        	Y = Y -38;
	        	selectedRow = Y/tileHeight;
	        }
        }else{
        	 if (selectedColumn%2 == 0){
        		Y = Y -38;
 	        	selectedRow = Y/tileHeight;
 	        }
 	        else{
 	        	selectedRow = Y/tileHeight;
 	        }
        }
       
        return (selectedRow + startRow) + ((selectedColumn + startColumn)* MAX_MAP_ROWS);
    }
    
    /**
     * Called from onTouch event
     * Checks selected Hex and sees if a Unit is in there
     * 
     * @param selectedHex - Hex user touched on the screen
     * @return True if unit was in the hex
     */
    private boolean updateSelectedHex(int selectedHex){
        
    	boolean unitFound = false;
    	
    	// Check if we have a selected unit - In which case this is a possible move unit request
        if (unitSelected){
        	// Get all possible hexes the unit could move to
        	ArrayList<Integer> hexes = unitTerrainSelected.getUnitInTile().getAllowableMoveHexChoice();
        	int hexSide = 0;
        	for (Integer hex : hexes){
        		// Loop through hexes to see if selected hex is one the unit is allowed to move to
        		if (hex == wholeMap.get(selectedHex).getTerrainNumber()){
        			// Check if unit already in Hex - in which case don't allow move into
        			if (!wholeMap.get(selectedHex).isUnitAlreadyinHex())
        			{
        			// Check unit has enough movement allowance to move into the hex
	        			if (checkCanMoveIntoHex(wholeMap.get(selectedHex), hexSide, unitTerrainSelected.getUnitInTile()))
	        			{
		        			wholeMap.get(selectedHex).setUnitInTile(unitTerrainSelected.getUnitInTile());
		        			wholeMap.get(selectedHex).getUnitInTile().setSelected(false);
		        			wholeMap.get(selectedHex).getUnitInTile().setHex(hex);
		        			wholeMap.get(selectedHex).setUnitInTileRect();
		        			unitTerrainSelected.deleteUnitInTile();
		        			mapchanged = true;
		        			unitFound = true;
		        			invalidate();
		        			break;
	        			}
        			}
        		}
        		hexSide +=1;
        	}
        	// un-select unit
        	unitSelected = false;
        	if (!mapchanged){
        		unitTerrainSelected.getUnitInTile().setSelected(false);
        		unitFound = true;
        	}
        }
        else{
        	// Check selected hex to see if unit in hex - If yes then mark that unit as selected
	        if (wholeMap.get(selectedHex).getUnitInTile() != null){
	        	// check if unit is allowed to move
	        	if (wholeMap.get(selectedHex).getUnitInTile().getmovementAllowance() > 0){
	        		// Has movement allowance
		        	wholeMap.get(selectedHex).getUnitInTile().setSelected(true);
		        	unitTerrainSelected = wholeMap.get(selectedHex);
		        	mapchanged = true;
		        	unitSelected = true;
		        	unitFound = true;
		        	invalidate();
	        	}
	        }
        }
        
        return unitFound;
    }
    
    /**
     * Called to check if unit has enough movement points left to move into selected
     * hex. Update Unit movement allowance if move is allowed
     * 
     * @param terrain - Tile being move to
     * @param side - Which side of the hex being moved into
     * @param unit - The unit attempting the move
     * @return True if ok to move
     */
    private boolean checkCanMoveIntoHex(Terrain terrain, int side, Unit unit){
    	
    	boolean canMove = false;
    	int movementCost = terrain.getHexsideMovementModifier(side, unit.gettype()) + terrain.getTerrainMovementCost(unit.gettype());
    	
    	if (unit.getmovementAllowance() >= movementCost){
    		unit.updateRemainingMovementPoints(unit.getmovementAllowance() - movementCost);
    		canMove = true;
    	}
    	
    	return canMove;
    }
}
