import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\GiulioB\\Documents\\projetos\\prova\\advent-of-code\\input.txt");

        List<String> calories = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text;
            while((text = br.readLine()) != null){
                calories.add(text);

            }
            List<Integer> sumCalories = new ArrayList<>();
            int sum = 0;
            for(int i=0; i<calories.size();i++){
                if(calories.get(i).equals("")){

                   sumCalories.add(sum);
                   sum = 0;

                }else{
                    int currentCalorie = Integer.parseInt(calories.get(i));
                    sum+= currentCalorie;
                }
            }
            System.out.println(sumCalories);
            System.out.println(Collections.max(sumCalories));

            Collections.sort(sumCalories, Collections.reverseOrder());
            System.out.println(sumCalories);
            Integer top3=0;
            for(int k=0; k<3; k++){
                top3 += sumCalories.get(k);
            }
            System.out.println(top3);

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}