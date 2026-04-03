public class AverageTemperatureAlgorithmA {
    public static double calculateAverage(int[] temp) {
        int n = temp.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += temp[i];
        }
        return (double) total / n;
    }

    public static void main(String[] args) {
        int[] temperatures = {20,25,22,24,21};
        System.out.println("Average Temperature: " + calculateAverage(temperatures));
    }
}