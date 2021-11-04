package battlegametest;

import battlegame.Battle;
import battlegame.AddOnInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * To Test all the functionalities of the class Battle.Battle. It includes testing for all
 * scenarios that are possible in a duel.
 */
public class BattleTest {

  private Battle battle;
  private int res;
  boolean gameDone;

  @Before
  public void setup() {
    battle = new Battle();
  }

  /**
   * To test the list gear Method of the Battle.Battle class which lists the gear of each player.
   */
  @Test
  public void listGear() {
    List<AddOnInterface> gears = battle.getEquippedGearP1(1);
    int i;
    for (i = 0; i < gears.size() - 1; i++) {
      if ((gears.get(i).getPriority() > gears.get(i + 1).getPriority())) {
        throw new IllegalStateException();
      }
    }
    Assert.assertEquals(i, gears.size() - 1);
  }

  /**
   * To test the results of a bout between two players by checking who wins the match.
   */
  @Test
  public void bout() {
    res = battle.bout();
    boolean r = res == 0 || res == 1 || res == 2;
    Assert.assertTrue(r);
  }


  /**
   * To test the results and effects of a strike and if the strike is acting as its meant to be.
   */
  @Test
  public void strike() {
    res = battle.strikeP1();
    Assert.assertEquals(res, 1);
  }

  /**
   * To test if the potential damage is calculated accurately and in realtime and is correct.
   */
  @Test
  public void calculatePotentialDamage() {
    res = battle.calculatePotentialDamageP1();
    Assert.assertEquals(res, 14);
  }

  /**
   * To test if game is done when a player reaches 0 health.
   */
  @Test
  public void testIsGameDone() {
    gameDone = battle.isGameDoneP1();
    Assert.assertTrue(gameDone);
  }

  /**
   * To test if the Health is restored if opting for a rematch.
   */
  @Test
  public void rematch() {
    res = battle.getHealthP1();
    battle.rematch();
    Assert.assertNotEquals(battle.getHealthP1(), res);

  }

  /**
   * To check if player health is updated based on damage.
   */
  @Test
  public void playerHealthUpdatedOnDamage() {
    int h = battle.getHealthP2();
    battle.strikeP1();
    Assert.assertTrue(battle.getHealthP2() <= h);
  }


}