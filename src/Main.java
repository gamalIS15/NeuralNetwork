/**
 * Created by user on 11/10/2017.
 */
public class Main {
    public  static  void main(String [] args){
        int data [][][] = Perceptron.InputData;
        double weight [] = Perceptron.INITIAL_WEIGHT;
         Main mn = new Main();
         Perceptron pr = new Perceptron();
         int epochNumber = 0;
         boolean errorFlag = true;
         double error = 0;
         double[] adjustedWeight = null;
         while (errorFlag){
             mn.printHeading(epochNumber++);
             errorFlag = false;
             error = 0;
             for (int i =0; i < data.length; i++){
                 double weightedSum = pr.calculateWitghtedSum(data[i][0], weight);
                 int result = pr.applyActFunction(weightedSum);
                 error = data[i][1][0] - result;
                 if (error != 0)errorFlag = true;
                 adjustedWeight = pr.adjustedWeight(data[i][0],weight,error);
                 mn.printVector(data[i],weight,result,error,weightedSum,adjustedWeight);
                 weight = adjustedWeight;
             }
            // error++;
         }
    }
    public void printHeading(int epochNumber){
        System.out.println("\n=========================================Epoch" + epochNumber+"===============================================");
        System.out.println("  w1   | w2  | x1 | x2 | Target Result  | Result  | error  | Weighted Sum  | Adjusted w1  | Adjusted w2");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
    public void printVector(int [][]data, double[] weigth, int result, double error , double weightedSum , double[] adjustedWeight ){
        System.out.println(" "+String.format("%.2f",weigth[0])+" | "+String.format("%.2f",weigth[1])+" | "+data[0][0]+"  | "+data[0][1]+"  |" +
                "       "+data[1][0]+"        |   "+result+"     |   "+error+"   |   "+String.format("%.2f",weightedSum)+"       |   " +
                ""+String.format("%.2f",adjustedWeight[0])+"       |   "+String.format("%.2f",adjustedWeight[1]));
    }
}
