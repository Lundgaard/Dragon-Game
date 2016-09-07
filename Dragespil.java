import java.util.*;

public class Dragespil {
    public static void main(String [] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int dragonHp = 30;
        int humanHp = 15;
        int dragonAcc = 0;
        int humanAcc = 0;
        int dragonDmg = 0;
        int humanDmg = 0;
        int humanMove = 0;
        
        System.out.println("You have encounted a dragon!\nPrepare for battle!\n");
        System.out.println("Check your stats by typing 2\nCheck the dragon's stats by typing 3\n");
        System.out.println("Roll 6 or higher to hit the dragon");
        System.out.println("Roll 19 or higher for double damage\n");
        System.out.println("The dragon hits you if he rolls 8 or higher");
        System.out.println("The dragon does double damage if he rolls 20\n");
        while (humanHp > 0) {
            System.out.println("You attack the dragon!\nRoll the d20 by pressing 1\nYou need to roll at least 6 to hit the dragon");
            //Spillerens tur
            humanMove = scanner.nextInt();
            if (humanMove < 1 || humanMove > 3) {//Ikke-korrekt værdi indtastet
                System.out.println("Please press 1 to attack, 2 to see your stats, or 3 to see the dragon's stats");
                humanMove = scanner.nextInt();
            }
            
            if (humanMove == 2) {//Spillerens stats
                 System.out.println("You have " + humanHp + " left");
                 System.out.println("Your last accuracy roll was " + humanAcc);
                 System.out.println("Your last damage was " + humanDmg);
                 humanMove = scanner.nextInt();
            }
            
            if (humanMove == 3) {//Dragens stats
                 System.out.println("The dragon has " + dragonHp + " left");
                 System.out.println("The dragon's last accuracy roll was " + dragonAcc);
                 System.out.println("The dragon's last damage was " + dragonDmg);
                 humanMove = scanner.nextInt();
            }
            
            if (humanMove == 1 && dragonHp > 0) {//Spilleren angriber
                humanAcc = random.nextInt(20) + 1;
                System.out.println("\nYou rolled " + humanAcc);
                
                if (humanAcc >= 19) {//Hvis spilleren critter
                    System.out.println("Critical hit\n");
                    System.out.println("Roll the d4 by pressing 1");
                    humanMove = scanner.nextInt();
                    if (humanMove < 1 || humanMove > 3) {
                        System.out.println("Please press 1 to attack, 2 to see your stats, or 3 to see the dragons stats");
                        humanMove = scanner.nextInt();
                    }
            
                    if (humanMove == 2) {//Spillerens stats
                        System.out.println("You have " + humanHp + " life left");
                        System.out.println("Your last accuracy roll was " + humanAcc);
                        System.out.println("Your last damage was " + humanDmg);
                        humanMove = scanner.nextInt();
                    }
            
                    if (humanMove == 3) {//Dragens stats
                        System.out.println("The dragon has " + dragonHp + " life left");
                        System.out.println("The dragon's last accuracy roll was " + dragonAcc);
                        System.out.println("The dragon's last damage was " + dragonDmg);
                        humanMove = scanner.nextInt();
                    }
                    
                    if (humanMove == 1 && dragonHp > 0) {//Spilleren angriber
                        humanDmg = random.nextInt(4) + 1;
                        dragonHp = dragonHp - 2 * humanDmg;
                        System.out.println("\nYou did " + 2 * humanDmg + " damage to the dragon");
                        System.out.println("The dragon has " + dragonHp + " life left\n");
                    }
                } else if (humanAcc <= 6) {//Hvis spilleren ikke rammer
                    System.out.println("You missed\n");
                } else {//Hvis spilleren rammer
                    System.out.println("Roll the d4 by pressing 1");
                    humanDmg = random.nextInt(4) + 1;
                    humanMove = scanner.nextInt();
                    if (humanMove < 1 || humanMove > 3) {//Ikke-korrekt indtastet værdi
                        System.out.println("Please press 1 to attack, 2 to see your stats, or 3 to see the dragons stats");
                        humanMove = scanner.nextInt();
                    }
            
                    if (humanMove == 2) {//Spillerens stats
                        System.out.println("You have " + humanHp + " life left");
                        System.out.println("Your last accuracy roll was " + humanAcc);
                        System.out.println("Your last damage was " + humanDmg);
                        humanMove = scanner.nextInt();
                    }
            
                    if (humanMove == 3) {//Dragens stats
                        System.out.println("The dragon has " + dragonHp + " life left");
                        System.out.println("The dragon's last accuracy roll was " + dragonAcc);
                        System.out.println("The dragon's last damage was " + dragonDmg);
                        humanMove = scanner.nextInt();
                    }
                    
                    if (humanMove == 1 && dragonHp > 0) {//Spilleren angriber
                        humanDmg = random.nextInt(4) + 1;
                        dragonHp = dragonHp - humanDmg;
                        System.out.println("\nYou did " + humanDmg + " damage to the dragon");
                        System.out.println("The dragon has " + dragonHp + " life left\n");
                    }
                }
                
                if (dragonHp <= 0) {//Dragens angreb
                    System.out.println("You win!");
                } else {
                    System.out.println("The dragon attacks!");
                    dragonAcc = random.nextInt(20) + 1;
                    System.out.println("The dragon rolled " + dragonAcc);
                    
                    if (dragonAcc > 19) {//Dragen critter
                        System.out.println("Critical hit\n");
                        dragonDmg = random.nextInt(4) + 1;
                        humanHp = humanHp - 2 * dragonDmg;
                        System.out.println("The dragon did " + 2 * dragonDmg + " damage to you");
                        System.out.println("You have " + humanHp + " left\n");
                    } else if (dragonAcc <= 8) {//Dragen misser
                        System.out.println("The dragon missed\n");
                    } else {//Dragen angriber
                        dragonDmg = random.nextInt(4) + 1;
                        humanHp = humanHp - dragonDmg;
                        System.out.println("The dragon did " + dragonDmg + " damage to you");
                        System.out.println("You have " + humanHp + " life left\n");
                    }
                }
            }
        }
        System.out.println("You died!");
    }
}