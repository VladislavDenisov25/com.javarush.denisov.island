package entity;


import constants.Constants;

import util.Random;


public class Plant  implements Eatable {

    String emojiPlant = Constants.emojiPlant;

    @Override
    public String getEmoji() {
        return emojiPlant;
    }

}
