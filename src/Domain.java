import java.util.*;
public class Domain {
    public static void main(String[] args){
        String[][] domains = {
                {"google.com", "60"},
                {"yahoo.com", "50"},
                {"sports.yahoo.com", "80"}};
        System.out.println(sub_domain_total(domains));
        String[] user1 = {"/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html" };
        String[] user2 = {"/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html"};
        System.out.println(LCH(user1,user2));
    }
    /*
    第一题：求广告的每个sub domain被click的总次数
    input: {
                {"google.com", "60"},
                {"yahoo.com", "50"},
                {"sports.yahoo.com", "80"}};
    output : "com",90 "google.com",60 "yahoo.com",130 "sports.yahoo.com","80
    * */
    public static List<List<String>> sub_domain_total(String[][] domains){
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String[] domain:domains){
            String name = domain[0];
            int click = Integer.parseInt(domain[1]);
            // helper function: find all sub domains of current domain name
            for(String sub : subs(name)){
                map.putIfAbsent(sub,0);
                map.put(sub, map.get(sub)+click);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            res.add(Arrays.asList(entry.getKey(), String.valueOf(entry.getValue())));
        }
        return res;
    }

    private static List<String> subs(String domain){
        List<String> res = new ArrayList<>();
        String[] parts = domain.split("\\.");
        String s = "";
        for(int i = parts.length-1; i >= 0; i--){
            s = "." + parts[i] + s;
            res.add(s.substring(1));
        }
        return res;
    }
    /*
    第二题：给每个user访问历史记录，找出两个user之间longest continuous common history
    就是longest common substring问题：
    如果 s.at(i) == s.at(j)
         dp[i][j] = dp[i-1][j-1] + 1;
         else: dp[i][j] = 0
    * */

    public static List<String> LCH(String[] user1, String[] user2){
        // maintain[0] = max length, maintain[1] index of end
        List<String> res = new ArrayList<>();
        int[] maintain = new int[2];
        int[][] dp = new int[user1.length+1][user2.length+1];
        for(int i = 1; i <= user1.length; i++){
            for(int j = 1; j <= user2.length; j++){
                if(user1[i-1] == user2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    // find a longer one
                    if(dp[i][j] > maintain[0]){
                        maintain[0] = dp[i][j];
                        maintain[1] = i;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = maintain[1]-maintain[0]; i < maintain[1]; i++){
            res.add(user1[i]);
        }
        return res;
    }
}
