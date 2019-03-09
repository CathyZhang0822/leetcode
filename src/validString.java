public class validString {
    public static void main(String[] args){
        String s = "abacbc";
        System.out.println(isValid(s));
    }

   // 这个解法虽然AC了，但是小伙伴说"abacbc"这个case过不去，想想他说的对
    public static boolean isValid(String s){
        int a = 0, b = 0, c = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a') { a++; }
            else if(ch == 'b'){
                b ++;
            }
            else if(ch == 'c'){
                c ++;
            }else{
                return false;
            }
            if(b > a || c > b || c > a){
                return false;
            }
        }
        return a == b && b == c;
    }

}
