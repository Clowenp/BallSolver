import java.util.ArrayList;

public class Optimization {

    public static int countSegments (Tube lob, Ball ball){
        int total = 0;
        for (int i = 0; i < lob.getSize(); i++){
            if (!lob.getBall(i).getColor().equals(ball.getColor())) {
                total++;
                ball = lob.getBall(i);
            }
        }
        return total;
    }
    public static int numBlocks(Game gm){
        int total = 0;
        Ball badBall = new Ball("not a colour");
        for (Tube lob : gm.tubes){
            if (lob.getSize() == 0){
                continue;
            }
            total += countSegments(lob, badBall);
        }
        return total;
    }

    public static ArrayList<Game> myFilter(ArrayList<Game> nbrs, ArrayList<Game> avisited){
        ArrayList<Game> newNbrs = new ArrayList<>();
        for (Game game: nbrs){
            boolean shouldAdd = true;
            for (Game gamev: avisited){
                if (Solve.compareTubes(game, gamev)){
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd) {
                newNbrs.add(game);
            }
        }
        return newNbrs;
    }
}
