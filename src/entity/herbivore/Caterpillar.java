package entity.herbivore;


import constants.Constants;
import entity.Animal;

public class Caterpillar extends Animal {
    public String emoji = Constants.emojiCaterpillar;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
