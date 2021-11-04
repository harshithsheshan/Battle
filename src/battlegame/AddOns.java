package battlegame;

import java.util.Random;

/**
 * Abstract class to denote an addon and the details regarding upgrade/degrade it has.
 * Addons implement the Battle.AddOnInterface.
 */
public abstract class AddOns implements AddOnInterface {


  protected String name;
  protected int changeStrength;
  protected int changeConstitution;
  protected int changeDexterity;
  protected int changeCharisma;
  protected int priority;


  /**
   * Constructor to initialize the Addons.
   */
  public AddOns() {
    this.changeStrength = 0;
    this.changeConstitution = 0;
    this.changeDexterity = 0;
    this.changeCharisma = 0;

  }

  /**
   * To access Name from the object.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * To access Priority from object.
   */
  @Override
  public int getPriority() {
    return priority;
  }


  /**
   * Helps to initialize the complex class with initial values.
   */
  @Override
  public AddOns impactStrength(int change) {
    this.changeStrength += change;
    return this;
  }

  /**
   * Helps to initialize the complex class with initial values.
   */
  @Override
  public AddOns impactConstitution(int change) {
    this.changeConstitution += change;
    return this;
  }

  /**
   * Helps to initialize the complex class with initial values.
   */
  @Override
  public AddOns impactDexterity(int change) {
    this.changeDexterity += change;
    return this;
  }

  /**
   * Helps to initialize the complex class with initial values.
   */
  @Override
  public AddOns impactCharisma(int change) {
    this.changeCharisma += change;
    return this;
  }

  /**
   * To return a random number.
   *
   * @param seed To get the same random number for the purpose of testing
   * @return Random number
   */
  public static int getRandom(int range, int seed) {
    Random r;
    if (seed != 0) {
      r = new Random(seed);
    } else {
      r = new Random();
    }
    return r.nextInt(range);
  }

  /**
   * gets the change in charisma that is impacted by the addon.
   *
   * @return change in integer
   */
  @Override
  public int getChangeCharisma() {
    return changeCharisma;
  }

  /**
   * gets the change in Constitution that is impacted by the addon.
   *
   * @return change in integer
   */
  @Override
  public int getChangeConstitution() {
    return changeConstitution;
  }

  /**
   * gets the change in Strength that is impacted by the addon.
   *
   * @return change in integer
   */
  @Override
  public int getChangeStrength() {
    return changeStrength;
  }

  /**
   * gets the change in Dexterity that is impacted by the addon.
   *
   * @return change in integer
   */
  @Override
  public int getChangeDexterity() {
    return changeDexterity;
  }

  /**
   * Overridden toString Method to get the details of the addon in a printable format.
   *
   * @return String with details on the stats of the addon.
   */
  @Override
  public String toString() {
    return String.format("Addon %s\t changeStrength= %d\t changeConstitution= %d\t "
            + "changeDexterity= %d \t changeCharisma= %d ", name, changeStrength,
        changeConstitution, changeDexterity, changeCharisma);
  }

  /**
   * To use the compareTo method for sorting the list in order. Part of the implementation of
   * comparable.
   */
  @Override
  public int compareTo(AddOnInterface o) {
    return -1;
  }

  /**
   * Double dispatch of compareTo method.
   */
  protected int compareToPotions(Potions o) {
    return 2;
  }

  /**
   * Double dispatch of compareTo method.
   */
  protected int compareToBelts(Belts o) {
    return 3;
  }

  /**
   * Double dispatch of compareTo method.
   */
  protected int compareToHeadGears(HeadGears o) {
    return 1;
  }

  /**
   * Double dispatch of compareTo method.
   */
  protected int compareToFootWear(FootWear o) {
    return 4;
  }

  @Override
  public String getType() {
    return null;
  }
}
