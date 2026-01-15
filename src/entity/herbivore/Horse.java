package entity.herbivore;

import constants.Constants;

public class Horse extends Herbivore{
    public  String emoji = Constants.emojiHorse;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
