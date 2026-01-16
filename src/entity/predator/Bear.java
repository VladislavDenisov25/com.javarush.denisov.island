package entity.predator;

import constants.Constants;
import entity.Animal;

public class Bear extends Animal {
    public String emoji = Constants.emojiBear;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
