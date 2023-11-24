package rpg.game.logic;

import rpg.game.players.*;
import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(3000, 100, "Tanos");
        Warrior warrior1 = new Warrior(250, 10, "Manas");
        Medic doc = new Medic(200, 5, 10, "Ahunbai");
        Warrior warrior2 = new Warrior(240, 15, "Semetei");
        Magic magic = new Magic(210, 20, "Potter", 5);
        Berserk berserk = new Berserk(230, 10, "Viking");
        Medic assistant = new Medic(220, 5, 5, "Anna");
        Witcher witcher = new Witcher(200, 0, "White Wolf");
        Thor thor = new Thor(230, 15, "Thor");
        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, witcher, thor};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
}
