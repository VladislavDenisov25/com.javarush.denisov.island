package entity.predator;

import constants.Constants;
import entity.Animal;

public class Wolf extends Animal {
    public String emoji = Constants.emojiWolf;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
