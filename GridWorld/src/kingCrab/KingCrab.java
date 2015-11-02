package kingCrab;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import Critter.CrabCritter;

public class KingCrab extends CrabCritter {
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Critter)) {
                //a.removeSelfFromGrid();
            	int currentDirection = getDirection();
            	Location aLoc = a.getLocation();
                Location aNextLoc = aLoc.getAdjacentLocation(currentDirection);
                Grid gr = getGrid();
                if (gr.isValid(aNextLoc)&&gr.get(aNextLoc) == null) {
                	a.moveTo(aNextLoc);
                }
                else {
					a.removeSelfFromGrid();
				}
            }
        }
    }
}
