package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;

    private ArrayList<Vampire> vampireList;

    private Player player;


    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;

        vampireList = new ArrayList<Vampire>();

        for(int k = 0; k < vampires; k++){
            vampireList.add(new Vampire(height,length));
        }



        player = new Player(height,length);
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        System.out.println("//////////////////////////");
        System.out.println("WELCOME TO VAMPIRE DUNGEON");
        System.out.println();
        System.out.println("Kill all the vampires before");
        System.out.println("the lamp fades, its fuel is");
        System.out.println("displayed at the start of");
        System.out.println("each round, along with your");
        System.out.println("player's location [@]. Use");
        System.out.println("WASD to move around - you can");
        System.out.println(" move as much as you want per turn");
        System.out.println("e.g. wwddd would move up 2 and right 3");
        System.out.println("//////////////////////////");




        for(int i = moves; i >= 1; i--){

            System.out.println("Light remaining: "+ i + "\n");

            printCoordinates();

            checkForCollisions();

            if(vampireList.isEmpty()){
                System.out.println("YOU WIN");
                break;
            }

            printMap();

            if(vampiresMove){
                for(Vampire v : vampireList){
                    v.move();
                }
            }

            System.out.println("Enter your move(s): ");
            String input = sc.nextLine();
            player.move(input);

            if(i == 1){
                System.out.println("YOU LOSE");
            }

        }




    }

    public void printMap(){
        for (int x = 0; x < length; x++){

            for (int y = 0; y < height; y++){
                System.out.print(checkSquare(x,y));
            }

            System.out.print("\n");
        }
    }


    public char checkSquare(int x, int y) {
        if (player.getX() == x && player.getY() == y) {
            return '@';
        } else {
            for (Vampire v : vampireList) {
                if (v.getX() == x && v.getY() == y) {
                    return 'v';
                }
            }

            return '.';
        }

    }

    public void checkForCollisions(){
        ArrayList<Vampire> vampiresToRemove = new ArrayList<Vampire>();

        for(Vampire v : vampireList){
            if(v.getX() == player.getX() && v.getY() == player.getY()){
                vampiresToRemove.add(v);
            }
        }

        for(Vampire v : vampiresToRemove){
            vampireList.remove(v);
        }
    }

    public void printCoordinates(){
        System.out.println(player);

        for(Vampire v: vampireList){
            System.out.println(v);
        }
        System.out.println();
    }
}

