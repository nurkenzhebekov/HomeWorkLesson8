package rpg.game.players;

import rpg.game.logic.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(4) + 2; //2,3,4,5
        boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
        System.out.println("--> Warrior " + this.getName() + " reverted " +
                this.getDamage() * coeff);
    }
}

