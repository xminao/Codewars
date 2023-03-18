public class Highest_Scoring_Word {
    /**
     * Given a string of words, you need to find the highest scoring word.
     *
     * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
     *
     * For example, the score of abad is 8 (1 + 2 + 1 + 4).
     *
     * You need to return the highest scoring word as a string.
     *
     * If two words score the same, return the word that appears earliest in the original string.
     *
     * All letters will be lowercase and all inputs will be valid.
     */

    // My implement.
    public static String high(String s) {
        String[] list = s.split(" ");
        int highest_index = 0;
        int highest_score = 0;
        for (int i = 0; i < list.length; i += 1) {
            int score = 0;
            for (int j = 0; j < list[i].length(); j += 1) {
                int c = list[i].charAt(j) - 96;
                score += c;
            }
            if (score > highest_score) {
                highest_index = i;
                highest_score = score;
            }
        }
        return list[highest_index];
    }

    // Other implement.
    public static String high2(String s) {
        String winner = "";
        int highScore = 0;
        for (String word : s.split(" ")) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }
        return winner;
    }

    public static void main(String args[]) {
        String a = "abcd taxi mmi";
        System.out.println(high(a));
    }
}
