package rpg.game.players;

public abstract class GameEntity {
    private int health;
    private int damage;
    private String name;

    public GameEntity(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        /*return getClass().getSimpleName() + " HEALTH: " + this.health +
                " DAMAGE: " + this.damage;*/
        return this.name + " HEALTH: " + this.health +
                " DAMAGE: " + this.damage;
    }
}

