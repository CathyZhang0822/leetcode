import java.util.*;
public class contest1284 {
    public static void main(String[] args){
        System.out.println(numDupDigitsAtMostN(100));
    }
    public static int numDupDigitsAtMostN(int N) {
        if(N < 100){
            if(N >= 99){
                return 9;
            }else if(N >= 88){
                return 8;
            }else if(N >= 77){
                return 7;
            }else if(N >= 66){
                return 6;
            }else if(N >= 55){
                return 5;
            }else if(N >= 44){
                return 4;
            }else if(N >= 33){
                return 3;
            }else if(N >= 22){
                return 2;
            }else if(N >= 11){
                return 1;
            }else {
                return 0;
            }
        }
        List<String> newDigitList = Arrays.asList(new String[]{"00","11","22","33","44","55","66","77","88","99"});
        List<String> oldDigitList = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for(int digit = 3; digit <= 9; digit ++){
            if(digit > (""+N).length()){
                break;
            }
            oldDigitList = newDigitList;
            newDigitList = new ArrayList<>();
            for(int i = 0; i < oldDigitList.size(); i++){
                String cur = oldDigitList.get(i);
                for(int j = 0; j <= cur.length(); j++){
                    for(int k = 0; k <= 9; k++){
                        String newS = cur.substring(0,j) + k + cur.substring(j,cur.length());
                        if(newS.startsWith("0")) {
                            newDigitList.add(newS);
                        }else{
                            if(Integer.parseInt(newS) <= N){
                                set.add(newS);
                                System.out.println(newS);
                                newDigitList.add(newS);
                            }
                        }
                    }
                }
            }
        }
        return 9 + set.size();

    }
}
