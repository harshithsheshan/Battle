package battlegametest;

import battlegame.AddOns;
import battlegame.Belts;
import battlegame.HeadGears;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To test the functionalities of the addon HeadGear. Includes testing for how ability is
 * chosen to be impacted on.
 */
public class HeadGearsTest {

  HeadGears b;
  HeadGears b1;
  AddOns h;

  @Before
  public void setup() {
    b = new HeadGears(1);
    b1 = new HeadGears(2);
    h = new Belts(1);
  }

  /**
   * To test if an object is created properly with randomly chosen stats and impacts.
   */
  @Test
  public void testCreation() {
    Assert.assertEquals(b.toString(), "Addon Vagabond Hat\t changeStrength= 0\t "
        + "changeConstitution= 0\t changeDexterity= 0 \t changeCharisma= 0 ");
  }

  /**
   * To test the compare operation between two addons of different types(in this case).
   */
  @Test
  public void compareTo() {
    Assert.assertTrue(b.compareTo(h) <= 0);
  }

  /**
   * To test the compare operation between two addons of Headgear type.
   */
  @Test
  public void compareToHeadGears() {
    Assert.assertTrue(b.compareTo(b1) <= 0);
  }

}