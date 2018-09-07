/* google oa practice
给一个IP address，里面有很多character和slashes， 给一个 integer值 K
重新insert slashes进IP address，是得其从后往前每隔K个字符都有一个'-'
每个'-'前面至少有一个字符
ex: "78-90-LUMLN"  -> "7-890L-UMLN"
* */
public class reInsert {
    // google oa practice
    public static void main(String[] args){
    String test = "k";
    System.out.println(solution(test,4));
    }

    private static String solution(String S, int K){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for(int j = S.length()-1; j>=0; j--){
            if(counter == K){
                sb.append("-");
                counter = 0;
            }
            String cur = Character.toString(S.charAt(j));
            if(!cur.equals("-")){
                sb.append(cur.toUpperCase());
                counter ++;
            }else{
                continue;
            }
        }
        return sb.reverse().toString();
    }
}
