package rpg.game.players;

import rpg.game.logic.RPG_Game;

public class Thor extends Hero{

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean stunSuccessful = RPG_Game.random.nextBoolean();
        if (stunSuccessful) {
            boss.setStunned(true);
            System.out.println("--> Thor " + this.getName() + " stunned the boss for 1 round");
        }
    }
}
