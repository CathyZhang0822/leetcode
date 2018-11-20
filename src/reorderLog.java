import java.util.Arrays;
import java.util.Comparator;

public class reorderLog {
    /*
    这道题关键是如何定义comparator
    * */
    public static void main(String[] args){
        String[] logs = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.deepToString(reorderLogFiles(logs)));
    }

    public static String[] reorderLogFiles(String[] logs){
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(isDigit(o1) != isDigit(o2)){
                    return (isDigit(o1)==true ? 1:-1);
                }
                if(!isDigit(o1) && !isDigit(o2)){
                    return validLog(o1).compareTo(validLog(o2));
                }
                return 0;
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }

    private static boolean isDigit(String str){
        String[] seq = str.split("\\s+");
        if('0' <= seq[1].charAt(0) &&  seq[1].charAt(0) <= '9'){
            return true;
        }else{
            return false;
        }
    }

    private static String validLog(String str){
        String[] seq = str.split("\\s+");
        String[] subseq = Arrays.copyOfRange(seq,1, seq.length);
        return String.join(" ", subseq);
    }
}
