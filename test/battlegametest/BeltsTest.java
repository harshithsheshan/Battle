package battlegametest;

import battlegame.AddOns;
import battlegame.Belts;
import battlegame.HeadGears;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To test the functionalities of the addon Battle.Belts. Includes testing for how ability
 * is chosen to be impacted on.
 */
public class BeltsTest {

  Belts b;
  Belts b1;
  AddOns h;

  @Before
  public void setup() {
    b = new Belts(1);
    b1 = new Belts(2);
    h = new HeadGears(2);
  }

  /**
   * To test if an object is created properly with randomly chosen stats and impacts.
   */
  @Test
  public void testCreation() {
    Assert.assertEquals(b.toString(), "Addon Brown Belt\t changeStrength= 0\t "
        + "changeConstitution= 1\t changeDexterity= 0 \t changeCharisma= 0 ");
  }

  /**
   * To test the compare operation between two addons of different types(in this case).
   */
  @Test
  public void compareTo() {
    Assert.assertTrue(b.compareTo(h) > 0);
  }

  /**
   * To test the compare operation between two addons of Battle.Belts type.
   */
  @Test
  public void compareToBelts() {
    Assert.assertTrue(b.compareToBelts( b1) > 0);
  }

  /**
   * To test the function and check if it returns the right size.
   */
  @Test
  public void getSize() {
    Assert.assertEquals(b1.getSize(),2);
  }
}