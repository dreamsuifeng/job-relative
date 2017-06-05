import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution1 {
    // 最开始的思路，双指针扫描两个字符串的方法
    public boolean validWordAbbra(String s, String abbra) {
        char[] sch = s.toCharArray();
        char[] abbch = abbra.toCharArray();
        int i = 0, j = 0;
        while (i < sch.length && j < abbch.length) {
            int num = 0;
            while (Character.isDigit(abbch[j])) {
                num = num * 10 + Integer.parseInt(""+abbch[j]);
                j++;
            }
            i += num;
            if (j >= abbch.length || i >= sch.length || sch[i] != abbch[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // 正则表达式的方法
    public boolean validWordAbbraRegula(String s, String abbra) {
        String patt = "";
        int i = 0;
        char[] abbchar = abbra.toCharArray();
        while (i < abbchar.length) {
            int num = 0;
            while (Character.isDigit(abbchar[i])) {
                num = num * 10 + Integer.parseInt(""+abbchar[i]);
                i++;
            }
            if (num != 0) {
                patt = patt + "(.{" + String.valueOf(num) + "})";
            } else {
                patt = patt + String.valueOf(abbchar[i]);
            }
            i++;
        }
        System.out.println(patt);
        Pattern p=Pattern.compile(patt);
        Matcher mat=p.matcher(s);
        return mat.matches();

    }

    public static void main(String[] args) {
        // Scanner jin = new Scanner(System.in);
        // String s = jin.next();
        // String abbra = jin.next();
        String s="word";
        String abbra="ord";
        System.out.println(new Solution1().validWordAbbraRegula(s, abbra));
    }

}