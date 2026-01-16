package entity.herbivore;

import constants.Constants;
import entity.Animal;

public class Sheep extends Animal {
    public String emoji = Constants.emojiSheep;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
