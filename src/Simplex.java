public class Simplex{

    public static void main(String[] args) {
        double[][] simplexArr = {
            {-2,-3,0,0,0,0},
            {4,3,1,0,0,600},
            {2,2,0,1,0,320},
            {3,7,0,0,1,840}
        };

        for(double[] i: simplexArr){
            for(double j: i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }
    }

}