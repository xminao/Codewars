import java.util.HashMap;
import java.util.Map;

public class Greed_is_Good {
    /**
     * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
     *
     *  Three 1's => 1000 points
     *  Three 6's =>  600 points
     *  Three 5's =>  500 points
     *  Three 4's =>  400 points
     *  Three 3's =>  300 points
     *  Three 2's =>  200 points
     *  One   1   =>  100 points
     *  One   5   =>   50 point
     * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
     *
     * Example scoring
     *
     *  Throw       Score
     *  ---------   ------------------
     *  5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
     *  1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
     *  2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
     */
    public static int greedy(int[] dice) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : dice) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int score = 0;
        for (int i : map.keySet()) {
            if (map.get(i) >= 3) {
                if (i == 1) {
                    score += 1000;
                    map.put(i, map.get(i) - 3);
                } else {
                    score += i * 100;
                    map.put(i, map.get(i) - 3);
                }
            }

            if (map.get(i) > 0) {
                if (i == 1) {
                    score += map.get(i) * 100;
                    map.put(i, 0);
                } else if (i == 5) {
                    score += map.get(i) * 50;
                    map.put(i, 0);
                }
            }
        }
        return score;
    }
}
