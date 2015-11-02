package jumper;
import static org.junit.Assert.*;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import org.junit.Before;
import org.junit.Test;

public class JumperTest {

  private static final int one   = 1;
  private static final int three = 3;
  private static final int four  = 4;
  private static final int five  = 5;
  private static final int fourty_five = 45;
  private static final int zero = 0;
  ActorWorld world;
  Jumper test;
  Rock rock;
  Flower flower;
  Bug bug;
  
  @Before
  public void setUp() throws Exception {
	    world = new ActorWorld();
	    test = new Jumper();
	    rock = new Rock();
	    flower = new Flower();
	    bug = new Bug();
  }
  
  
  @Test
//when there is nothing in front of a jumper
  public void NoBoundary() {
	  world.add(new Location(five, five), test);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),0);
  }
  
  @Test
  //when there is a grid between a jumper to a rock
  public void RockInfront() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(three, five), rock);
	  test.act();
	  assertEquals(test.getLocation(),new Location(five, five));
	  assertEquals(test.getDirection(),fourty_five);
  }
  @Test
  //when a jumper facing a rock
  public void FacingRock() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(four,five),rock);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),0);
  }
  
  @Test
  //when there is a grid between a jumper to a flower
  public void FlowerInfront() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(three, five), flower);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),zero);
  }
  @Test
  //when a jumper facing a flower
  public void FacingFlower() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(four,five),flower);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),0);
  }
  
  @Test
  //when there is a grid between a jumper to a bug
  public void BugInfront() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(three, five), bug);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),0);
  }
  @Test
  //when a jumper facing a bug
  public void FacingBug() {
	  world.add(new Location(five,five),test);
	  world.add(new Location(four,five),bug);
	  test.act();
	  assertEquals(test.getLocation(),new Location(three, five));
	  assertEquals(test.getDirection(),0);
  }
  
  @Test
  //when there is a grid between a jumper to the wall
  public void WallInfront() {
	  world.add(new Location(one,zero),test);
	  test.act();
	  assertEquals(test.getLocation(),new Location(one, zero));
	  assertEquals(test.getDirection(),fourty_five);
  }
  @Test
  //when a jumper facing the wall
  public void FacingWall() {
	  world.add(new Location(zero,zero),test);
	  test.act();
	  assertEquals(test.getLocation(),new Location(zero, zero));
	  assertEquals(test.getDirection(),fourty_five);
  }
}
