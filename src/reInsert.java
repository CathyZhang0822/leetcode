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
