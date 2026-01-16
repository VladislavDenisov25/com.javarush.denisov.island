package entity.predator;

import constants.Constants;

public class Wolf extends Predator {
    public String emoji = Constants.emojiWolf;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
