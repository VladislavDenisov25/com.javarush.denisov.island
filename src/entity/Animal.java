package entity;

import entity.island.Location;
import util.Random;
import util.Settings;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal extends Organism {
ReentrantLock lock = new ReentrantLock();

    public void eat() {   // реализация сырая , не совсем четко проработа выборка поедания
        try {
            lock.tryLock();
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
        try {
            lock.tryLock();
            Location loc = location[getColumn()][getLine()];
            Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;

            for (Organism organism : animalLiveCount.keySet()) {
                if (organism.getClass() == this.getClass()) {
                    animalLiveCount.put(this, 1);
                    return;// добавление лучше делать в классе локатион
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void move() {
        try {
            lock.tryLock();
            Location oldLocation = location[getColumn()][getLine()];
            int randomCount = Random.getRandomCount(4);
            switch (randomCount) {
                case 0 -> setLine(getLine() + 1); // верх
                case 1 -> setLine(getLine() - 1); // вниз
                case 2 -> setColumn(getColumn() + 1); // вправо
                case 3 -> setColumn(getColumn() - 1); // влево
            }
            if (getColumn() < 0 || getColumn() >= Settings.COLUMNS
                    || getLine() < 0 || getLine() >= Settings.LINES) {
            } else {
                location[getColumn()][getLine()].animalLiveCount.put(this, 1);
            }
            oldLocation.animalLiveCount.remove(this);
        } finally {
            lock.unlock();
        }
    }
}
