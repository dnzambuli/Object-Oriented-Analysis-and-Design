// package polycubing;

public class PolyCubing {

    public static double cube(double dnm) {
        System.out.println("cubing single double");
        return dnm * dnm * dnm;
    }

    public static int cube(int inm) {
        System.out.println("cubing single int");
        return inm * inm * inm;
    }

    // two integers
    public static String cube(int inm1, int inm2) {
        System.out.println("cubing two ints");
        int ci1, ci2;
        ci1 = inm1 * inm1 * inm1;
        ci2 = inm2 * inm2 * inm2;
        String s1 = Integer.toString(ci1);
        String s2 = Integer.toString(ci2);
        String s3 = s1 + " " + s2;
        return s3;

    }

    public static String cube(int intValue, double doubleValue) {
        int multiInt = intValue * intValue * intValue;
        double multiDouble = doubleValue * doubleValue * doubleValue;
        String s = Integer.toString(multiInt) + " " + Double.toString(multiDouble);
        return s;
    }

    // Method to cube a double and then multiply by an integer
    public static String cube(double doubleValue, int intValue) {
        System.out.println("cubing a double and an int");
        double multiplied = doubleValue * doubleValue * doubleValue;
        int multiInt = intValue * intValue * intValue;
        String s = Double.toString(multiplied) + " " + Integer.toString(multiInt);
        return s;
    }

    public static void main(String[] args) {
        // Testing the methods
        System.out.println(cube(8.8));

        System.out.println(cube(9));

        System.out.println(cube(9, 8));
        System.out.println(cube(3, 2.5)); // This will call the first method (int, double)
        System.out.println(cube(2.5, 3)); // This will call the second method (double, int)
    }
}