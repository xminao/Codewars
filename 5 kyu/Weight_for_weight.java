import java.util.*;

public class Weight_for_weight {

    // My implement
    public static String orderWeight(String strng) {
        String[] list = strng.split(" ");
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : list) {
            int weight = 0;
            for (char c : s.toCharArray()) {
                weight += c - '1' + 1;
            }
            if (!map.containsKey(weight)) {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(weight, l);
            } else {
                map.get(weight).add(s);
            }
        }
        int[] index = new int[map.size()];
        int k = 0;
        for (int i : map.keySet()) {
            Collections.sort(map.get(i));
            index[k] = i;
            k += 1;
        }

        Arrays.sort(index);
        List<String> out = new ArrayList<>();
        for (int i : index) {
            for (String s : map.get(i)) {
                out.add(s);
            }
        }

        return String.join(" ", out);
    }

    // Other implement
    public static String orderWeight2(String string) {
        String[] split = string.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int aWeight = a.chars().map(Character::getNumericValue).sum();
                int bWeight = b.chars().map(Character::getNumericValue).sum();
                if (aWeight - bWeight == 0) {
                    return a.compareTo(b);
                }
                return aWeight - bWeight;
            }
        });
        return String.join(" ", split);
    }

    public static void main(String args[]) {
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
