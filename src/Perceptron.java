/**
 * Created by user on 11/10/2017.
 */
//import java.lang.Math.*;
public class Perceptron {
    public static final int [][][] InputData= {{{0,0},{0}},
                                                {{0,1},{0}},
                                                {{1,0},{0}},
                                                {{1,1},{1}}};
    public static final double LEARNING_RATE = 0.05;
    public static double [] INITIAL_WEIGHT = {Math.random(), 4};
    public double calculateWitghtedSum(int [] data, double [] weight){
        double weightedSum = 0;
        for(int i= 0; i<data.length; i++)
            weightedSum += data[i]*weight[i];
        return weightedSum;
    }
    public int applyActFunction(double weightedSum){
        int result = 0;
        if (weightedSum>1)
            result = 1;
        return result;
    }

    public double [] adjustedWeight(int [] data, double [] weight, double error){
        double [] adjustedWeight = new double[weight.length];
        for (int i = 0; i < weight.length; i++)
            adjustedWeight[i] = LEARNING_RATE* error* data[i]* weight[i];
        return adjustedWeight;
    }
}
