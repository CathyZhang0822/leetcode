public class linkedinoa {
    public static void main(String[] args){

    }
    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        // Write your code here
        int len = s.length();
        leftShifts = leftShifts % len;
        rightShifts = rightShifts % len;
        int shifts = 0;
        String res;
        if(leftShifts > rightShifts){
            shifts = leftShifts - rightShifts;
            res = reverse(s, 0, shifts-1);
            res = reverse(res, shifts, len-1);
            res = reverse(res, 0, len-1);
            return res;
        }else if(rightShifts > leftShifts){
            shifts = rightShifts - leftShifts;
            res = reverse(s,len-shifts, len-1);
            res = reverse(res,0,len-1-shifts);
            res = reverse(res, 0, len-1);
            return res;
        }else{
            return s;
        }

    }
    public static String reverse(String s, int l, int r){
        char[] chars = s.toCharArray();
        while(l <= r){
            // swap
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            // move left & right pointers
            l ++;
            r --;
        }
        return String.valueOf(chars);
    }
}
