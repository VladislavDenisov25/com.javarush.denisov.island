package entity.herbivore;

import constants.Constants;

public class Rabbit extends Herbivore{
    public  String emoji = Constants.emojiRabbit;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
