package entity.herbivore;


import constants.Constants;

public class Deer extends Herbivore {
    public String emoji = Constants.emojiDeer;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
