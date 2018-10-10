import java.util.*;

public class test {
    public static void main(String[] args){
        String s = "sports.yahoo.com";
        String[] as = s.split("\\.");
        System.out.println(as[1].length());
        String s2 = "a        b   c d";
        System.out.println(Arrays.toString(s2.split("\\s+")));
    }

}
