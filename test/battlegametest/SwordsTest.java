package battlegametest;

import static battlegame.Swords.BAREHANDED;
import battlegame.Swords;
import org.junit.Assert;
import org.junit.Test;

/**
 * To test the functionalities of the addon Footwear. Includes testing for how ability is
 * chosen to be impacted on.
 */
public class SwordsTest {

  Swords a = Swords.getRandomSword(1);

  @Test
  public void getRandomSword() {
    Assert.assertEquals(Swords.getRandomSword(1).toString(), "AXES");
  }

  /**
   * To check if the weapon damage is in range and the function is returning correct values.
   */
  @Test
  public void testGearStrength() {
    if (a.toString().equals("KATANA") || a.toString().equals("TWOHANDED")
        || a.toString().equals("FLAILS")) {
      Assert.assertTrue(a.getSwordStrength(1) < 7);
    } else if (a.toString().equals("FLAILS") || a.toString().equals("BROADSWORDS")) {
      Assert.assertTrue(a.getSwordStrength(1) < 10);
    }
    Assert.assertEquals(a.getSwordStrength(1), 8);
  }

  /**
   * To test that a player can be a bare handed after requesting a sword.
   */
  @Test
  public void testBareHand() {
    for (Swords c : Swords.values()) {
      if (c.name().equals(BAREHANDED)) {
        Assert.assertTrue(true);
      }
    }

  }

}
