package entity;

import entity.herbivore.*;
import entity.predator.*;
import java.util.HashMap;
import java.util.Map;

public enum EatableType {

    BOAR(400d, 2, 50, new HashMap<>() {{
        put(Module.class, 50);
        put(Caterpillar.class, 90);
        put(Plant.class, 100);
    }}),
    BUFFALO(700d, 3, 10, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    CATERPILLAR(0.01d, 0, 1000, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    DEER(300d, 4, 20, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    DUCK(1d, 4, 200, new HashMap<>() {{
        put(Caterpillar.class, 90);
        put(Plant.class, 100);
    }}),
    GOAT(60d, 3, 140, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    HORSE(400d, 4, 20, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    MOUSE(0.05d, 1, 500, new HashMap<>() {{
        put(Caterpillar.class, 90);
        put(Plant.class, 100);
    }}),
    RABBIT(2d, 2, 150, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    SHEEP(70d, 3, 140, new HashMap<>() {{
        put(Plant.class, 100);
    }}),
    BEAR(500d, 2, 5, new HashMap<>() {{
        put(Boa.class, 80);
        put(Horse.class, 40);
        put(Deer.class, 80);
        put(Rabbit.class, 80);
        put(Mouse.class, 90);
        put(Duck.class, 60);
        put(Caterpillar.class, 40);
    }}),
    BOA(15d, 1, 30, new HashMap<>() {{
        put(Fox.class, 15);
        put(Rabbit.class, 20);
        put(Mouse.class, 40);
        put(Duck.class, 10);
    }}),
    EAGLE(6d, 3, 20, new HashMap<>() {{
        put(Fox.class, 10);
        put(Rabbit.class, 90);
        put(Mouse.class, 90);
        put(Duck.class, 80);
    }}),
    FOX(8d, 2, 30, new HashMap<>() {{
        put(Rabbit.class, 70);
        put(Mouse.class, 90);
        put(Duck.class, 60);
        put(Caterpillar.class, 40);
    }}),
    WOLF(50d, 3, 30, new HashMap<>() {{
        put(Horse.class, 10);
        put(Deer.class, 15);
        put(Rabbit.class, 60);
        put(Mouse.class, 80);
        put(Goat.class, 60);
        put(Sheep.class, 70);
        put(Bear.class, 15);
        put(Buffalo.class, 10);
        put(Duck.class, 40);
    }}),
    PLANT(0d, 0, 200, new HashMap<>() {{
    }});

    private final double weight;
    private final int maxMove;
    private final int maxCountCell;
    private final Map<Class, Integer> attackAnimal;

    EatableType(double weight, int maxMove, int maxCountCell, Map<Class, Integer> attackAnimal) {
        this.weight = weight;
        this.maxMove = maxMove;
        this.maxCountCell = maxCountCell;
        this.attackAnimal = attackAnimal;
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

    public Map<Class, Integer> getAttackAnimal() {
        return attackAnimal;
    }
}
