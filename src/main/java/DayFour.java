import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayFour {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\giuli\\OneDrive\\Documentos\\projetos\\advent-of-code\\advent-of-code\\dayFour.txt");

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            List<String> campIds = new ArrayList<>();


            while((line = br.readLine()) != null){
                campIds.add(line);
            }

            int index = 0;
            int fullyContainsCount = 0;
            int partiallyContains = 0;
            for (String id:campIds) {
                List<String> pair = Arrays.asList(campIds.get(index).split(","));
                List<String> campIdFirst = Arrays.asList(pair.get(0).split("-"));
                int startFirstOfPairCampId = Integer.parseInt(campIdFirst.get(0));
                int endFirstOfPairCampId = Integer.parseInt(campIdFirst.get(1));

                List<String> campIdSecond = Arrays.asList(pair.get(1).split("-"));
                int startSecondOfPairCampId = Integer.parseInt(campIdSecond.get(0));
                int endSecondOfPairCampId = Integer.parseInt(campIdSecond.get(1));

                boolean firstContainsSecond = startSecondOfPairCampId >= startFirstOfPairCampId && endSecondOfPairCampId <= endFirstOfPairCampId;
                boolean secondContainsFirst = startFirstOfPairCampId >= startSecondOfPairCampId && endFirstOfPairCampId <= endSecondOfPairCampId;

                boolean firstPartiallyContainsSecond = startSecondOfPairCampId >= startFirstOfPairCampId && startSecondOfPairCampId <= endFirstOfPairCampId;
                boolean secondPartiallyContainsFirst = startFirstOfPairCampId >= startSecondOfPairCampId && startFirstOfPairCampId <= endSecondOfPairCampId;

                if(firstContainsSecond || secondContainsFirst){
                    fullyContainsCount++;
                }
                if(firstPartiallyContainsSecond|| secondPartiallyContainsFirst){
                    System.out.println(firstPartiallyContainsSecond);
                    System.out.println(campIdFirst + " is partially equal to " + campIdSecond);
                    partiallyContains++;
                }


                System.out.println("fully contains: " + fullyContainsCount);
                System.out.println("Partially contains: " + partiallyContains);
                index++;
            }


        }catch (Exception e){

        }
    }
}
