public class StringWithoutAAABBB {
    public static void main(String[] args){
        System.out.println(strWithout3a3b(4,1));
    }

    public static String strWithout3a3b(int A, int B){
        StringBuilder sb = new StringBuilder();
        int suba = 0;
        int subb = 0;
        while (A > 0 || B > 0){
            if((A >= B && suba < 2) || (A < B && subb >= 2)){
                sb.append('a');
                suba ++;
                subb = 0;
                A --;
            }else{
                sb.append('b');
                subb ++;
                suba = 0;
                B --;
            }
        }
        return sb.toString();
    }
}
