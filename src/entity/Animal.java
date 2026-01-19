package entity;

import entity.island.Location;
import util.Random;
import util.Settings;

import java.util.Map;

public abstract class Animal extends Organism {


   public void eat() {
        Location loc = location[getColumn()][getLine()];
        Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;

       for (Organism organism : animalLiveCount.keySet()) {
           System.out.println(organism);
       }

        OrganismType type = OrganismType.valueOf(this.getClass().getSimpleName().toUpperCase());
        Map<Class, Integer> attackAnimal = type.getAttackAnimal();

        Organism organismAttack = null;
        int verAttack = 0;

        for (Organism organism : animalLiveCount.keySet()) {
            Class<? extends Organism> organismClass = organism.getClass();
            if (attackAnimal.containsKey(organismClass) && attackAnimal.get(organismClass) > verAttack){
                organismAttack = organism;
                verAttack = attackAnimal.get(organismClass);
            }
        }
        if (organismAttack != null && Random.getRandomCount(100) <= verAttack){
            animalLiveCount.remove(organismAttack);
        }

    }




    void multiply(Organism organism) {
        organism = null;
    }

    public void move() {
            Location oldLocation = location[getColumn()][getLine()];
            int randomCount = Random.getRandomCount(4);
            switch (randomCount){
                case 0 -> setLine(getLine() + 1); // верх
                case 1 -> setLine(getLine() - 1); // вниз
                case 2 -> setColumn(getColumn() + 1); // вправо
                case 3 -> setColumn(getColumn() - 1); // влево
            }
            if (getColumn() < 0 || getColumn() >= Settings.COLUMNS
                    || getLine() < 0 || getLine() >= Settings.LINES) {
                System.out.println(this.getClass().getSimpleName() + " Ушел с этого острова!");
            } else {
                location[getColumn()][getLine()].animalLiveCount.put(this, 1);
                System.out.println(this.getClass().getSimpleName() + " еще тут");
            }
            oldLocation.animalLiveCount.remove(this);

    }
}
