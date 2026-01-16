package entity.herbivore;

import constants.Constants;
import entity.Animal;

public class Rabbit extends Animal {
    public String emoji = Constants.emojiRabbit;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
