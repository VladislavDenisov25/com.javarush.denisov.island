package entity.predator;

import constants.Constants;

public class Bear extends Predator {
    public String emoji = Constants.emojiBear;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
