package rpg.game.players;

public class Magic extends Hero {

    private int boostAmount;

    public Magic(int health, int damage, String name, int boostAmount) {
        super(health, damage, SuperAbility.BOOST, name);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && this != hero) {
                int originalDamage = hero.getOriginalDamage();
                int newDamage = originalDamage + boostAmount;
                hero.setDamage(newDamage);
                System.out.println("--> Magic " + this.getName() + " boosted " +
                        hero.getName() + "'s damage by " + boostAmount);
            }
        }
    }
}