import java.util.Arrays;

public class Are_they_the_same {
    /**
     * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays
     * have the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times
     * it appears). "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
     */

    // My implement.
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }

        int[] a_squared = new int[a.length];
        for (int i = 0; i < a.length; i += 1) {
            a_squared[i] = a[i] * a[i];
        }
        Arrays.sort(a_squared);
        int[] b_sorted = b;
        Arrays.sort(b_sorted);
        if (Arrays.equals(a_squared, b_sorted)) {
            return true;
        }
        return false;
    }

    // Other implement
    public static boolean comp2(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }

        int[] a_copy = Arrays.stream(a).map(n -> n * n).toArray();
        Arrays.sort(a_copy);
        Arrays.sort(b);
        return Arrays.equals(a_copy, b);
    }
}
