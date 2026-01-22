package util;

import java.util.concurrent.ThreadLocalRandom;

public class Random {

    public static int getRandomCount(int maxCount) {
        return ThreadLocalRandom.current().nextInt(maxCount);
    }

    public static int getRandomCount(int minCount, int maxCount) {
        return ThreadLocalRandom.current().nextInt(minCount, maxCount);
    }
}
