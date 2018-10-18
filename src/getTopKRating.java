import java.util.*;
/*
害怕了，发现了自己的知识盲区：就是如果我把app 放进PQ里面，如果我只是单纯的call一个app的reference来update它的rating的话。
PQ的结构是不会改变的。必须要先remove再add。

* */
class App{
    int rating;
    App(int rating){
        this.rating = rating;
    }
}
public class getTopKRating {

    TreeSet<App> treeSet = new TreeSet<>((a,b) -> {
        return b.rating - a.rating;
    });

    List<Integer> topk = new ArrayList<>();
    public static void main(String[] args){
        int[] ratings = {1,5,2,6,7,8,9,3,10,4};
        App[] apps = new App[ratings.length];

    }

    public void initialize(App[] apps, int k){
        for(App app : apps){
            treeSet.add(app);
        }
        Iterator<App> it = treeSet.iterator();
        int count = 0;
        while(it.hasNext() && count < k){
            count ++;
            topk.add(it.next().rating);
        }
    }
}
