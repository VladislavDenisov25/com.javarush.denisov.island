package entity.herbivore;

import constants.Constants;
import entity.Animal;

public class Goat extends Animal {
    public String emoji = Constants.emojiGoat;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
