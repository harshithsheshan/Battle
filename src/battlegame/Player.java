package battlegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;


/**
 * Class implementing Base player which is an abstract player class. The player class assigns
 * equipment to the player and also assigns the stats to the player based on the roll of dice.
 */
public class Player implements BasePlayer {

  List<String> nameList;
  private final String name;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  List<AddOns> gearEquipped;
  private final Swords sword;
  private int[] gearAbility;
  List<AddOns> equipmentBag;
  private int health;


  /**
   * Constructor resembling rolling a Die to determine the stats of a player.
   *
   * @param seeds for testing
   */
  public Player(Integer[] seeds) {
    nameList = new ArrayList<>(List.of("Bran Stark", "Jaime Lannister", "Tyrion Lannister",
        "Daenerys Targaryen", " Sansa Stark", "Cersei Lannister", "Arya Stark", "Jon Snow"));
    this.name = nameList.get(AddOns.getRandom(nameList.size(), 0));
    this.strength = rollDice(seeds[0]);
    this.constitution = rollDice(seeds[1]);
    this.dexterity = rollDice(seeds[2]);
    this.charisma = rollDice(seeds[3]);
    equipmentBag = new ArrayList<AddOns>();
    gearEquipped = new ArrayList<AddOns>();
    gearAbility = new int[4];
    sword = Swords.getRandomSword(1);
  }

  /**
   * To get the Weapon strength.
   */
  public int getWeaponDamage(int seed) {
    int multiplier = 1;
    if ((strength > 14 && Objects.equals(this.sword, Swords.TWOHANDED))
        || (dexterity > 14 && Objects.equals(this.sword, Swords.FLAILS))
        || (strength > 10 && dexterity > 10 && Objects.equals(this.sword, Swords.KATANA))) {
      multiplier = 2;
    }
    return sword.getSwordStrength(seed) * multiplier;
  }

  /**
   * Roll a dice to determine the stats of the player.
   */
  int rollDice(int seed) {
    int res = 0;
    int add;
    Random r = new Random(seed);
    for (int i = 0; i < 3; i++) {
      add = r.ints(1, 2, 6).findFirst().getAsInt();
      res += add;
    }
    return res;
  }

  /**
   * To Maintain negative addon compliance.
   */
  public void negativeCompliance() {
    for (int i = 1; i < equipmentBag.size(); i = i + 4) {
      equipmentBag.get(i).changeDexterity *= -1;
      equipmentBag.get(i).changeCharisma *= -1;
      equipmentBag.get(i).changeConstitution *= -1;
      equipmentBag.get(i).changeStrength *= -1;
      //System.out.println("Changing sign");
    }

  }


  /**
   * To create an equipment bag.
   */
  public void createEquipmentBag(int seed) {
    //System.out.println(equipmentBag.size());
    while (equipmentBag.size() < 5) {
      HeadGears h = new HeadGears(seed);
      equipmentBag.add(h);
    }
    while (equipmentBag.size() < 10) {
      FootWear f = new FootWear(seed);
      equipmentBag.add(f);
    }
    while (equipmentBag.size() < 25) {
      Belts b = new Belts(seed);
      equipmentBag.add(b);
    }
    while (equipmentBag.size() < 40) {
      Potions p = new Potions(seed);
      equipmentBag.add(p);
    }
    negativeCompliance();
  }

  /**
   * To randomly assign 20 items from the bag.
   */
  public ArrayList<Integer> assignRandomBag() {
    int i;
    ArrayList<Integer> assignedBag = new ArrayList<>();
    for (i = 0; i < equipmentBag.size(); i++) {
      assignedBag.add(i);
    }
    Collections.shuffle(assignedBag);
    ArrayList<Integer> res = new ArrayList<>();
    for (i = 0; i < 19; i++) {
      res.add(assignedBag.get(i));
    }
    return res;
  }

  /**
   * Method to request for a weapon.
   */
  public String getWeapon() {
    return sword.name();
  }

  @Override
  public int getStrength() {
    return this.strength;
  }

  @Override
  public int getConstitution() {
    return this.constitution;
  }

  @Override
  public int getDexterity() {
    return this.dexterity;
  }

  @Override
  public int getCharisma() {
    return this.charisma;
  }

  /**
   * To reduce the health when taking damage.
   */
  public void loseHealth(int damage) {
    this.health -= damage;
  }

  @Override
  public int getHealth() {
    return health;
  }

  /**
   * Reset Health for a Rematch.
   */
  public void resetHealth() {
    this.strength -= gearAbility[0];
    this.constitution -= gearAbility[1];
    this.dexterity -= gearAbility[2];
    this.charisma -= gearAbility[3];
    this.health = this.strength - + this.constitution + this.dexterity + this.charisma;
  }

  /**
   * Sort the Gear in order from top to bottom and alphabetically.
   */
  public void sortGear() {
    Collections.sort(gearEquipped);
  }

  @Override
  public int getStrikingPower() {
    Random random = new Random(2);
    //System.out.println(gearAbility[0]);
    return strength + gearAbility[0] + random.nextInt(10);
  }

  public String getName() {
    return this.name;
  }


  @Override
  public int getAvoidance() {
    Random random = new Random(1);
    return dexterity + gearAbility[2] + random.nextInt(6);
  }

  @Override
  public String toString() {
    return (String.format("%s\n strength= %d\n constitution= %d\n dexterity= %d\n charisma= %d",
        name, strength, constitution, dexterity, charisma));
  }

  /**
   * To equip the player from the bag of items.
   */
  public List<AddOns> equipGear(int seed) {
    int countHeadGear = 0;
    int countBeltUnits = 0;
    int countFootwear = 0;
    createEquipmentBag(seed);
    List<Integer> assignedBag = assignRandomBag();
    //System.out.println(assignedBag.size());
    for (Integer integer : assignedBag) {
      //System.out.println(equipmentBag.get(integer).getType());
      if (countHeadGear == 0 && equipmentBag.get(integer).getType().equals("HeadGears")) {
        gearEquipped.add(equipmentBag.get(integer));
        countHeadGear++;
      }
      if (equipmentBag.get(integer).getType().equals("Belts") && countBeltUnits < 10) {
        gearEquipped.add(equipmentBag.get(integer));
        countBeltUnits += ((Belts) equipmentBag.get(integer)).getSize();
      }
      if (countFootwear == 0 && equipmentBag.get(integer).getType().equals("FootWear")) {
        gearEquipped.add(equipmentBag.get(integer));
        countFootwear++;
      }
      if (equipmentBag.get(integer).getType().equals("Potions")) {
        gearEquipped.add(equipmentBag.get(integer));
      }
    }
    //System.out.println(gearEquipped.size());
    for (AddOns a : gearEquipped) {
      /*System.out.println(gearAbility[0] + "\t" + gearAbility[1] + "\t" + gearAbility[2]
          + "\t" + gearAbility[3] + "\t");
      */
      gearAbility[0] += a.changeStrength;
      gearAbility[1] += a.changeConstitution;
      gearAbility[2] += a.changeDexterity;
      gearAbility[3] += a.changeCharisma;
    }
    this.strength += gearAbility[0];
    this.constitution += gearAbility[1];
    this.dexterity += gearAbility[2];
    this.charisma += gearAbility[3];
    sortGear();
    health = this.strength + this.charisma + this.constitution + this.dexterity;
    //calculatePotentialDamage();
    List<AddOns> gearEquippedCopy;
    gearEquippedCopy = new ArrayList<>(gearEquipped);
    return gearEquippedCopy;
  }

  /**
   * To Return a copy of the equipment bag for testing.
   *
   * @return ArrayList of Equipments.
   */
  public List<AddOnInterface> getEquipmentBag() {
    List<AddOnInterface> equipmentBagCopy;
    equipmentBagCopy = new ArrayList<AddOnInterface>(equipmentBag);
    return equipmentBagCopy;
  }


}
