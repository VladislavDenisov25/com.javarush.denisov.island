package entity.predator;

import constants.Constants;

public class Eagle extends Predator {
    public String emoji = Constants.emojiEagle;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
