package LeetCode;

public class Palindrome {

    public static String longestPalindrome1(String s) {
        int maxLength = 0;
        String longestPalindrome = null;
        int length = s.length();

        //check all possible sub Strings）
        for(int i=0; i< length; i++) {
            for(int j = i+1; j < length; j++) {
                int len = j - i;
                String curr = s.substring(i, j+1);
                if(isPalindrome(curr)) {
                    if(len > maxLength) {
                        longestPalindrome = curr;
                        maxLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public static String longestPalindrome2(String s) {
        if(s == null) {
            return null;
        }

        if(s.length() <= 1) {
            return s;
        }

        int maxLen = 0;

        String longestStr = null;

        int length = s.length();

        int[][] table = new int[length][length];

        for(int i=0; i < length; i++) {
            table[i][i] = 1;
        }
        printTable(table);

        for(int i = 0; i < length - 2; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }

        printTable(table);

        for(int l = 3; l <= length; l++) {
            for(int i = 0; i <= length - 1; i++) {
                int j = i + l  - 1 ;
                if(s.charAt(i) == s.charAt(l)) {
                    table[i][l] == table[i + 1][l - 1];
                    if(table[i][j] == 1 && l > maxLen) {
                        longestStr = s.substring(i, l + 1);
                    }
                }
            }
        }
        return longestStr;
    }

    public static void printTable(int[][] x) {
        for(int[] y : x) {
            for(int z : y) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }

    public static boolean isPalindrome(String s) {
        for(int i=0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                return true;
            }
        }
        return false;
    }
}