package util;


import entity.Animal;
import entity.Eatable;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

import java.util.HashMap;
import java.util.Map;

public final class Settings {

    public static final int X = 10;
    public static final int Y = 1;

    public static final int minCreatCountAnimal = 1;
    public static final int maxCreatCountPlant = 5;

    public final static Map<Class<? extends Eatable>, Map<Class<? extends Eatable>, Integer>> animalAttack = new HashMap<>() {{

        animalAttack.put(Wolf.class, new HashMap<>() {{
            put(Horse.class, 10);
            put(Deer.class, 15);
            put(Rabbit.class, 60);
            put(Mouse.class, 80);
            put(Goat.class, 60);
            put(Sheep.class, 70);
            put(Bear.class, 15);
            put(Buffalo.class, 10);
            put(Duck.class, 40);
        }});

        animalAttack.put(Boa.class, new HashMap<>() {{
            put(Fox.class, 15);
            put(Rabbit.class, 20);
            put(Mouse.class, 40);
            put(Duck.class, 10);
        }});

        animalAttack.put(Fox.class, new HashMap<>() {{
            put(Rabbit.class, 70);
            put(Mouse.class, 90);
            put(Duck.class, 60);
            put(Caterpillar.class, 40);
        }});

        animalAttack.put(Bear.class, new HashMap<>() {{
            put(Boa.class, 80);
            put(Horse.class, 40);
            put(Deer.class, 80);
            put(Rabbit.class, 80);
            put(Mouse.class, 90);
            put(Duck.class, 60);
            put(Caterpillar.class, 40);
        }});

        animalAttack.put(Eagle.class, new HashMap<>() {{
            put(Fox.class, 10);
            put(Rabbit.class, 90);
            put(Mouse.class, 90);
            put(Duck.class, 80);
        }});

        animalAttack.put(Horse.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Deer.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Rabbit.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Mouse.class, new HashMap<>() {{
            put(Caterpillar.class, 90);
            put(Plant.class, 100);
        }});

        animalAttack.put(Goat.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Sheep.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Boar.class, new HashMap<>() {{
            put(Mouse.class, 50);
            put(Caterpillar.class, 90);
            put(Plant.class, 100);
        }});

        animalAttack.put(Buffalo.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

        animalAttack.put(Duck.class, new HashMap<>() {{
            put(Caterpillar.class, 90);
            put(Plant.class, 100);
        }});

        animalAttack.put(Caterpillar.class, new HashMap<>() {{
            put(Plant.class, 100);
        }});

    }};

    public final static Map<Class<? extends Eatable>, Integer> animalMaxCount = new HashMap<>() {{
        put(Wolf.class, 30);
        put(Boa.class, 30);
        put(Fox.class, 30);
        put(Bear.class, 5);
        put(Eagle.class, 20);
        put(Horse.class, 20);
        put(Deer.class, 20);
        put(Rabbit.class, 150);
        put(Mouse.class, 500);
        put(Goat.class, 140);
        put(Sheep.class, 140);
        put(Boar.class, 50);
        put(Buffalo.class, 10);
        put(Duck.class, 200);
        put(Caterpillar.class, 1000);
        put(Plant.class, 200);
    }};

    public final static Map<Class<? extends Eatable>, Integer> animalMaxMove = new HashMap<>() {{
        put(Wolf.class, 3);
        put(Boa.class, 1);
        put(Fox.class, 2);
        put(Bear.class, 2);
        put(Eagle.class, 3);
        put(Horse.class, 4);
        put(Deer.class, 4);
        put(Rabbit.class, 2);
        put(Mouse.class, 1);
        put(Goat.class, 3);
        put(Sheep.class, 3);
        put(Boar.class, 2);
        put(Buffalo.class, 3);
        put(Duck.class, 4);
        put(Caterpillar.class, 0);
    }};

    public final static Map<Class<? extends Eatable>, Double> eatableWeigth = new HashMap<>() {{
        put(Wolf.class, 50d);
        put(Boa.class, 15d);
        put(Fox.class, 8d);
        put(Bear.class, 500d);
        put(Eagle.class, 6d);
        put(Horse.class, 400d);
        put(Deer.class, 300d);
        put(Rabbit.class, 2d);
        put(Mouse.class, 0.05d);
        put(Goat.class, 60d);
        put(Sheep.class, 70d);
        put(Boar.class, 400d);
        put(Buffalo.class, 700d);
        put(Duck.class, 1d);
        put(Caterpillar.class, 0.01d);
        put(Plant.class, 1d);
    }};

}
