package entity.herbivore;

import constants.Constants;

public class Goat extends Herbivore {
    public String emoji = Constants.emojiGoat;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
