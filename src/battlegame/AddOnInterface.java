package battlegame;

/**
 * Interface for all addOns. Creates a base for all addOns and extends Comparable to
 * support sorting.
 */
public interface AddOnInterface extends Comparable<AddOnInterface> {


  /**
   * To access Name from the object.
   */
  String getName();

  /**
   * To access Priority from the object.
   */
  int getPriority();


  /**
   * Helps to initialize the complex class with initial values.
   */
  AddOns impactStrength(int change);

  /**
   * Helps to initialize the complex class with initial values.
   */
  AddOns impactConstitution(int change);

  /**
   * Helps to initialize the complex class with initial values.
   */
  AddOns impactDexterity(int change);

  /**
   * Helps to initialize the complex class with initial values.
   */
  AddOns impactCharisma(int change);

  /**
   * Accessor Method for getting change in charisma by the addon.
   */
  int getChangeCharisma();


  /**
   * Accessor Method for getting change in constitution by the addon.
   */
  int getChangeConstitution();


  /**
   * Accessor Method for getting change in Strength by the addon.
   */
  int getChangeStrength();


  /**
   * Accessor Method for getting change in Dexterity by the addon.
   */
  int getChangeDexterity();

  /**
   * To be used for sorting.
   */
  int compareTo(AddOnInterface o);

  /**
   * To get the type of object.
   */
  String getType();
}
