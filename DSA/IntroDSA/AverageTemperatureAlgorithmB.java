public class AverageTemperatureAlgorithmB {

    public static double calculateAverage(int[] temp){
        int sum = temp[0];
        for(int i=1;i<temp.length;i++){
            sum += temp[i];
        }
        return (double)sum / temp.length;
    }

    public static void main(String[] args){
        int[] temperatures = {20,25,22,24,21};
        System.out.println("Average Temperature: " + calculateAverage(temperatures));
    }
}