import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solve {
    //fields
    public ArrayList<Game> listOfGame;
    public ArrayList<Game> toVisit;
    public ArrayList<Game> visited;
    public ArrayList<Game> fail;
    //constructor
    public Solve (Game gm){
        this.listOfGame = new ArrayList<Game>();
        this.toVisit = new ArrayList<Game>();
        this.toVisit.add(gm);
        this.visited = new ArrayList<Game>();
        this.fail = new ArrayList<Game>();
    }

    public static boolean finishedGame(Game gm){
        for (int c = 0; c < gm.tubes.size(); c++){
            String ballColor;
            //If the c'th tube ie empty, then it is complete, no need to check further
            if (gm.tubes.get(c).getSize() == 0){
                continue;
            } else {
                ballColor = gm.tubes.get(c).getBall(0).getColor();
            }
            //checks if the first ball color is same as all balls in the c'th tube
            for (int r = 0; r < gm.tubes.get(c).getSize(); r++){
                if (!(ballColor.equals(gm.tubes.get(c).getBall(r).getColor()))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean compareTubes(Game gm1, Game gm2){
        if (!(gm1.tubes.size() == gm2.tubes.size())){
            return false;
        }
        for (int i = 0; i < gm1.tubes.size(); i++){
            int size1 = gm1.tubes.get(i).getSize();
            int size2 = gm2.tubes.get(i).getSize();
            if(!(size1==size2)){
                return false;
            } else {
                for (int j =0; j < size1; j++){
                    if(!(gm1.tubes.get(i).getBall(j).getColor().equals(gm2.tubes.get(i).getBall(j).getColor()))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static Ball [] getArrayOfBalls(Tube tube){
        Ball [] answer = new Ball[tube.getSize()];
        for (int i = 0; i< tube.getSize();i++){
            if (!(i == 0)){
                answer[i-1] = tube.getBall(i);
            }
        }
        return answer;
    }

    public static ArrayList<Tube> getListOfTubes(Game gm, int pos){
        ArrayList<Tube> answer = new ArrayList<>();
        for (int i = 0; i < gm.tubes.size(); i++) {
            if (i == pos) {
                Tube column = new Tube(getArrayOfBalls(gm.tubes.get(pos)));
                answer.add(column);
            } else {
                answer.add(gm.tubes.get(i));
            }
        }
        return answer;
    }
    //Moves first element to each position to create new game
    public static ArrayList<Game> nextGames(Game gm){
        ArrayList<Game> answer = new ArrayList<>();
        for (int c = 0; c < gm.tubes.size(); c++) {
            Game newGame = new Game(gm.tubeSize, gm.maxColours, getListOfTubes(gm, c));
            answer.add(newGame);
        }

        return answer;
    }

    public static ArrayList<Game> myQuicksort(ArrayList<Game> nbrs){
        Collections.sort(nbrs, new StockComparator());
        return nbrs;
    }

    public boolean solve(){
        if(toVisit.isEmpty()){
            System.out.println("UNSOLVABLE");
            return false;
        } else if (finishedGame(toVisit.get(0))){
            System.out.println("GAME FINISHED");
            visited.add(toVisit.get(0));
            return true;
        } else {
            ArrayList<Game> nbrs = nextGames(toVisit.get(0));
            Optimization.myFilter(nbrs, visited);
            ArrayList<Game> newNbrs = myQuicksort(nbrs);
            Game justVisited = toVisit.remove(0);
            newNbrs.addAll(toVisit);
            visited.add(justVisited);
            return solve();
        }
    }

    public void displayAllGames(){

    }
}
