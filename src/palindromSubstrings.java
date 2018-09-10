public class palindromSubstrings {
    public static void main(String[] args){
        palindromSubstrings obj = new palindromSubstrings();
        String s = "aaa";
        System.out.println(obj.countSubstrings(s));
    }
    int count;
    public int countSubstrings(String s){
        count = 0;
        for(int i = 0; i < s.length(); i++){
            expand(s, i , i);
            expand(s, i, i+1);
        }
        return count;
    }

    private void expand(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count ++;
            i --;
            j ++;
        }
    }
}
