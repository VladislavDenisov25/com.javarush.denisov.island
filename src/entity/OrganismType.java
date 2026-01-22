package entity;

import entity.herbivore.*;
import entity.plant.Grass;
import entity.predator.*;

import java.util.HashMap;
import java.util.Map;

public enum OrganismType {

    BOAR(400d, 50d, 2, 50, new HashMap<>() {{
        put(Mouse.class, 50);
        put(Caterpillar.class, 90);
        put(Grass.class, 100);
    }}, "\uD83D\uDC17"),
    BUFFALO(700d, 100d, 3, 10, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC03"),
    CATERPILLAR(0.01d, 0d, 0, 1000, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC1B"),
    DEER(300d, 50d, 4, 20, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83E\uDD8C"),
    DUCK(1d, 0.15d, 4, 200, new HashMap<>() {{
        put(Caterpillar.class, 90);
        put(Grass.class, 100);
    }}, "\uD83E\uDD86"),
    GOAT(60d, 10d, 3, 140, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC10"),
    HORSE(400d, 60d, 4, 20, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC0E"),
    MOUSE(0.05d, 0.1d, 1, 500, new HashMap<>() {{
        put(Caterpillar.class, 90);
        put(Grass.class, 100);
    }}, "\uD83D\uDC01"),
    RABBIT(2d, 0.45d, 2, 150, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC07"),
    SHEEP(70d, 15d, 3, 140, new HashMap<>() {{
        put(Grass.class, 100);
    }}, "\uD83D\uDC11"),
    BEAR(500d, 80d, 2, 5, new HashMap<>() {{
        put(Boa.class, 80);
        put(Horse.class, 40);
        put(Deer.class, 80);
        put(Rabbit.class, 80);
        put(Mouse.class, 90);
        put(Goat.class, 70);
        put(Sheep.class, 70);
        put(Boar.class, 50);
        put(Buffalo.class, 20);
        put(Duck.class, 10);
    }}, "\uD83D\uDC3B"),
    BOA(15d, 3d, 1, 30, new HashMap<>() {{
        put(Fox.class, 15);
        put(Rabbit.class, 20);
        put(Mouse.class, 40);
        put(Duck.class, 10);
    }}, "\uD83D\uDC0D"),
    EAGLE(6d, 1d, 3, 20, new HashMap<>() {{
        put(Fox.class, 10);
        put(Rabbit.class, 90);
        put(Mouse.class, 90);
        put(Duck.class, 80);
    }}, "\uD83E\uDD85"),
    FOX(8d, 2d, 2, 30, new HashMap<>() {{
        put(Rabbit.class, 70);
        put(Mouse.class, 90);
        put(Duck.class, 60);
        put(Caterpillar.class, 40);
    }}, "\uD83E\uDD8A"),
    WOLF(50d, 8d, 3, 30, new HashMap<>() {{
        put(Horse.class, 10);
        put(Deer.class, 15);
        put(Rabbit.class, 60);
        put(Mouse.class, 80);
        put(Goat.class, 60);
        put(Sheep.class, 70);
        put(Boar.class, 15);
        put(Buffalo.class, 10);
        put(Duck.class, 40);
    }}, "\uD83D\uDC3A"),
    GRASS(0d, 0d, 0, 200, new HashMap<>() {
    }, "\uD83C\uDF31");

    private final double weight;
    private final double hunger;
    private final int maxMove;
    private final int maxCountCell;
    private final Map<Class<? extends Organism>, Integer> attackAnimal;
    private final String emojiOrganism;


    OrganismType(double weight, double hunger, int maxMove, int maxCountCell, Map<Class<? extends Organism>, Integer> attackAnimal, String emojiOrganism) {
        this.weight = weight;
        this.hunger = hunger;
        this.maxMove = maxMove;
        this.maxCountCell = maxCountCell;
        this.attackAnimal = attackAnimal;
        this.emojiOrganism = emojiOrganism;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxMove() {
        return maxMove;
    }

    public int getMaxCountCell() {
        return maxCountCell;
    }

    public Map<Class<? extends Organism>, Integer> getAttackAnimal() {
        return attackAnimal;
    }

    public String getEmojiOrganism() {
        return emojiOrganism;
    }

    public double getPrimaryHunger() {
        return hunger;
    }
}
