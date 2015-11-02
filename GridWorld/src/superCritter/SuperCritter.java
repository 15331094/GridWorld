package superCritter;

/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.*;
import info.gridworld.actor.Rock;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>SuperCritter</code> removes all the critters as its neighbors and
 * pull away all the other Actor objects.
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class SuperCritter extends Critter
{   
    private boolean eaten;
    
    public SuperCritter()
    {
        super();
        eaten = false;
    }
    
    /**
     * Remove all the rock if they are its neighbors.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        Location loc = getLocation();
        Grid grid = getGrid();
        eaten = false;
        for (Actor a : actors)
        {
            // Never eat the same class
            if (a instanceof SuperCritter)
            {
                continue;
            }
            
            Location locA = a.getLocation();
            
            // Eat all other critters
            if (a instanceof Critter)
            {
                a.removeSelfFromGrid();
            }
            // or pull them away from it
            else
            {
                int dir = loc.getDirectionToward(locA);
                Location newLoc = locA.getAdjacentLocation(dir);
                if (grid.isValid(newLoc) && grid.get(newLoc) == null)
                {
                    a.moveTo(newLoc);
                }
                // If unable to pull, remove it
                else
                {
                    a.removeSelfFromGrid();
                }
            }
	    eaten = true;
        }
    }
    
    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        // If there is no place to go, stay
        // If it ate, stay for rest
        if (n == 0 || eaten)
            return getLocation();
        int r = (int) (Math.random() * n);
        return locs.get(r);
    }
}