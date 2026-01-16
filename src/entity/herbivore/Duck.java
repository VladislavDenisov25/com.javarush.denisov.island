package entity.herbivore;


import constants.Constants;
import entity.Animal;

public class Duck extends Animal {
    public String emoji = Constants.emojiDuck;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
