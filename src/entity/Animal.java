package entity;

import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal extends Organism {
    ReentrantLock lock = new ReentrantLock();

    public void eat() {   // реализация сырая , не совсем четко проработа выборка поедания
        try {
            lock.lock();
            Location loc = location[getColumn()][getLine()];
            Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;

            OrganismType type = OrganismType.valueOf(this.getClass().getSimpleName().toUpperCase());
            Map<Class, Integer> attackAnimal = type.getAttackAnimal();

            Organism organismAttack = null;
            int verAttack = 0;

            for (Organism organism : animalLiveCount.keySet()) {
                Class<? extends Organism> organismClass = organism.getClass();
                if (attackAnimal.containsKey(organismClass) && attackAnimal.get(organismClass) > verAttack) {
                    organismAttack = organism;
                    verAttack = attackAnimal.get(organismClass);
                }
            }
            if (organismAttack != null && Random.getRandomCount(100) <= verAttack) {
                animalLiveCount.remove(organismAttack); // изменение лучше делать в классе локатион
            }
        } finally {
            lock.unlock();
        }
    }

    public void multiply() {
            Location loc = location[getColumn()][getLine()];
           if (loc.getCountType(this) >= 2){
               Fabric.createEatable(this.getType());
           }
    }

    public void move() {
        OrganismType organismType = getType();
        int oldColum = getColumn();
        int oldLine = getLine();

        int maxCountMove = Random.getRandomCount(organismType.getMaxMove());
        for (int i = 0; i < maxCountMove; i++) {
            int randomCount = Random.getRandomCount(4);
            int colum = getColumn();
            int line = getLine();
            switch (randomCount) {
                case 0 -> setLine(line + 1);
                case 1 -> setLine(line - 1);
                case 2 -> setColumn(colum + 1);
                case 3 -> setColumn(colum - 1);
            }
            if (!isAnimalCanMove()) {
                setColumn(colum);
                setLine(line);
            }
        }
        if ((getColumn() != oldColum) ||
                (getLine() != oldLine)) {
            location[getColumn()][getLine()].putAnimalLiveCount(this);
            location[oldColum][oldLine].removeAnimalLiveCount(this);

        }
    }

    public boolean isAnimalCanMove() {
        OrganismType organismType = getType();
        return (getColumn() >= 0 && getColumn() < Settings.COLUMNS && getLine() >= 0 && getLine() < Settings.LINES
                && location[getColumn()][getLine()].getCountType(this) < organismType.getMaxCountCell());
    }

}
