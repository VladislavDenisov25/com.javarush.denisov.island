package entity;

import entity.island.Location;
import repository.Fabric;
import util.Random;
import util.Settings;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal extends Organism {

    public void eat() {
        Location loc = this.location[getColumn()][getLine()];
        loc.getLock().lock();
        System.out.printf("Заблокирована локация: %d %d в методе eat\n", this.getColumn(), this.getLine());
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
            }

        } finally {
            loc.getLock().unlock();
            System.out.printf("Разблокирована локация: %d %d в методе eat\n", this.getColumn(), this.getLine());
        }
    }

    public void multiply() {
        Location loc = location[getColumn()][getLine()];
        loc.getLock().lock();
        System.out.printf("Заблокирована локация: %d %d в методе multiply\n", this.getColumn(), this.getLine());
        try {
            if (loc.getCountType(this) >= 2) {
                Fabric.createEatable(this.getType());
            }
        } finally {
            loc.getLock().unlock();
            System.out.printf("Разблокирована локация: %d %d в методе multiply\n", this.getColumn(), this.getLine());
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
        System.out.printf("локация: %d %d в методе move\n", oldColumn, oldLine);
        Location newLoc = location[newColumn][newLine];
        System.out.printf("локация: %d %d в методе move\n", newColumn, newLine);

        // Фиксированный порядок lock'ов — защита от deadlock
        Location first = oldLoc.hashCode() < newLoc.hashCode() ? oldLoc : newLoc;
        if (first == oldLoc){
            System.out.printf("у first координаты %d %d\n метод move", oldColumn, oldLine);
            System.out.printf("у second координаты %d %d\n метод move", newColumn, newLine);
        } else {
            System.out.printf("у second координаты %d %d\n метод move", oldColumn, oldLine);
            System.out.printf("у first координаты %d %d\n метод move", newColumn, newLine);
        }
        Location second = first == oldLoc ? newLoc : oldLoc;

        first.getLock().lock();
        second.getLock().lock();
        System.out.println("потоки метода move заблокированы");
        try {
            setColumn(newColumn);
            setLine(newLine);

            oldLoc.removeAnimalLiveCount(this);
            newLoc.putAnimalLiveCount(this);

        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
            System.out.println("потоки метода move разблокированы");
        }
    }

    public boolean isAnimalCanMove(int column, int line) {
        if (column < 0 || column >= Settings.COLUMNS
                || line < 0 || line >= Settings.LINES) {
            return false;
        }

        Location loc = location[column][line];
        loc.getLock().lock();
        System.out.printf("локация: %d %d в методе isAnimal заблокирована\n", column, line);
        try {
            return loc.getCountType(this) < getType().getMaxCountCell();
        } finally {
            loc.getLock().unlock();
            System.out.printf("локация: %d %d в методе isAnimal разблокирована\n", column, line);
        }
    }
//    public boolean isAnimalCanMove() {
//        OrganismType organismType = getType();
//        return (getColumn() >= 0 && getColumn() < Settings.COLUMNS
//                && getLine() >= 0 && getLine() < Settings.LINES
//                && location[getColumn()][getLine()].getCountType(this)
//                < organismType.getMaxCountCell());
//    }

}
