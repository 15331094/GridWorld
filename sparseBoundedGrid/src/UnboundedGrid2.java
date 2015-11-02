
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class UnboundedGrid2<E> extends AbstractGrid<E> {
	private Map<Location, E> occupantMap;
    private int currentSize;
    /**
     * Constructs an empty unbounded grid.
     */
    public UnboundedGrid2()
    {
        occupantMap = new HashMap<Location, E>();
        currentSize = 16;
    }

    public int getNumRows()
    {
        return currentSize;
    }

    public int getNumCols()
    {
        return currentSize;
    }

    public boolean isValid(Location loc)
    {
        return true;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
            a.add(loc);
        return a;
    }

    public E get(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.get(loc);
    }

    public E put(Location loc, E obj)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (obj == null)
            throw new NullPointerException("obj == null");
        while (loc.getCol() >= currentSize || loc.getRow() >= currentSize) {
        	currentSize = currentSize*2;
        }
        return occupantMap.put(loc, obj);
    }

    public E remove(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        return occupantMap.remove(loc);
    }
}
