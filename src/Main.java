import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int PRICE = 10;

    public static void main(String[] args){
        List<Integer> revenues = new ArrayList<>();
        for (int i=1;i<=10;i++){
            int revenue = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(String.format("sim-eigen-20/sim%ddata.d",i)))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length == 3 && values[0].matches("^[0-9]*$")) {
                        int adopted = Integer.parseInt(values[2]);
                        if (adopted == 1) {
                            revenue += PRICE;
                        }
                    }
                }
                revenues.add(revenue);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(revenues);
        System.out.println(avg(revenues));
    }

    private static double avg(List<Integer> l){
        double sum = 0.0;
        for (int num:l){
            sum += num;
        }
        return sum/l.size();
    }
}
