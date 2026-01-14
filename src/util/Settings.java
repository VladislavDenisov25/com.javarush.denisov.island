package util;

import entity.Animal;
import entity.Eatable;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;



import java.util.HashMap;
import java.util.Map;

public final class Settings {

   static final int X = 1;
  static final int Y = 1;

    static final int minCreatCountPredator = 5;
    static final int minCreatCountHerbivore = 10;

   public final static Map<Eatable, Map<Eatable, Integer>> animalAttack = new HashMap<>() {{

        animalAttack.put(new Wolf(), new HashMap<>(){{
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 10);
        put(new Deer(), 15);
        put(new Rabbit(), 60);
        put(new Mouse(), 80);
        put(new Goat(), 60);
        put(new Sheep(), 70);
        put(new Boar(), 15);
        put(new Buffalo(), 10);
        put(new Duck(), 40);
        put(new Caterpillar(), 0);
        put(new Plant(), 0);
    }});

        animalAttack.put(new Boa(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Fox(), 15);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 20);
        put(new Mouse(), 40);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 10);
        put(new Caterpillar(), 0);
        put(new Plant(), 0);
    }});

        animalAttack.put(new Fox(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 70);
        put(new Mouse(), 90);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 60);
        put(new Caterpillar(), 40);
        put(new Plant(), 0);
    }});

        animalAttack.put(new Bear(),new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 80);
        put(new Fox(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 40);
        put(new Deer(), 80);
        put(new Rabbit(), 80);
        put(new Mouse(), 90);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 60);
        put(new Caterpillar(), 40);
        put(new Plant(), 0);
    }});

        animalAttack.put(new Eagle(),new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 10);
        put(new Bear(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 90);
        put(new Mouse(), 90);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 80);
        put(new Caterpillar(), 0);
        put(new Plant(), 0);
    }});

        animalAttack.put(new Horse(),new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Deer(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Rabbit(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Mouse(),new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 90);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Goat(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Sheep(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Boar(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 50);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 90);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Buffalo(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Duck(), 0);
        put(new Caterpillar(), 0);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Duck(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Caterpillar(), 90);
        put(new Plant(), 100);
    }});

        animalAttack.put(new Caterpillar(), new HashMap<>(){{
        put(new Wolf(), 0);
        put(new Boa(), 0);
        put(new Fox(), 0);
        put(new Bear(), 0);
        put(new Eagle(), 0);
        put(new Horse(), 0);
        put(new Deer(), 0);
        put(new Rabbit(), 0);
        put(new Mouse(), 0);
        put(new Goat(), 0);
        put(new Sheep(), 0);
        put(new Boar(), 0);
        put(new Buffalo(), 0);
        put(new Duck(), 0);
        put(new Plant(), 100);
    }});

    }};



   public final static Map<Eatable, Integer> animalMaxCount = new HashMap<>() {{
       put(new Wolf(), 30);
       put(new Boa(), 30);
       put(new Fox(), 30);
       put(new Bear(), 5);
       put(new Eagle(), 20);
       put(new Horse(), 20);
       put(new Deer(), 20);
       put(new Rabbit(), 150);
       put(new Mouse(), 500);
       put(new Goat(), 140);
       put(new Sheep(), 140);
       put(new Boar(), 50);
       put(new Buffalo(), 10);
       put(new Duck(), 200);
       put(new Caterpillar(), 1000);
       put(new Plant(), 200);
   }};

   public final static Map<Eatable, Integer> animalMaxMove = new HashMap<>(){{
       put(new Wolf(), 3);
       put(new Boa(), 1);
       put(new Fox(), 2);
       put(new Bear(), 2);
       put(new Eagle(), 3);
       put(new Horse(), 4);
       put(new Deer(), 4);
       put(new Rabbit(), 2);
       put(new Mouse(), 1);
       put(new Goat(), 3);
       put(new Sheep(), 3);
       put(new Boar(), 2);
       put(new Buffalo(), 3);
       put(new Duck(), 4);
       put(new Caterpillar(), 0);
   }};

    public final static Map<Eatable, Double> eatableWeigth = new HashMap<>(){{
        put(new Wolf(), 50d);
        put(new Boa(), 15d);
        put(new Fox(), 8d);
        put(new Bear(), 500d);
        put(new Eagle(), 6d);
        put(new Horse(), 400d);
        put(new Deer(), 300d);
        put(new Rabbit(), 2d);
        put(new Mouse(), 0.05d);
        put(new Goat(), 60d);
        put(new Sheep(), 70d);
        put(new Boar(), 400d);
        put(new Buffalo(), 700d);
        put(new Duck(), 1d);
        put(new Caterpillar(), 0.01d);
        put(new Plant(), 1d);
    }};

}
