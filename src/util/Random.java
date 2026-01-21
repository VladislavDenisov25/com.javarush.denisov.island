package util;

import entity.Organism;
import entity.OrganismType;
import entity.island.Location;
import repository.Fabric;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Random {

    public static int getRandomCount(int maxCount){
        return ThreadLocalRandom.current().nextInt(maxCount);
    }

    public static int getRandomCount(int minCount, int maxCount){
        return ThreadLocalRandom.current().nextInt(minCount, maxCount);
    }
}

//public void eat() {
//
//    try {
//        Location loc = location[getColumn()][getLine()];
//        loc.getLock().lock();
//        Map<Organism, Integer> animalLiveCount = loc.animalLiveCount;
//
//        OrganismType type = this.getType();
//        Map<Class, Integer> attackAnimal = type.getAttackAnimal();
//
//        Organism organismAttack = null;
//        int verAttack = 0;
//
//        for (Organism organism : animalLiveCount.keySet()) {
//            if (organism.getClass() == this.getClass()){
//                continue;
//            }
//            if (attackAnimal.containsKey(organism.getClass()) && attackAnimal.get(organism.getClass()) > verAttack) {
//                organismAttack = organism;
//                verAttack = attackAnimal.get(organism.getClass());
//            }
//        }
//        if (organismAttack != null && Random.getRandomCount(100) <= verAttack) {
//            loc.removeAnimalLiveCount(organismAttack);
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }finally
//    {
//        location[getColumn()][getLine()].getLock().unlock();
//    }
//
//}
//
//public void multiply() {
//    try {
//        Location loc = location[getColumn()][getLine()];
//        loc.getLock().lock();
//        if (loc.getCountType(this) >= 2) {
//            Fabric.createEatable(this.getType());
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }finally {
//        location[getColumn()][getLine()].getLock().unlock();
//    }
//}
//
//public void move() {
//    try {
//        location[getColumn()][getLine()].getLock().lock();
//        if (this.getType().getMaxMove() == 0){
//            return;
//        }
//        OrganismType organismType = getType();
//        int oldColum = getColumn();
//        int oldLine = getLine();
//
//        int maxCountMove = Random.getRandomCount(organismType.getMaxMove());
//        for (int i = 0; i < maxCountMove; i++) {
//            int randomCount = Random.getRandomCount(4);
//            int colum = getColumn();
//            int line = getLine();
//            switch (randomCount) {
//                case 0 -> setLine(line + 1);
//                case 1 -> setLine(line - 1);
//                case 2 -> setColumn(colum + 1);
//                case 3 -> setColumn(colum - 1);
//            }
//            if (!isAnimalCanMove()) {
//                setColumn(colum);
//                setLine(line);
//            }
//        }
//        if ((getColumn() != oldColum) ||
//                (getLine() != oldLine)) {
//            location[getColumn()][getLine()].putAnimalLiveCount(this);
//            location[oldColum][oldLine].removeAnimalLiveCount(this);
//
//        }
//    }catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        location[getColumn()][getLine()].getLock().unlock();
//    }
//}