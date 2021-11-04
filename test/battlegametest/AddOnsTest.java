package battlegametest;

import battlegame.AddOns;
import battlegame.HeadGears;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * To test the methods of the abstract class Addons and the functionality extended by the subclass.
 */
public class AddOnsTest {

  AddOns a;

  @Before
  public void setup() {
    a = new HeadGears(2);
  }

  @Test
  public void testGetRandom() {
    //System.out.println(AddOns.getRandom(5, ));
    Assert.assertEquals(AddOns.getRandom(5, 3), 4);
  }

  @Test
  public void testGetChangeCharisma() {
    Assert.assertEquals(a.getChangeCharisma(), 0);
  }

  @Test
  public void testGetChangeConstitution() {
    Assert.assertEquals(a.getChangeConstitution(), 3);
  }

  @Test
  public void testGetChangeStrength() {
    Assert.assertEquals(a.getChangeStrength(), 0);
  }

  @Test
  public void testGetChangeDexterity() {
    Assert.assertEquals(a.getChangeDexterity(), 0);
  }
}