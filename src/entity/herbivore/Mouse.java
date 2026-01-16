package entity.herbivore;

import constants.Constants;
import entity.Animal;

public class Mouse extends Animal {
    public String emoji = Constants.emojiMouse;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
