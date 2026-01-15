package entity.herbivore;


import constants.Constants;

public class Duck extends Herbivore {
   public String emoji = Constants.emojiDuck;

    @Override
    public String getEmoji() {
        return emoji;
    }
}
