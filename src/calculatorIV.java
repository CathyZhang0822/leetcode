import java.util.*;
class Cell{
    int num;
    Map<String, Integer> symbols;
    Cell(int num, Map<String, Integer> symbols){
        this.num = num;
        this.symbols = symbols;
    }
}
/*这道题是加了变量名的。比如会给一个map {'a': 1, 'b':2, 'c':3},
  假设输入为"a+b+1+d+d", 那么输出就是 "7+2*d"
  思路，争取能把变量简化的简化 -> "a+b+1+d+d" -> "7+d+d"
* */
public class calculatorIV {
    //step 1: simplify the input string
    //step 2: rather than return the number result, first return the cell instead
    //step 3: convert the cell into string
    public static void main(String[] args) {
        String input = "a+b+c+d+d";
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", -2);
        map.put("c", 3);
        String clean = simplify(input, map);
        System.out.println(clean);
        int[] index = {0};
        Cell res = calculate(clean, index);
        System.out.println(res.num);
        System.out.println(res.symbols);
        System.out.println(convert(res));
    }

    // the input is the simplified string. 1+(-2)+1+d+d
    // the output is a cell: contains the sum number and symbols with their counts
    public static Cell calculate(String input, int[] index){
        int sign = 1; // + : 1, - : -1
        int res = 0;
        Map<String, Integer> symbols = new HashMap<>();
        for(; index[0] < input.length(); index[0]++){
            char c = input.charAt(index[0]);

            if(Character.isDigit(c)){
                int sum = 0;
                while(index[0] < input.length() && Character.isDigit(input.charAt(index[0]))){
                    sum = sum * 10 + input.charAt(index[0])-'0';
                    index[0] ++;
                }
                index[0] --;
                res += sign * sum;
            }else if(Character.isLetter(c)){
                StringBuilder sub = new StringBuilder();
                while(index[0] < input.length() && Character.isLetter(input.charAt(index[0]))){
                    sub.append(input.charAt(index[0]));
                    index[0] ++;
                }
                index[0] --;
                // put this piece of symbol into the map
                String sym = sub.toString();
                symbols.put(sym, symbols.getOrDefault(sym, 0) + sign);
            }else if(c == '+' || c == '-'){
                sign = c == '+' ? 1 : -1;
            }else if(c == '('){
                // start recursion, 就跟遇到了一个数，symbol一样。update result
                index[0] ++;
                Cell next = calculate(input, index);
                // update res number
                res += sign * next.num;
                // update symbols map. pay attention to the sign!
                for(Map.Entry<String, Integer> entry : next.symbols.entrySet()){
                    String key = entry.getKey();
                    int val = entry.getValue();
                    // attention here
                    symbols.put(key, symbols.getOrDefault(key, 0) + val*sign);
                }
            }else if(c == ')'){
                // end of recursion
                return new Cell(res, symbols);
            }
        }
        return new Cell(res, symbols);
    }

    // helper function: simplify the input string
    private static String simplify(String input, Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // find symbols
            if (Character.isLetter(c)) {
                StringBuilder sub = new StringBuilder();
                while (i < input.length() && Character.isLetter(input.charAt(i))) {
                    sub.append(input.charAt(i));
                    i++;
                }
                // don't forget to i--!! 背下来
                i--;
                if (map.containsKey(sub.toString())) {
                    if (map.get(sub.toString()) > 0) {
                        sb.append(map.get(sub.toString()));
                    } else {
                        sb.append("(" + map.get(sub.toString()) + ")");
                    }
                } else {
                    sb.append(sub.toString());
                }
            } else if (c == ' ') {
                continue;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String convert(Cell res){
        StringBuilder sb = new StringBuilder();
        if(res.num != 0) sb.append(res.num + " ");
        for(Map.Entry<String, Integer> entry : res.symbols.entrySet()){
            int times = entry.getValue();
            if(times == 0){
                continue;
            }else if(times > 0){
                sb.append("+ ");
            }else{
                times = 0 - times;
                sb.append("- ");
            }
            if(times == 1){
                sb.append(entry.getKey() +" ");
            }else{
                sb.append(times + " * " + entry.getKey());
            }
        }
        return sb.toString();
    }

}
