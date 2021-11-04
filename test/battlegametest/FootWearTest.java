package battlegametest;

import battlegame.AddOns;
import battlegame.FootWear;
import battlegame.HeadGears;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To test the functionalities of the addon Footwear. Includes testing for how ability is
 * chosen to be impacted on.
 */
public class FootWearTest {
  FootWear b;
  FootWear b1;
  AddOns h;

  @Before
  public void setup() {
    b = new FootWear(1);
    b1 = new FootWear(2);
    h = new HeadGears(1);
  }

  /**
   * To test if an object is created properly with randomly chosen stats and impacts.
   */
  @Test
  public void testCreation() {
    Assert.assertEquals(b.toString(), "Addon Slide Sandals\t changeStrength= 0\t "
        + "changeConstitution= 0\t changeDexterity= 2 \t changeCharisma= 0 ");
  }

  /**
   * To test the compare operation between two addons of different types(in this case).
   */
  @Test
  public void compareTo() {
    Assert.assertFalse(b.compareTo(h) <= 0);

  }

  /**
   * To test the compare operation between two addons of Footwear type.
   */
  @Test
  public void compareToFootWear() {
    Assert.assertFalse(b.compareTo(b1) > 0);
  }
}