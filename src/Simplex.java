public class Simplex{
    private double[][] simplexArr;
    private int pivotSpalte;
    private int pivotZeile;

    public Simplex(double[][] simplexArr) {
        this.simplexArr = simplexArr;
        simplexAlgorithmus();
    }

    public double[][] simplexAlgorithmus(){

        //Pivot-Spalte ermitteln
        double val1 = simplexArr[0][0]; //kleinster Wert der Zeile  Gewinnfunktion
        this.pivotSpalte =0;
        for(int i=0;i<simplexArr.length;i++){
            if(val1>simplexArr[0][i]){
                val1=simplexArr[0][i];
                pivotSpalte = i;
            }
        }

        if (val1 >= 0) {
            return simplexArr; // Rekursion endet
        }

        //Pivot-Zeile ermitteln
        this.pivotZeile =0;
        double val2 =simplexArr[1][simplexArr[1].length-1]/simplexArr[1][pivotSpalte]; // Hilfsvariable zur Ermittlung der Zeile
        double val3 = simplexArr[1][simplexArr[1].length-1]/simplexArr[1][pivotSpalte]; 
        for(int j = 1;j<simplexArr.length;j++){
            val2 =simplexArr[j][simplexArr[j].length-1]/simplexArr[j][pivotSpalte];
            if(val3>val2 && val2>=0) {
                val3=val2; //kleinster positiver Wert um Pivot-zeile zu ermitteln
                pivotZeile = j;
            }
        }
        //Pivot_Element norminalisieren und 0 erzeugen
        double pivotElement = simplexArr[pivotZeile][pivotSpalte];
            for(int k=0;k<simplexArr[0].length;k++){
                simplexArr[pivotZeile][k]=  simplexArr[pivotZeile][k]/pivotElement;
            } 

        //Gauß vefahren
        for(int i=0;i<simplexArr.length;i++){
            if(i!=pivotZeile) {
                double factor = simplexArr[i][pivotSpalte];
                for(int k=0;k<simplexArr[0].length;k++){
                    simplexArr[i][k] = simplexArr[i][k]-simplexArr[pivotZeile][k]* factor;
                }
            }
        }

        return simplexAlgorithmus(); //rekursiver Aufruf
    }

    public void display(){
        //Ausgabe des Simplex-Tableaus
        for(double[] i: simplexArr){
            for(double j: i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }
        System.out.println(pivotZeile);
        System.out.println(pivotSpalte);
    }


    public static void main(String[] args) {

        //Simplex-Tableau aufgestellt
        double[][] simplexArr = {
            {-2,-3,0,0,0,0},
            {4,3,1,0,0,600},
            {2,2,0,1,0,320},
            {3,7,0,0,1,840}
        };

        Simplex simplex = new Simplex(simplexArr);
        simplex.display();

        

        

        //Pivot-Element zur 1 machen 
        /* 
        System.out.println("Pivot-Element: "+simplexArr[pivotZeile][pivotSpalte]);
        System.out.println(val1);
        System.out.println(pivotSpalte);
        System.out.println(pivotElement);
        System.out.println(pivotZeile);
        System.out.println();

        */

    }
}