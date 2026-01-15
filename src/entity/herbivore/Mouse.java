package entity.herbivore;

import constants.Constants;

public class Mouse extends Herbivore{
    public   String emoji = Constants.emojiMouse;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
