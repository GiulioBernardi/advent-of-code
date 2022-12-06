import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class dayFive {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\giuli\\OneDrive\\Documentos\\projetos\\advent-of-code\\advent-of-code\\dayFive.txt");

        List<List<String>> crates = new ArrayList<>();
        List<String> steps = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            int index = 0;

            List<String> stack1 = new ArrayList<>();
            List<String> stack2 = new ArrayList<>();
            List<String> stack3 = new ArrayList<>();
            List<String> stack4 = new ArrayList<>();
            List<String> stack5 = new ArrayList<>();
            List<String> stack6 = new ArrayList<>();
            List<String> stack7 = new ArrayList<>();
            List<String> stack8 = new ArrayList<>();
            List<String> stack9 = new ArrayList<>();
            while((line = br.readLine()) != null){

                if(index <= 7){

                    stack1.add(line.substring(0,3).trim());
                    stack2.add(line.substring(4,7).trim());
                    stack3.add(line.substring(8,11).trim());
                    stack4.add(line.substring(12,15).trim());
                    stack5.add(line.substring(16,19).trim());
                    stack6.add(line.substring(20,23).trim());
                    stack7.add(line.substring(24,27).trim());
                    stack8.add(line.substring(28,31).trim());
                    stack9.add(line.substring(32,35).trim());
//
                }else if(index >9){
                    steps.add(line);
                }

                index++;
            }
            Collections.reverse(stack1);
            Collections.reverse(stack2);
            Collections.reverse(stack3);
            Collections.reverse(stack4);
            Collections.reverse(stack5);
            Collections.reverse(stack6);
            Collections.reverse(stack7);
            Collections.reverse(stack8);
            Collections.reverse(stack9);
            stack1.removeAll(Arrays.asList("", null));
            stack2.removeAll(Arrays.asList("", null));
            stack3.removeAll(Arrays.asList("", null));
            stack4.removeAll(Arrays.asList("", null));
            stack5.removeAll(Arrays.asList("", null));
            stack6.removeAll(Arrays.asList("", null));
            stack7.removeAll(Arrays.asList("", null));
            stack8.removeAll(Arrays.asList("", null));
            stack9.removeAll(Arrays.asList("", null));

            crates.add(stack1);
            crates.add(stack2);
            crates.add(stack3);
            crates.add(stack4);
            crates.add(stack5);
            crates.add(stack6);
            crates.add(stack7);
            crates.add(stack8);
            crates.add(stack9);

        }catch (Exception e){

        }
        System.out.println(crates);

        List<List<String>> stepsList = new ArrayList<>();
        List<List<Integer>> fixedStepList = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            String cratesToMove = steps.get(i).substring(5);
            stepsList.add(List.of(cratesToMove.split(" ")));
            int amountToMove = Integer.parseInt(stepsList.get(i).get(0));
            int fromWhere = Integer.parseInt(stepsList.get(i).get(2));
            int toWhere = Integer.parseInt(stepsList.get(i).get(4));


            fixedStepList.add(List.of(amountToMove, fromWhere, toWhere));

        }

        int amountMoved = 0;

        for (int i = 0; i < fixedStepList.size(); i++) {
            int amountToMove = fixedStepList.get(i).get(0);
            int fromWhere = fixedStepList.get(i).get(1);
            int toWhere = fixedStepList.get(i).get(2);

            for (int j = 0; j < amountToMove; j++) {
                int stackSize = crates.get(fromWhere-1).size();
                int crateIndex = stackSize - 1;
                String movingCrate = crates.get(fromWhere-1).get(crateIndex);
                System.out.println("actual root list: " + crates.get(fromWhere-1));
                System.out.println("actual delivery list: " + crates.get(toWhere-1));
                crates.get(fromWhere-1).remove(crateIndex);
                crates.get(toWhere-1).add(movingCrate);
                System.out.println("\nmoving crate " + movingCrate + " from " + fromWhere + " to " + toWhere );
                System.out.println("expected root list: " + crates.get(fromWhere-1));
                System.out.println("expected delivery list: " + crates.get(toWhere-1));
                System.out.println("-----------------------------------------------------------\n");

            };


        }

        List<String> lastCrates = new ArrayList<>();
        for (int i = 0; i < crates.size(); i++) {
            int stackSize = crates.get(i).size();
            String lastCrateFromStack = crates.get(i).get(stackSize-1);
            lastCrates.add(lastCrateFromStack);


        }
        System.out.println(crates);
        System.out.println(lastCrates);
        System.out.println(amountMoved);

    }
}
