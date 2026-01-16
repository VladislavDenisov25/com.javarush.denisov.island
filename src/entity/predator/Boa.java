package entity.predator;

import constants.Constants;
import entity.Animal;

public class Boa extends Animal {
    public String emoji = Constants.emojiBoa;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
