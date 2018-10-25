public class HitCounter2 {
    private int[] times;
    private int[] hits;

    public HitCounter2(){
        times = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp){
        int index = timestamp % 300;
        if(times[index] != timestamp){
            // a previous timestamp which has same mod ie: 605 5
            times[index] = timestamp;
            hits[index] = 1;
        } else{
            hits[index] ++;
        }
    }

    public int getHits(int timestamp){
        int total = 0;
        for(int i = 0; i < 300; i++){
            if(times[i] > timestamp - 300){
                total += hits[i];
            }
        }
        return total;
    }

    /*
    * basic ideal is using buckets.
    * 1 bucket for every second because we only need to keep the recent hits info for 300 seconds.
    * hit[] array is wrapped around by mod operation.
    * Each hit bucket is associated with times[] bucket which record current time.
    * If it is not current time, it means it is 300s or 600s... ago and need to reset to 1.*/
}
