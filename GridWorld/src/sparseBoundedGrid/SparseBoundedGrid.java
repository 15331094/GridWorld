package sparseBoundedGrid;

import java.util.ArrayList;
import java.util.LinkedList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class SparseBoundedGrid<E> extends AbstractGrid<E> {
    private LinkedList<OccupantInCol>[] StoreInRow;
    private int cols;
    public SparseBoundedGrid (int row, int col) {
    	StoreInRow = new LinkedList[row];
    	cols = col;
	}
	@Override
	public E get(Location loc) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
		for (OccupantInCol occupant : StoreInRow[loc.getRow()]) {
			if (occupant.getCol() == loc.getCol())
				return (E)occupant.getOccupant();
		}
        return null; // unavoidable warning
	}

	@Override
	public ArrayList<Location> getEmptyAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();
        for (Location neighborLoc : getValidAdjacentLocations(loc))
        {
            if (get(neighborLoc) == null)
                locs.add(neighborLoc);
        }
        return locs;
	}

	@Override
	public ArrayList<E> getNeighbors(Location loc) {
		ArrayList<E> neighbors = new ArrayList<E>();
        for (Location neighborLoc : getOccupiedAdjacentLocations(loc))
            neighbors.add(get(neighborLoc));
        return neighbors;
	}

	@Override
	public int getNumCols() {
		return cols;
	}

	@Override
	public int getNumRows() {
		return StoreInRow.length;
	}

	@Override
	public ArrayList<Location> getOccupiedAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();
        for (Location neighborLoc : getValidAdjacentLocations(loc))
        {
            if (get(neighborLoc) != null)
                locs.add(neighborLoc);
        }
        return locs;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		ArrayList<Location> theLocations = new ArrayList<Location>();

        // Look at all grid locations.
        for (int r = 0; r < getNumRows(); r++)
        {
            for (int c = 0; c < getNumCols(); c++)
            {
                // If there's an object at this location, put it in the array.
                Location loc = new Location(r, c);
                if (get(loc) != null)
                    theLocations.add(loc);
            }
        }

        return theLocations;
	}

	@Override
	public ArrayList<Location> getValidAdjacentLocations(Location loc) {
		ArrayList<Location> locs = new ArrayList<Location>();

        int d = Location.NORTH;
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_RIGHT; i++)
        {
            Location neighborLoc = loc.getAdjacentLocation(d);
            if (isValid(neighborLoc))
                locs.add(neighborLoc);
            d = d + Location.HALF_RIGHT;
        }
        return locs;
	}

	@Override
	public boolean isValid(Location loc) {
		return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	@Override
	public E put(Location loc, E obj) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        // Delete the old object 
        E oldOccupant = get(loc);
        for (OccupantInCol current:StoreInRow[loc.getRow()]) {
        	if (current.getCol() == loc.getCol())
        		StoreInRow[loc.getRow()].remove(current);
        }
        //insert the new object
        StoreInRow[loc.getRow()].add(new OccupantInCol(obj, loc.getCol()));
        return oldOccupant;
	}

	@Override
	public E remove(Location loc) {
		if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        for (OccupantInCol current:StoreInRow[loc.getRow()]) {
        	if (current.getCol() == loc.getCol())
        		StoreInRow[loc.getRow()].remove(current);
        }
        return r;
	}
	
}
