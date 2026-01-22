package entity;

import constants.Constants;
import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.ArrayList;
import java.util.Map;

public abstract class Animal extends Organism implements Constants{

    public void eat() {
        Location loc = this.location[getColumn()][getLine()];
        loc.getLock().lock();

        try {
            Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;
            OrganismType type = this.getType();
            Map<Class<? extends Organism>, Integer> attackAnimal = type.getAttackAnimal();

            Organism organismAttack = null;
            int maxChance = 0;

            for (Organism organism : new ArrayList<>(animalLiveCount.keySet())) {
                if (organism.getClass() == this.getClass()) {
                    continue;
                }

                Integer chance = attackAnimal.get(organism.getClass());
                if (chance != null && chance > maxChance) {
                    maxChance = chance;
                    organismAttack = organism;
                    break;
                }
            }

            if (organismAttack != null && Random.getRandomCount(MAX_PROBABILITY) <= maxChance) {
                loc.removeAnimalLiveCount(organismAttack);

                this.setHunger(this.getHunger() - organismAttack.getType().getWeight());
                if (this.getHunger() < LACK_OF_HUNGER) {
                    this.setHunger(LACK_OF_HUNGER);
                }
            }

        } finally {
            loc.getLock().unlock();

        }
    }

    public void multiply() {
        Location loc = location[getColumn()][getLine()];
        loc.getLock().lock();

        try {
            if (loc.getCountType(this) >= Settings.NUMBER_TO_MULTIPLY
                    && (this.getHunger() == LACK_OF_HUNGER)) {
                Fabric.createEatable(this.getType());
                this.setHunger(this.getType().getPrimaryHunger());
            }
        } finally {
            loc.getLock().unlock();

        }
    }

    public void move() {
        if (getType().getMaxMove() == 0) {
            return;
        }

        int oldColumn = getColumn();
        int oldLine = getLine();

        int newColumn = oldColumn;
        int newLine = oldLine;

        int maxSteps = Random.getRandomCount(getType().getMaxMove() + 1);

        for (int i = 0; i < maxSteps; i++) {
            int dir = Random.getRandomCount(4);

            int tempCol = newColumn;
            int tempLine = newLine;

            switch (dir) {
                case 0 -> tempLine++;
                case 1 -> tempLine--;
                case 2 -> tempCol++;
                case 3 -> tempCol--;
            }

            if (isAnimalCanMove(tempCol, tempLine)) {
                newColumn = tempCol;
                newLine = tempLine;
            }
        }

        if (oldColumn == newColumn && oldLine == newLine) {
            return;
        }

        Location oldLoc = location[oldColumn][oldLine];
        Location newLoc = location[newColumn][newLine];

        Location first = oldLoc.hashCode() < newLoc.hashCode() ? oldLoc : newLoc;
        Location second = first == oldLoc ? newLoc : oldLoc;

        first.getLock().lock();
        second.getLock().lock();

        try {
            setColumn(newColumn);
            setLine(newLine);

            oldLoc.removeAnimalLiveCount(this);
            newLoc.putAnimalLiveCount(this);
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();

        }
    }

    public boolean isAnimalCanMove(int column, int line) {
        if (column < 0 || column >= Settings.COLUMNS
                || line < 0 || line >= Settings.LINES) {
            return false;
        }

        Location loc = location[column][line];
        loc.getLock().lock();
        try {
            return loc.getCountType(this) < getType().getMaxCountCell();
        } finally {
            loc.getLock().unlock();
        }
    }
}
