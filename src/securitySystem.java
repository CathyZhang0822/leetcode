import java.util.*;
public class securitySystem {
    /*
    We are working on a security system for a badged-access room.
    Given an ordered list of employees who used their badge to enter or exit the room,
    第一问：write a function that returns two collections:
    1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit.
    2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter.
    * */
    public static void main(String[] args){
        String[][] records = {{"Marthaha", "enter"},
                {"Martha","exit"},{"Paul","enter"},
                {"Martha","enter"},{"Martha","exit"},
                {"Jennifer","enter"},{"Paul","enter"},
                {"Curtis","enter"},{"Paul","exit"},
                {"Martha","enter"},{"Martha","exit"},
                {"Jennifer","exit"}
        };
        String[][] badge_records = {
                {"Paul", "1335"},{"Jennifer", "1910"},
                {"John", "830"},{"Paul","1315"},
                {"John", "835"},{"Paul", "1405"},
                {"Paul", "1630"},{"John","855"},
                {"John", "915"},{"John", "930"},
                {"Jennifer", "1335"},{"Jennifer", "730"},
                {"John", "1630"}
        };
        find_mismatched(records);
        find(badge_records);
    }
    /*第一问：
    set a: 忘记刷exit
    set b: 忘记刷enter
    用一个map来储存状态：在屋子外面（0）, 在屋子里面（1）
    当： enter 时状态为1：put it into set a
         exit 时状态为0：忘记刷enter -> put it into set b
    最后还要遍历一遍map，把状态为1的都放进a里面去
    * */
    public static void find_mismatched(String[][] records){
        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        // Map to store the state 0:outside of the room 1: inside the room
        Map<String, Integer> map = new HashMap<>();

        for(String[] record:records){
            String person = record[0];
            String action = record[1];
            int curState = map.getOrDefault(person, 0);
            if(action == "enter"){
                if(curState == 1) a.add(person);
                map.put(person, 1);
            }else{
                if(curState == 0) b.add(person);
                map.put(person, 0);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) a.add(entry.getKey());
        }
        System.out.println("who didn't use their badge while exiting the room: " + a);
        System.out.println("who didn't use their badge while entering the room: " + b);
    }
    /*第二问：
    We want to find employees who badged into our secured room usually.
    We have an unordered list of names and access times over a single day.
    Access times are given as three or four digit numbers using 24-hour time,
    such as "800" or "2250".

    Write a function that finds anyone who badged into the room 3 or more times
    in a 1-hour period, and returns each time that they badged in during that period.
    If there are multiple 1-hour periods where this was true, just return the first one.
    * */
    /* 思路：first use a map to store every person's records
       Then find the first hour which satisify .. for every person.
    * */
    public static void find(String[][] records){
        // step 1
        Map<String, List<Integer>> map = new HashMap<>();
        for(String[] record : records){
            String person = record[0];
            int time = Integer.parseInt(record[1]);
            map.putIfAbsent(person, new ArrayList<>());
            map.get(person).add(time);
        }
        // step 2：
        for(Map.Entry<String, List<Integer>> entry: map.entrySet()){
            // helper function to find a person's 1-hour period
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            int[] index = helper(times);
            if(index[0]!=-1){
                List<Integer> timesInHour = new ArrayList<>();
                for(int i = index[0]; i <= index[1]; i++) timesInHour.add(times.get(i));
                System.out.println(entry.getKey() + ": " + timesInHour);
            }
        }
    }

    private static int[] helper(List<Integer> list){
        // to store left pointer's index and right pointer's index
        int[] index = new int[2];
        // use two pointers
        int left = 0;
        int right = 0;
        for(; right < list.size(); right++){
            while(list.get(right) - list.get(left) > 100){
                left ++;
            }
            // now right pointer and left pointer are in the 1 hour period
            // when right index - left index >= 2, find a valid hour.
            // at this time, move right to find valid times in that period as much as possible
            // 关键是这里好好想了一会，如果找打三个了，就说明要return了
            if(right - left >= 2){
                while(right < list.size() && list.get(right) - list.get(left) <= 100) right ++;
                return new int[]{left, right-1};
            }
        }
        //don't find a valid hour
        return new int[]{-1,-1};
    }
}
