package entity.herbivore;


import constants.Constants;

public class Caterpillar extends Herbivore {
   public String emoji = Constants.emojiCaterpillar;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
