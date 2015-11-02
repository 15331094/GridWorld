package blusterCritter;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {
	private static final double DARKENING_FACTOR = 0.5;
	private int afraid;
	public BlusterCritter(int af) {
		afraid = af;
	}
    public ArrayList<Location> getAllTwoStepLocation() {
    	ArrayList<Location> locs = new ArrayList<>(); 
    	int[] directions = {Location.EAST, Location.NORTHEAST, Location.SOUTHEAST,
    			            Location.WEST, Location.NORTHWEST, Location.SOUTHWEST,
    			            Location.SOUTH, Location.NORTH};
    	Grid<Actor> gr = getGrid();
    	Location loc = getLocation();
    	for (int dir : directions) {
            Location next = loc.getAdjacentLocation(dir);
            if (gr.isValid(next)) {
            	locs.add(next);
            	Location nextnext = next.getAdjacentLocation(dir);
            	if (gr.isValid(nextnext))
            		locs.add(nextnext);
            }
    	}
    	return locs;
    }
    
    public int getCritterCount(ArrayList<Location> locs) {
    	int count = 0;
    	Grid<Actor> gr = getGrid();
    	for (Location location: locs) {
    		if (gr.get(location) instanceof Critter)
    			count++;
    	}
    	return count;
    }
    
    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
        if (getCritterCount(getAllTwoStepLocation()) < afraid) {
        	Color c = getColor();
        	int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
            setColor(new Color(red>255?255:red, green>255?255:green, blue>255?255:blue));
        } else {
        	Color c = getColor();
        	int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue));
        }
        	
    }
}
