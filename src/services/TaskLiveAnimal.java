package services;

import entity.Animal;
import entity.Organism;
import entity.island.Island;
import entity.island.Location;



public class TaskLiveAnimal implements Runnable {

    Location[][] locations = Island.getInstance().getLocation();
    @Override
    public void run() {
            for (int x = 0; x < locations.length; x++) {
                for (int y = 0; y < locations[x].length; y++) {
                    // new runnable новый поток - жизнь одной клетки или складывать их в очередь и передать очередь

                    int finalX = x;
                    int finalY = y;
                    new Runnable(){
                        @Override
                        public void run() {
                            for (Organism organism : locations[finalX][finalY].animalLiveCount.keySet()) {
                                if (organism instanceof Animal){
                                    ((Animal) organism).move();
                                }
                            }
                        }
                    };

                }
            }

    }
}
