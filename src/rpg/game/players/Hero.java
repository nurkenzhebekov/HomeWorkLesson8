package rpg.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility ability;
    private final int originalDamage;

    public Hero(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
        this.originalDamage = damage;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public int getOriginalDamage() {
        return originalDamage;
    }
}
