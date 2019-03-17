public class contest1281 {
    public static void main(String[] args){
        System.out.println(bitwiseComplement(0));

    }

    public static int bitwiseComplement(int N) {
        double numBits = Math.ceil(Math.log(N+1) / Math.log(2));
        System.out.println((int) numBits);
        int biggerNumber = (int)Math.pow(2, (int)numBits);
        return biggerNumber - N -1;
    }
}
