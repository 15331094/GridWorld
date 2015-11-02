package superCritter;

import static org.junit.Assert.*;
import jumper.Jumper;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import org.junit.Before;
import org.junit.Test;

public class SuperCritterTest {
	 ActorWorld world;
	 Critter critter;
	 Rock rock;
	 Flower flower;
	 Bug bug;
	 SuperCritter superCritter;
	@Before
	public void setUp() throws Exception {
	    world = new ActorWorld();
		rock = new Rock();
		flower = new Flower();
		bug = new Bug();
		critter = new Critter();
		superCritter = new SuperCritter();
		world.show();
	}

	//when a rock in font of a superCritter
	@Test
	public void OneRockinfront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), rock);
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(new Location(3, 5), rock.getLocation());
	}
	@Test
	public void ThreeRockinfront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), rock);
		world.add(new Location(4, 4), new Rock());
		world.add(new Location(4, 6), new Rock());
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(new Location(3, 5), rock.getLocation());
		assertEquals(rock.getGrid().get(new Location(3, 3)) != null, true);
		assertEquals(rock.getGrid().get(new Location(3, 7)) != null, true);
	}
	@Test
	public void TwoRockInLineInFront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), rock);
		world.add(new Location(3, 5), new Rock());
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(rock.getGrid() == null, true);
		assertEquals(superCritter.getGrid().get(new Location(3, 5)) != null, true);
	}
	@Test
	public void OneFlowerInFront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), flower);
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(new Location(3, 5), flower.getLocation());
	}
	@Test
	public void TwoFlowerInLineInFront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), flower);
		world.add(new Location(3, 5), new Flower());
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(flower.getGrid() == null, true);
		assertEquals(superCritter.getGrid().get(new Location(3, 5)) != null, true);
	}
	@Test
	public void ThreeFlowerinfront() {
		world.add(new Location(5, 5), superCritter);
		world.add(new Location(4, 5), flower);
		world.add(new Location(4, 4), new Flower());
		world.add(new Location(4, 6), new Flower());
		superCritter.act();
		assertEquals(new Location(5, 5), superCritter.getLocation());
		assertEquals(new Location(3, 5), flower.getLocation());
		assertEquals(flower.getGrid().get(new Location(3, 3)) != null, true);
		assertEquals(flower.getGrid().get(new Location(3, 7)) != null, true);
	}

}
