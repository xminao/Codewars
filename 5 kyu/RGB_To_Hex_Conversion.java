public class RGB_To_Hex_Conversion {
    /**
     * being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.
     *
     * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
     *
     * The following are examples of expected output values:
     *
     * RgbToHex.rgb(255, 255, 255) // returns FFFFFF
     * RgbToHex.rgb(255, 255, 300) // returns FFFFFF
     * RgbToHex.rgb(0, 0, 0)       // returns 000000
     * RgbToHex.rgb(148, 0, 211)   // returns 9400D3
     */

    // My implement.
    public static String rgb(int r, int g, int b) {
        return convert(r) + convert(g) + convert(b);
    }

    private static String convert(int n) {
        StringBuilder builder = new StringBuilder();
        if (n > 255) {
            builder.append(Integer.toHexString(255));
        } else if (n < 0) {
            builder.append("00");
        } else {
            String str = Integer.toHexString(n);
            if (str.length() == 2) {
                builder.append(str);
            } else if (str.length() == 1) {
                builder.append("0").append(str);
            }
        }
        return builder.toString().toUpperCase();
    }

    // Other implement
    public static String rgb2(int r, int g, int b) {
        if (r < 0) r = 0;
        if (g < 0) g = 0;
        if (b < 0) b = 0;
        if (r > 255) r = 255;
        if (g > 255) g = 255;
        if (b > 255) b = 255;

        return String.format("%02X%02X%02X", r, g, b);
    }

    public static void main(String args[]) {
        System.out.println(rgb(148,0,211));
    }
}
