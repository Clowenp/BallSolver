import java.util.ArrayList;
import java.util.Comparator;

public class Game {

    //fields
    public int tubeSize;
    public int maxColours;
    public ArrayList<Tube> tubes;

    //constructor
    public Game (int tubeSize, int maxColours, ArrayList<Tube> tubes) {
        this.tubeSize = tubeSize;
        this.maxColours = maxColours;
        setTubes(tubes);
    }

    public void setTubes(ArrayList<Tube> tubes){
        this.tubes = tubes;
    }

    public void displayGame(){
       for (int down = 0; down < tubeSize+1; down++) {

           if (down == tubeSize) {
               for (int hor = 0; hor < tubes.size() + 2; hor++) {
                   System.out.print("-");
               }
           } else {
               System.out.print("|");
               try {
                   for (int hor = 0; hor < tubes.size(); hor++) {
                       System.out.print(tubes.get(hor).getBall(down).getColor());
                   }
               } catch (Exception e){
                   System.out.print("*");
               }
               System.out.println("|");
           }


       }

    }

    public void copy(Game game){
        this.setTubes(game.tubes);
    }


}

class StockComparator implements Comparator<Game> {

    // override the compare() method
    public int compare(Game gm1, Game gm2)
    {
        if (Optimization.numBlocks(gm1) == Optimization.numBlocks(gm2)){
            return 0;
        } else if (Optimization.numBlocks(gm1) > Optimization.numBlocks(gm2)) {
            return 1;
        } else {
            return -1;
        }
    }
}
