import java.util.*;

public class commonchars {
    public static void main(String[] args){
        //System.out.println((char)('a' + 2));
    }

    public static List<String> commonChars(String[] A){
        int[][] arr = new int[A.length][26];
        List<String> res = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            for(char c : A[i].toCharArray()){
                arr[i][c-'a'] ++;
            }
        }
        for(int j = 0; j < 26; j++){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < A.length; i++){
                min = Math.min(arr[i][j], min);
            }
            for(int k = 0; k < min; k++){
                res.add(""+(char)('a'+j));
            }
        }
        return res;
    }
}
