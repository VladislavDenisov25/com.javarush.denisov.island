package entity.herbivore;


import constants.Constants;
import entity.Animal;

public class Deer extends Animal {
    public String emoji = Constants.emojiDeer;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
