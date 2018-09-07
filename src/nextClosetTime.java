import java.util.*;
public class nextClosetTime {
    public static void main(String[] args){
        String time = "00:01";
        System.out.println(nextv1(time));
        System.out.println(nextv2(time));
    }
    /* time: 15:42
    * */
    private static String nextv1(String time){
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        Set<Integer> set = new HashSet<>();
        set.add(time.charAt(0)-'0');
        set.add(time.charAt(1)-'0');
        set.add(time.charAt(3)-'0');
        set.add(time.charAt(4)-'0');
        int timeVal = hour*60 + minute;
        // make sure i <= 24*60 in case of "22:22"这种情况
        for(int i=1; i<=24*60; i++){
            timeVal ++;
            // helper function: check whether four digits exist in the set
            int hour01 = timeVal%(24*60)/60/10;
            int hour02 = timeVal%(24*60)/60%10;
            int minutes01 = timeVal%(24*60)%60/10;
            int minutes02 = timeVal%(24*60)%60%10;
            if(set.contains(hour01) && set.contains(hour02)&&set.contains(minutes01)&&set.contains(minutes02)){
                return hour01+""+hour02+":"+minutes01+""+minutes02;
            }

        }
        return "No valid solutions";
    }

    /* Approach 2:
       dfs find all combinations of 4 allowed digits
    * */

    private static String nextv2(String time){
        // 偷懒只写了DFS
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        int[] nums = {time.charAt(0)-'0',time.charAt(1)-'0',time.charAt(3)-'0',time.charAt(4)-'0'};
        List<String> res = new ArrayList<>();
        dfs(nums, 0, "", res);
        return(String.valueOf(res.size()));
    }

    private static void dfs(int[] nums, int index, String path, List<String> res){
        if(path.length() == 4){
            res.add(path);
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            dfs(nums, i, path + nums[i], res);
        }
    }
}
