class Tree {
    public int x;
    public Tree l;
    public Tree r;
}
public class biggestPerfectBT {
    public static void main(String[] args){

    }

    int max = 1;
    public int solution(Tree t){
        max = Math.max(max, maxHeight(t));

        return (int) Math.pow(2, max)-1;
    }

    public int maxHeight(Tree t){
        if(t == null) return 0;
        if(t.l == null && t.r == null) return 1;

        int heightOfLeft = maxHeight(t.l);
        int heightOfRight = maxHeight(t.r);
        int res = Math.min(heightOfLeft, heightOfRight) +1;
        max = Math.max(res, max);
        return res;
    }
}
