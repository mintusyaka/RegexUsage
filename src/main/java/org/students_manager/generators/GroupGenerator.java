package org.students_manager.generators;

import java.util.Random;

public class GroupGenerator {
    public static String generate() {
        String[] prefixes = {"PZ", "PP", "VP", "SA"};

        Random random = new Random();
        String prefix = prefixes[random.nextInt(prefixes.length)];

        int[] range1 = {11, 12, 13, 14, 15, 16, 17, 18};  // 11-18
        int[] range2 = {21, 22, 23, 24, 25, 26, 27, 28};  // 21-28
        int[] range3 = {31, 32, 33, 34, 35, 36, 37};      // 31-37
        int[] range4 = {41, 42, 43, 44, 45};              // 41-45

        int[] selectedRange = getRandomRange(random, range1, range2, range3, range4);

        int number = selectedRange[random.nextInt(selectedRange.length)];

        return prefix + "-" + number;
    }

    private static int[] getRandomRange(Random random, int[]... ranges) {
        return ranges[random.nextInt(ranges.length)];
    }
}
