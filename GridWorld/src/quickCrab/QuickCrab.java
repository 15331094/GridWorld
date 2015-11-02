package quickCrab;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import Critter.CrabCritter;

public class QuickCrab extends CrabCritter{
	public ArrayList<Location> getMoveLocations()
    {
        int[] directions =
            { Location.LEFT, Location.RIGHT };
        ArrayList<Location> oneSteplocs = new ArrayList<Location>();
        ArrayList<Location> twoStepLocs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
        int currentDirection = getDirection();
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(currentDirection + d);
            if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null) {
                oneSteplocs.add(neighborLoc);
                Location neighborNextLoc = neighborLoc.getAdjacentLocation(currentDirection + d);
                if (gr.isValid(neighborNextLoc) && gr.get(neighborNextLoc) == null) {
                	twoStepLocs.add(neighborNextLoc);
                }
            }
        }
        if (twoStepLocs.size() == 0) {
        	return oneSteplocs;
        }
        else {
        	return twoStepLocs;
        }
    }
	
	
	public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }
}
