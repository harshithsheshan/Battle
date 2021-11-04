package battlegame;

import java.util.Scanner;

/**
 * Battle.Driver Class for the program to check the runs and scenario's.
 */
public class Driver {
  /**
   * Main Method which explains what is happening and takes user input for a choice of rematch.
   */
  public static void main(String[] args) {
    boolean rematch = true;
    Battle battle;
    battle = new Battle();
    Scanner sc = new Scanner(System.in);

    while (rematch) {
      battle.boutNoGear();
      battle.bout();
      System.out.println(battle.getWarTranscript());
      System.out.println("Do you want a Rematch?(Y/N)");
      char ch = sc.next().charAt(0);
      if (ch == 'N' || ch == 'n') {
        rematch = false;
      } else if (ch == 'Y' || ch == 'y') {
        battle.rematch();
      } else {
        throw new IllegalArgumentException();
      }
    }
  }
}
