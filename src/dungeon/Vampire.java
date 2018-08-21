package dungeon;

import java.util.Random;

public class Vampire {

    private int x;
    private int y;

    private int width;
    private int height;

    public Vampire(int xBound, int yBound) {

        this.x = new Random().nextInt(xBound);
        this.y = new Random().nextInt(yBound);

        width = xBound;
        height = yBound;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "v " + x + " " + y;
    }

    public void move(){
        int direction = new Random().nextInt(3);

        switch (direction) {
            case 0: {
                if (x + 1 < width) {
                    x += 1;
                }
                break;
            }

            case 1: {
                if (x - 1 >= 0) {
                    x -= 1;
                }
                break;
            }

            case 2: {
                if (y + 1 < height) {
                    y += 1;
                }
                break;
            }

            case 3: {
                if (y - 1 >= 0) {
                    y -= 1;
                }
                break;
            }
        }

    }
}
