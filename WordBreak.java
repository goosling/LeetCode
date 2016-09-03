package LeetCode;

public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if(start == s.length()) {
            return true;
        }

        for(String a : dict) {
            int len = a.length();
            int end = start + len;

            if(end > s.length()) {
                continue;
            }

            if(s.substring(start, start + len).equals(a)) {
                if(wordBreakHelper(s, dict, start + len)) {
                    return true;
                }
            }
        }
        return false;
    }
}


import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            int x = in.nextInt();
            colors.add(x);
        }
        Collections.sort(colors);
        int bigest = n-1;
        int bigsecond = bigest - 1;
        int result = 0;
        while(colors.size() > 2){
            if (getHighPosition(colors.get(bigest)) == getHighPosition(colors.get(bigsecond))){
                int temp = colors.get(bigest) ^ colors.get(bigsecond);
                if (!colors.contains(temp)){
                    colors.add(temp);
        Collections.sort(colors);
        bigest = colors.size() - 1;
        bigsecond = bigest - 1;
            }
    }else{
        result++;
    } colors.remove(colors.size() - 1);
        bigest = bigsecond;
        bigsecond--;
    }
    System.out.println(result + 2);

} public static int getHighPosition(int a){ int count = 0; while(a > 0){
    count++;
    a = a >> 1;
} return count;
}
}