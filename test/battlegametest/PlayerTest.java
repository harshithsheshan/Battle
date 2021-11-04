package battlegametest;

import battlegame.AddOnInterface;
import battlegame.Belts;
import battlegame.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To Test the methods and functionalities if a player. It includes testing for creation, getting
 * equipment bag and equipping gears.
 */
public class PlayerTest {
  Integer[] seeds;
  Integer[] seeds1;
  Player p;
  Player np;

  @Before
  public void setup() {
    seeds = new Integer[] {1, 2, 3, 4};
    seeds1 = new Integer[] {3, 4, 5, 6};
    p = new Player(seeds);
    np = new Player(seeds);
  }

  /**
   * To test the Rolling of dice to determine the stats of the player.
   */
  @Test
  public void rollDice() {
    //System.out.println(p.toString());
    Assert.assertEquals(p.toString(), "Cersei Lannister\n strength= 9\n constitution= 12\n"
        + " dexterity= 10\n charisma= 14");
  }


  @Test
  public void getStrength() {
    Assert.assertEquals(p.getStrength(), 9);
  }

  @Test
  public void getConstitution() {
    Assert.assertEquals(p.getConstitution(), 12);
  }

  @Test
  public void getDexterity() {
    Assert.assertEquals(p.getDexterity(), 10);
  }

  /**
   * Test to check if health is calculated correctly.
   */
  @Test
  public void getHealth() {
    p.resetHealth();
    Assert.assertEquals(p.getHealth(), p.getConstitution() + p.getStrength() + p.getDexterity()
        + p.getCharisma());
  }

  @Test
  public void getCharisma() {
    Assert.assertEquals(p.getCharisma(), 14);
  }

  /**
   * To test that Striking power is calculated properly. Calculations are done manually.
   */
  @Test
  public void getStrikingPower() {
    //System.out.println(p.getStrength());
    Assert.assertEquals(p.getStrikingPower(), 17);
  }

  /**
   * To Test the Avoidance is calculated properly. Calculations are done manually.
   */
  @Test
  public void getAvoidance() {
    Assert.assertEquals(p.getAvoidance(), 13);
  }

  @Test
  public void testToString() {
    Assert.assertEquals(p.toString(), "Cersei Lannister\n strength= 9\n constitution= 12\n"
        + " dexterity= 10\n charisma= 14");
  }

  @Test
  public void createEquipmentBag() {
    int[] count = new int[4];
    p.createEquipmentBag(1);
    for (AddOnInterface a : p.getEquipmentBag()) {
      //System.out.println(count[0]);
      if (a.getType().equals("HeadGears")) {
        count[0]++;
      } else if (a.getType().equals("Potions")) {
        count[1]++;
      } else if (a.getType().equals("Belts")) {
        count[2]++;
      } else {
        count[3]++;
      }
    }

    Assert.assertEquals(count[0], 5);
    Assert.assertEquals(count[1], 15);
    Assert.assertEquals(count[2], 15);
    Assert.assertEquals(count[3], 5);

  }

  @Test
  public void negativeCompliance() {
    p.createEquipmentBag(1);
    int countNeg = 0;
    for (AddOnInterface a : p.getEquipmentBag()) {
      if (a.getChangeCharisma() <= 0 || a.getChangeDexterity() <= 0
          || a.getChangeConstitution() <= 0 || a.getChangeStrength() <= 0) {
        countNeg++;
      }
    }
    Assert.assertTrue(countNeg >= p.getEquipmentBag().size() / 4);
  }

  /**
   * To test if the player is equipped properly.
   * i.e. He has at max 1 Headgear, has one pair of footwear, has a max belt units of 10 and the
   * total equipment used is always less than or equal to 20.
   */
  @Test
  public void equipGear() {
    p.equipGear(1);
    int countHeadGear = 0;
    int countBelt = 0;
    int beltSize = 0;
    int countFootWear = 0;
    int count = 0;
    for (AddOnInterface a : p.getEquipmentBag()) {
      if (a.getType().equals("Battle.HeadGears")) {
        countHeadGear++;
      } else if (a.getType().equals("Belt")) {
        countBelt++;
        beltSize += ((Belts) a).getSize();
      } else if (a.getType().equals("Battle.FootWear")) {
        countFootWear++;
      }
      count++;

    }
    Assert.assertTrue(countHeadGear <= 1);
    Assert.assertTrue(countBelt <= 8);
    Assert.assertTrue(countFootWear <= 1);
    Assert.assertTrue(beltSize <= 10);

    Assert.assertFalse(count <= 20);

  }

  @Test
  public void getWeapon() {
    Assert.assertEquals(p.getWeapon(), "AXES");
  }

  /**
   * To check player abilities are in range.
   */
  @Test
  public void checkStatsInRange() {
    Assert.assertTrue(np.getDexterity() <= 18 && np.getStrength() <= 18
        && np.getConstitution() <= 18 && np.getCharisma() <= 18);

  }


}