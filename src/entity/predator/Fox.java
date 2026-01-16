package entity.predator;

import constants.Constants;
import entity.Animal;

public class Fox extends Animal {
    public String emoji = Constants.emojiFox;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
