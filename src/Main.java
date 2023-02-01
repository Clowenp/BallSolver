import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Ball red = new Ball("R");
        Ball blue = new Ball("B");
        Ball green = new Ball("G");
        Ball yellow = new Ball("Y");
        Ball purple = new Ball("P");
        Ball emptyBall = new Ball("*");

        // --------------------------------Game 1, unfinished game
        Ball [] lob = {blue, red};
        Ball [] emptyTubeArr = {};
        Tube tube1 = new Tube(lob);
        Tube tube1r = new Tube(lob);
        Tube emptyTube = new Tube(emptyTubeArr);

        ArrayList<Tube> listOfTubes = new ArrayList<Tube>();
        listOfTubes.add(tube1);
        listOfTubes.add(tube1r);
        listOfTubes.add(emptyTube);

        Game game1 = new Game(2,2, listOfTubes);
        Game game1d = new Game(2,2, listOfTubes);

        //-----------------------------------Game 2, complete game
        Ball [] lob2 = {blue, blue};
        Ball [] lob3 = {red, red};
        Tube tubec1 = new Tube(lob2);
        Tube tubec2 = new Tube(lob3);
        Tube tubec3 = new Tube(emptyTubeArr);

        ArrayList<Tube> listOfTubes2 = new ArrayList<Tube>();
        listOfTubes2.add(tubec1);
        listOfTubes2.add(tubec2);
        listOfTubes2.add(tubec3);

        Game game2 = new Game(2,2, listOfTubes2);

        //make sure that when I call num-blocks(game1)
        System.out.println(Optimization.numBlocks(game1));
        game1.displayGame();
        System.out.println();
        System.out.println(Optimization.numBlocks(game2));
        game2.displayGame();
        System.out.println();
        //------------------------ Solve Object
        Solve solve1 = new Solve(game1);


        //test myQuicksort which take in an ArrayList<Game>
        ArrayList<Game> nbrs1 = new ArrayList<>();
        nbrs1.add(game1);
        nbrs1.add(game2);

        Solve.myQuicksort(nbrs1);
        for (Game g : nbrs1) {
            System.out.println("Game");
            g.displayGame();
            System.out.println();
        }
        //done

        //test finished game
        System.out.println(Solve.finishedGame(game2));
        System.out.println(Solve.finishedGame(game1));
        //done

        Ball blue2 = new Ball("B");
        Ball red2 = new Ball("R");
        Ball [] testarr = {blue2, blue2};
        Ball [] testarr2 = {red2, red2};
        Ball [] testarr3 = {};
        Tube test1 = new Tube(testarr);
        Tube test2 = new Tube(testarr2);
        Tube test3 = new Tube(testarr3);
        ArrayList<Tube> testArrayList = new ArrayList<>();
        testArrayList.add(test1);
        testArrayList.add(test2);
        testArrayList.add(test3);

        Game game2s = new Game(2, 2,testArrayList);
        Game game2sidentical = new Game(2, 2, testArrayList);

        System.out.println("r they equal? "+Solve.compareTubes(game2, game2s));
        System.out.println("r they equal? "+Solve.compareTubes(game2, game2sidentical));

        ArrayList<Game> testListGame = new ArrayList<>();
        ArrayList<Game> testListGame2 = new ArrayList<>();

        testListGame.add(game2);
        testListGame.add(game1);
        testListGame.add(game1d);
        testListGame2.add(game2s);
        testListGame2.add(game2sidentical);


        // testing copy



        //create compare tubes function


        //create filter function
        //done


        //create next-games function
        ArrayList<Game> solved = new ArrayList<Game>();
        solved = Solve.nextGames(game1);
        System.out.println("START!");
        for (Game game: solved){
            game.displayGame();
            System.out.println();
        }


        //run solve

    }
}