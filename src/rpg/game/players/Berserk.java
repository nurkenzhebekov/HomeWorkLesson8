package rpg.game.players;

public class Berserk extends Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK_DAMAGE_AND_REVERT, name);
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getDefence() != SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
            boss.setHealth(boss.getHealth() - this.blockedDamage);
            System.out.println("--> Berserk " + this.getName() + " reverted " +
                    blockedDamage);
        }
    }
}
