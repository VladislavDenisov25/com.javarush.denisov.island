package entity;

import constants.Constants;

import java.util.concurrent.ThreadLocalRandom;

public class Plant implements Eatable {

    String emojiPlant = Constants.emojiPlant;

    @Override
    public Eatable createEatable(Eatable eatable) {
        return new Plant();
    }

    @Override
    public String getEmoji() {
        return emojiPlant;
    }

    public void setEatableLocation(Eatable eatable) {
        int randomLocation = ThreadLocalRandom.current().nextInt(location.length);
        location[randomLocation].animalLiveCount.put(eatable, 1);
    }
}
