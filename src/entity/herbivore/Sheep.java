package entity.herbivore;

import constants.Constants;

public class Sheep extends Herbivore{
    public String emoji = Constants.emojiSheep;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
