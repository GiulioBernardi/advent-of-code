import jdk.swing.interop.SwingInterOpUtils;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\GiulioB\\Documents\\projetos\\prova\\advent-of-code\\inputday3.txt");

        try{
            int prioritized = 0;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            List<List<Character>> allStacks = new ArrayList<>();


            while((line = br.readLine()) != null){

                List<Character> chars = line
                        .chars()
                        .mapToObj(e -> (char)e)
                        .collect(Collectors.toList());

                allStacks.add(chars);


                int half = chars.size() / 2;
                List<Character> firstHalf = new ArrayList<>();
                List<Character> secondtHalf = new ArrayList<>();
                firstHalf = chars.subList(0, half);
                secondtHalf = chars.subList(half, chars.size());

                boolean alreadyFound = false;
                for(int j=0; j<firstHalf.size(); j++){
                    for (int k=0; k<firstHalf.size(); k++){
                        Character currentCharFirstHalf = firstHalf.get(j);
                        Character currentCharSecondHalf = secondtHalf.get(k);
                        boolean isCharEqual = currentCharFirstHalf == currentCharSecondHalf;
                        if(isCharEqual && !alreadyFound){
                            alreadyFound = true;
                            System.out.println(currentCharFirstHalf + " is equal to " + currentCharSecondHalf);
                            prioritized += calculatePrioritizedValue(currentCharFirstHalf);
                            break;
                        }
                    }
                }
            }
            System.out.println(prioritized);
            List<List<Character>> groupOfThree = new ArrayList<>();
            for (int i = 0; i < allStacks.size(); i++) {
                for (int j = 0; j < 3; j++) {
                    groupOfThree.add(allStacks.get(i));
                    System.out.println("");
                }


            }


        }catch(Exception e){

        }

    }

    public static int calculatePrioritizedValue(Character repeatedLetter){
        int number = 0;
        if(Character.isLowerCase(repeatedLetter)){
            if(repeatedLetter == 'a'){
                number = 1;
            }if(repeatedLetter == 'b'){
                number = 2;
            }if(repeatedLetter == 'c'){
                number = 3;
            }if(repeatedLetter == 'd'){
                number = 4;
            }if(repeatedLetter == 'e'){
                number = 5;
            }if(repeatedLetter == 'f'){
                number = 6;
            }if(repeatedLetter == 'g'){
                number = 7;
            }if(repeatedLetter == 'h'){
                number = 8;
            }if(repeatedLetter == 'i'){
                number = 9;
            }if(repeatedLetter == 'j'){
                number = 10;
            }if(repeatedLetter == 'k'){
                number = 11;
            }if(repeatedLetter == 'l'){
                number = 12;
            }if(repeatedLetter == 'm'){
                number = 13;
            }if(repeatedLetter == 'n'){
                number = 14;
            }if(repeatedLetter == 'o'){
                number = 15;
            }if(repeatedLetter == 'p'){
                number = 16;
            }if(repeatedLetter == 'q'){
                number = 17;
            }if(repeatedLetter == 'r'){
                number = 18;
            }if(repeatedLetter == 's'){
                number = 19;
            }if(repeatedLetter == 't'){
                number = 20;
            }if(repeatedLetter == 'u'){
                number = 21;
            }if(repeatedLetter == 'v'){
                number = 22;
            }if(repeatedLetter == 'w'){
                number = 23;
            }if(repeatedLetter == 'x'){
                number = 24;
            }if(repeatedLetter == 'y'){
                number = 25;
            }if(repeatedLetter == 'z'){
                number = 26;
            }
        } else if (Character.isUpperCase(repeatedLetter)) {
            if(repeatedLetter == 'A'){
                number = 27;
            }if(repeatedLetter == 'B'){
                number = 28;
            }if(repeatedLetter == 'C'){
                number = 29;
            }if(repeatedLetter == 'D'){
                number = 30;
            }if(repeatedLetter == 'E'){
                number = 31;
            }if(repeatedLetter == 'F'){
                number = 32;
            }if(repeatedLetter == 'G'){
                number = 33;
            }if(repeatedLetter == 'H'){
                number = 34;
            }if(repeatedLetter == 'I'){
                number = 35;
            }if(repeatedLetter == 'J'){
                number = 36;
            }if(repeatedLetter == 'K'){
                number = 37;
            }if(repeatedLetter == 'L'){
                number = 38;
            }if(repeatedLetter == 'M'){
                number = 39;
            }if(repeatedLetter == 'N'){
                number = 40;
            }if(repeatedLetter == 'O'){
                number = 41;
            }if(repeatedLetter == 'P'){
                number = 42;
            }if(repeatedLetter == 'Q'){
                number = 43;
            }if(repeatedLetter == 'R'){
                number = 44;
            }if(repeatedLetter == 'S'){
                number = 45;
            }if(repeatedLetter == 'T'){
                number = 46;
            }if(repeatedLetter == 'U'){
                number = 47;
            }if(repeatedLetter == 'V'){
                number = 48;
            }if(repeatedLetter == 'W'){
                number = 49;
            }if(repeatedLetter == 'X'){
                number = 50;
            }if(repeatedLetter == 'Y'){
                number = 51;
            }if(repeatedLetter == 'Z'){
                number = 52;
            }
        }
        return number;
    }

}
