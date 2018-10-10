import java.util.*;

public class sparseVector {
    int size;
    // store index : value
    Map<Integer, Integer> map;
    public sparseVector(int size){
        this.size = size;
        this.map = new HashMap<>();
    }

    public void set(int index, int value){
        if(index >= size){
            throw new java.lang.Error("out of index!");
        }
        map.put(index, value);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            if(map.containsKey(i)){
                sb.append(map.get(i));
            }else{
                sb.append("0");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // add operation
    public sparseVector add(sparseVector v){
        if(v.size != size){
            throw new java.lang.Error("Vectors length don't match");
        }
        sparseVector v3 = new sparseVector(v.size);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int index = entry.getKey();
            int value = entry.getValue();
            v3.map.put(index, v3.map.getOrDefault(index, 0)+value);
        }
        for(Map.Entry<Integer,Integer> entry : v.map.entrySet()){
            int index = entry.getKey();
            int value = entry.getValue();
            v3.map.put(index, v3.map.getOrDefault(index, 0)+value);
        }
        System.out.println(v3.toString());
        return v3;
    }

    public static void main(String[] args){
        sparseVector v1 = new sparseVector(5);
        v1.set(0, 4);
        v1.set(1, 5);
        sparseVector v2 = new sparseVector(5);
        v2.set(1, 2);
        v2.set(3,3);
        v1.add(v2);
    }

}
