public class longPressed {
    public static void main(String[] args){
        String name = "kikcxmvzi";

        String typed = "kiikcxxmmvvzz";
        System.out.println(isLong(name, typed));
    }

    public static boolean isLong(String name, String typed){
        if(name == null || name.equals("")){
            return typed == null || typed.equals("");
        }
        int i = 0;
        int j = 0;
        for(; i < name.length(); i++){
            if(j >= typed.length()) return false;
            if(name.charAt(i) == typed.charAt(j)){
                j ++;
            }else{
                while(i > 0 && j < typed.length() && typed.charAt(j) == name.charAt(i - 1)){
                    j ++;
                }
                if(j >= typed.length() || typed.charAt(j) != name.charAt(i)) {
                    System.out.println(j);
                    return false;
                }
                j ++;
            }
        }
        while(j < typed.length() && typed.charAt(j) == name.charAt(i-1)){
            j ++;
        }
        return j == typed.length();
    }
}
