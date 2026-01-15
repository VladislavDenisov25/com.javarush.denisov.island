package entity.predator;

import constants.Constants;

public class Boa extends Predator{
    public  String emoji = Constants.emojiBoa;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
