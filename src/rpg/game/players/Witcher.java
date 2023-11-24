package rpg.game.players;

public class Witcher extends Hero {

    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.REVIVE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0 && this != hero) {
                int witcherHealth = this.getHealth();
                hero.setHealth(witcherHealth);
                this.setHealth(0);
                System.out.println("--> Witcher " + this.getName() + " sacrificed himself " +
                        " to revive " + hero.getName() + " with his health");
                break;
            }
        }
    }
}
