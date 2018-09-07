import java.util.*;
/* Google oa
Here are a bunch of emails. You find some of them may be duplicate. Let's say an email address contains a local name
and a domain name. "ab@email.com" "ab" is the local name and "gmail.com" is the domain name.
local name: igore all dots '.' between characters & remove all characters after "+"
ex: "dup....licate+a@gmail.com" equals to "duplicate@email.com"
* */
public class groupEmail {
    public static void main(String[] args){
        groupEmail obj = new groupEmail();
        String[] emails = {"ab@gmail.com", "a.....b@gmail.com", "a+b@abc.com", "..a...@abc.com"};
        System.out.println(obj.group(emails));
    }
    // return the number of groups which contains more that 2 email addresses
    private int group(String[] emails){
        Map<String, Integer> map = new HashMap<>();
        int counter = 0;
        for(String email : emails){
            // helper(email)
            String pattern = extract(email);
            //map.putIfAbsent(pattern, 0);
            map.put(pattern, map.getOrDefault(pattern,0)+1);
            if(map.get(pattern) == 2){
                counter ++;
            }
        }
        return counter;
    }

    private String extract(String email){
        StringBuilder sb = new StringBuilder();
        int index = email.indexOf('@');
        String name = email.substring(0,index);
        String domain = email.substring(index, email.length());
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) == '.'){
                continue;
            }
            else if(name.charAt(i) == '+'){
                break;
            }else{
                sb.append(name.charAt(i));
            }
        }
        System.out.println(sb.toString()+domain);
        return sb.toString()+domain;
    }
}
