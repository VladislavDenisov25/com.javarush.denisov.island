package entity.predator;

import constants.Constants;
import entity.Animal;

public class Eagle extends Animal {
    public String emoji = Constants.emojiEagle;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
