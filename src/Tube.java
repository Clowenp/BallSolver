import java.util.ArrayList;

public class Tube {
    //fields
    ArrayList<Ball> listOfBalls;

    public Tube (Ball[] balls){
        listOfBalls = new ArrayList<Ball>();
        for (Ball ball: balls) {
            listOfBalls.add(ball);
        }
    }

    public Ball getBall(int n){
        return listOfBalls.get(n);
    }

    public Ball removeBall(int n){
        return listOfBalls.remove(n);
    }

    public int getSize(){
        return listOfBalls.size();
    }

}
