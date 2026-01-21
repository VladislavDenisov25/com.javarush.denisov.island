package entity;

import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;
import java.util.ArrayList;
import java.util.Map;

public abstract class Animal extends Organism {

    public void eat() { // не едят траву и вымирает вид  вымирает вид
        Location loc = this.location[getColumn()][getLine()];
        loc.getLock().lock();

        try {
            Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;
            OrganismType type = this.getType();
            Map<Class, Integer> attackAnimal = type.getAttackAnimal();

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
                }
            }

            if (organismAttack != null && Random.getRandomCount(100) <= maxChance) {
                loc.removeAnimalLiveCount(organismAttack);
                //           System.out.printf("%s сьедает %s\n", this.getType().getEmojiOrganism(), organismAttack.getType().getEmojiOrganism());
            }

        } finally {
            loc.getLock().unlock();

        }
    }

    public void multiply() { // только при полном желудке
        Location loc = location[getColumn()][getLine()];
        loc.getLock().lock();

        try {
            if (loc.getCountType(this) >= 2) {
                Fabric.createEatable(this.getType());
//                System.out.printf("рождение %s \n", this.getType().getEmojiOrganism());
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

        int maxSteps = Random.getRandomCount(getType().getMaxMove());

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
//           System.out.printf("%s ушел с локации %d %d в локацию %d %d\n", this.getType().getEmojiOrganism(), oldColumn, oldLine, newColumn, newLine);
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
