package battlegametest;


import battlegame.HeadGears;
import battlegame.Potions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To test the functionalities of the addon Potions. Includes testing for how ability is
 * chosen to be impacted on.
 */
public class PotionsTest {

  Potions b;
  Potions b1;
  HeadGears h;

  @Before
  public void setup() {
    b = new Potions(1);
    b1 = new Potions(2);
    h = new HeadGears(1);
  }

  /**
   * To test if an object is created properly with randomly chosen stats and impacts.
   */
  @Test
  public void testCreation() {
    Assert.assertEquals(b.toString(), "Addon Coke\t changeStrength= 0\t "
        + "changeConstitution= 0\t changeDexterity= 0 \t changeCharisma= 4 ");

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
  public void compareToPotions() {
    Assert.assertFalse(b.compareToPotions(b1) > 0);
  }

}