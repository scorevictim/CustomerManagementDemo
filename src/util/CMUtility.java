package util;

import java.util.*;

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * For menu selection.
     * This method reads keyboard input.
     * If user type in char in '1'-'5', it will return user input value.
     */
    public static char readMenuSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
                System.out.println("Invalid input, please try again");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * This method reads keyboard input and returns it.
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * This method reads keyboard input and returns it.
     * If received nothing, it will return "defaultValue"
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * This method reads an int which is less than 2 in length, and returns it.
     */
    public static int readInt() {
        int n;
        for (;;) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        }
        return n;
    }

    /**
     * This method reads an int which is less than 2 in length, and returns it.
     * If received nothing, it will return "defaultValue"
     */
    public static int readInt(int defaultValue) {
        int n;
        for (;;) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        }
        return n;
    }

    /**
     * This method reads an String which is less than limit in length, and returns it.
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * This method reads an String which is less than limit in length, and returns it.
     * If received nothing, it will return "defaultValue"
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * This method reads 'Y' or 'N' from keyboard and returns it.
     */
    public static char readConfirmSelection() {
        char c;
        for (;;) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }
            break;
        }
        return line;
    }
};