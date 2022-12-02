import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayTwo {
    public static void main(String[] args) {

        int SHAPE_ROCK_POINTS = 1;
        int SHAPE_PAPER_POINTS = 2;
        int SHAPE_SCISSORS_POINTS = 3;

        int OUTCOME_LOSE_POINTS = 0;
        int OUTCOME_DRAW_POINTS = 3;
        int OUTCOME_WIN_POINTS = 6;

        String MY_ROCK = "X";
        String MY_PAPER = "Y";
        String MY_SCISSORS = "Z";

        String OP_ROCK = "A";
        String OP_PAPER = "B";
        String OP_SCISSORS = "C";

        String NEED_TO_LOSE = "X";
        String NEED_TO_DRAW = "Y";
        String NEED_TO_WIN = "Z";


        File file = new File("C:\\Users\\GiulioB\\Documents\\projetos\\prova\\advent-of-code\\inputday2.txt");

        List<String> inputs = new ArrayList<>();
        int finalScore = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                inputs.add(line);
                System.out.println(line);

                String outComePrediction = line.substring(2);
                String opponentTry = line.substring(0,1);
                int totalRoundPoint = 0;
                int roundShapePoint = 0;
                String myTry = null;

                if(outComePrediction.equals(NEED_TO_DRAW)){
                    if(opponentTry.equals(OP_ROCK)){
                        myTry = MY_ROCK;
                    }else if(opponentTry.equals(OP_PAPER)){
                        myTry = MY_PAPER;
                    }else if(opponentTry.equals(OP_SCISSORS)){
                        myTry = MY_SCISSORS;
                    }
                }else if(outComePrediction.equals(NEED_TO_LOSE)){
                    if(opponentTry.equals(OP_ROCK)){
                        myTry = MY_SCISSORS;
                    }else if(opponentTry.equals(OP_PAPER)){
                        myTry = MY_ROCK;
                    }else if(opponentTry.equals(OP_SCISSORS)){
                        myTry = MY_PAPER;
                    }
                } else if (outComePrediction.equals(NEED_TO_WIN)) {
                    if(opponentTry.equals(OP_ROCK)){
                        myTry = MY_PAPER;
                    }else if(opponentTry.equals(OP_PAPER)){
                        myTry = MY_SCISSORS;
                    }else if(opponentTry.equals(OP_SCISSORS)){
                        myTry = MY_ROCK;
                    }
                }

                if(myTry.equals(MY_ROCK)){
                    roundShapePoint += SHAPE_ROCK_POINTS;
                }else if(myTry.equals(MY_PAPER)){
                    roundShapePoint += SHAPE_PAPER_POINTS;
                } else if (myTry.equals(MY_SCISSORS)) {
                    roundShapePoint += SHAPE_SCISSORS_POINTS;
                }

                int roundOutcomePoint = 0;

                if(opponentTry.equals(OP_ROCK) && myTry.equals(MY_SCISSORS)){
                    roundOutcomePoint += OUTCOME_LOSE_POINTS;
                }else if(opponentTry.equals(OP_PAPER) && myTry.equals(MY_ROCK)){
                    roundOutcomePoint += OUTCOME_LOSE_POINTS;
                }else if(opponentTry.equals(OP_SCISSORS) && myTry.equals(MY_PAPER)){
                    roundOutcomePoint += OUTCOME_LOSE_POINTS;
                }
                else if(opponentTry.equals(OP_ROCK) && myTry.equals(MY_PAPER)){
                    roundOutcomePoint += OUTCOME_WIN_POINTS;
                }else if(opponentTry.equals(OP_PAPER) && myTry.equals(MY_SCISSORS)){
                    roundOutcomePoint += OUTCOME_WIN_POINTS;
                }else if(opponentTry.equals(OP_SCISSORS) && myTry.equals(MY_ROCK)){
                    roundOutcomePoint += OUTCOME_WIN_POINTS;
                }

                else if(opponentTry.equals(OP_ROCK) && myTry.equals(MY_ROCK)){
                    roundOutcomePoint += OUTCOME_DRAW_POINTS;
                }else if(opponentTry.equals(OP_PAPER) && myTry.equals(MY_PAPER)){
                    roundOutcomePoint += OUTCOME_DRAW_POINTS;
                }else if(opponentTry.equals(OP_SCISSORS) && myTry.equals(MY_SCISSORS)){
                    roundOutcomePoint += OUTCOME_DRAW_POINTS;
                }
                totalRoundPoint = roundOutcomePoint + roundShapePoint;
                finalScore += totalRoundPoint;
                System.out.println(finalScore);

            }



        }catch (Exception e){

        }
    }
}
