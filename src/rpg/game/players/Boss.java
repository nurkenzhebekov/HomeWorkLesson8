package rpg.game.players;

import rpg.game.logic.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;
    private boolean stunned;
    private boolean skippedRound;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public void chooseDefence() {
        SuperAbility[] variants = SuperAbility.values();
        int randIndex = RPG_Game.random.nextInt(variants.length); // 0,1,2,3
        this.defence = variants[randIndex];
    }

    public void attack(Hero[] heroes) {
        if (!stunned) {
            if (!skippedRound) {
                for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() > 0) {
                        if (heroes[i] instanceof Berserk &&
                                this.defence != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                            boolean bigChance = RPG_Game.random.nextBoolean();
                            ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() /
                                    (bigChance ? 5 : 10));
                            heroes[i].setHealth(heroes[i].getHealth() -
                                    (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                            skippedRound = true;
                        } else {
                            stunned = false;
                            skippedRound = false;
                            heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                        }
                    }
                }
            }
        }
    }

    public SuperAbility getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " DEFENCE: " + this.defence;
    }
}
