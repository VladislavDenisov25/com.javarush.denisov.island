package entity.herbivore;

import constants.Constants;
import entity.Animal;

public class Horse extends Animal {
    public String emoji = Constants.emojiHorse;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
