package entity.predator;

import constants.Constants;

public class Fox extends Predator{
    public String emoji = Constants.emojiFox;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
