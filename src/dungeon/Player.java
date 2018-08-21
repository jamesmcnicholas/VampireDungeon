package dungeon;

public class Player  {

    private int x;
    private int y;

    private int height;
    private int width;

    public Player(int height, int width) {
        x = 0;
        y = 0;

        this.height = height;
        this.width = width;
    }


    public void move(String moves) {


        for(int i = 0; i < moves.length(); i++){

            if(moves.charAt(i) == 'd'){
                if(y + 1 < height){
                    y++;
                }
            } else if (moves.charAt(i) == 'a') {
                if(y - 1 >= 0){
                    y--;
                }
            } else if (moves.charAt(i) == 'w') {
                if(x - 1 >= 0){
                    x--;
                }
            } else if (moves.charAt(i) == 's') {
                if(x + 1 < width){
                    x++;
                }
            }

        }

    }

    @Override
    public String toString() {
        return "@ " + y + " " + x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
