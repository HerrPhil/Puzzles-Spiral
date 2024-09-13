import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.math.BigInteger;

public class Spiral {

    public static void main(String [] args) {
        System.out.printf("Hello Spiral Traversal Solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java Spiral%n");
            return;
        }

        // sample test
        int [][] s = new int [][] {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        Spiral spiral = new Spiral(s);

        boolean result = spiral.solution();

        if (result) {
            System.out.printf("the spiral is complete%n");
        } else {
            System.out.printf("the spiral is incomplete%n");
        }

    }

    private int [][] s;
    int current_x;
    int current_y;

    int min_x;
    int min_y;
    int max_x;
    int max_y;
    int size;

    String direction;

    public Spiral(int [][] s) {

        this.s = s;

        current_x = 0; // default start position
        current_y = 0; // default start position

        min_x = 0; // top wall
        min_y = -1; // left wall
        max_x = this.s.length; // bottom wall
        max_y = this.s[0].length; // right wall
        size = max_x * max_y;

        direction = "right";

    }

    public boolean solution() {

        if (s == null) return false;
        if (s.length == 0) return false;

        // Otherwise, traverse the matrix

        boolean result = false;

        int cellsVisited = 1; // default start position "visited"

        System.out.printf("start at position (%d, %d) and %d cells visited%n", current_x, current_y, cellsVisited);

        while (cellsVisited < size) {

            while (canMove()) {

                doMove();

                cellsVisited++;

                System.out.printf("at position (%d, %d) and %d cells visited%n", current_x, current_y, cellsVisited);

            }

            // hit a wall, move in wall that was hit
            moveWall();

            // direction change required
            // assumes clockwise direction for the spiral
            // right -> down -> left -> up -> ...
            changeDirection();

        }

        return cellsVisited == size;

    }

    private boolean canMove() {

        // based on the direction, check whether the current position will hit a wall if it moves
        switch (direction) {
            case "right":
                // check current y against the max y (right) wall
                return current_y + 1 < max_y;
            case "down":
                // check current x against max x (bottom) wall
                return current_x + 1 < max_x;
            case "left":
                // check current y against min y (left) wall
                return current_y - 1 > min_y;
            case "up":
                // check current x against min x (top) wall
                return current_x - 1 > min_x;
            default:
                return false;
        }

    }

    private void doMove() {

        switch (direction) {
            case "right":
                current_y++;
                break;
            case "down":
                current_x++;
                break;
            case "left":
                current_y--;
                break;
            case "up":
                current_x--;
                break;
            default:
                System.out.printf("do nothing");
        }

    }

    private void moveWall() {

        switch (direction) {
            case "right":
                // move the "right" wall (max_y) in
                max_y--;
                break;
            case "down":
                // move the "bottom" wall (max_x) in
                max_x--;
                break;
            case "left":
                // move the "left" wall (min_y) in
                min_y++;
                break;
            case "up":
                // move the "top wall (min_x) in
                min_x++;
                break;
            default:
                System.out.printf("do nothing");
        }

    }


    private void changeDirection() {

        switch (direction) {
            case "right":
                // transition to  the down direction
                direction = "down";
                break;
            case "down":
                // transition to the left direction
                direction = "left";
                break;
            case "left":
                // transition to the up direction
                direction = "up";
                break;
            case "up":
                // transition to the right
                direction = "right";
                break;
            default:
                System.out.printf("do nothing");
        }

    }

}
