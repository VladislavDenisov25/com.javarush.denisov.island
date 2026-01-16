package entity.herbivore;


import constants.Constants;
import entity.Animal;

public class Boar extends Herbivore {

    public String emoji = Constants.emojiBoar;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
