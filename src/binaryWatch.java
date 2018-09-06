import java.util.*;
public class binaryWatch {
    public static void main(String[] args){
        binaryWatch obj = new binaryWatch();
        List<String> res = obj.readBinaryWatch(1);
        System.out.println(res);
    }
    private List<String> readBinaryWatch(int num){
        List<String> res = new ArrayList<>();
        if(num < 0 || num >= 9)
            return res;
        int[] hours = {1,2,4,8};
        int[] minutes = {1,2,4,8,16,32};
        List<Integer> hoursCombinations, minutesCombinations;
        for(int i = 0; i <= num; i++){
            if(i >= 4){
                break;
            }
            if(num-i >= 6){
                continue;
            }
            hoursCombinations = new ArrayList<>();
            minutesCombinations = new ArrayList<>();
            dfs(hours,i,0,0,hoursCombinations);
            dfs(minutes,num-i,0,0,minutesCombinations);
            for(int hour:hoursCombinations){
                if(hour >= 12) continue;
                for(int minute:minutesCombinations){
                    if(minute >= 60) continue;
                    res.add(hour+":"+(minute < 10 ? "0"+minute:minute));
                }
            }
        }
        return res;
    }
    //就是combination sum
    private void dfs(int[] nums, int level, int index, int sum, List<Integer>combinationSums){
        if (level == 0){
            combinationSums.add(sum);
            return;
        }
        for(int i=index; i<nums.length; i++){
            dfs(nums, level-1, i+1,sum+nums[i], combinationSums);
        }
    }
}
