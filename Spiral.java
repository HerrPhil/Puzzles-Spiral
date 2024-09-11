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
            System.out.printf("%nthe spiral is complete%n");
        } else {
            System.out.printf("%nthe spiral is incomplete%n");
        }

    }

    private int [][] s;

    public Spiral(int [][] s) {

        this.s = s;

    }

    public boolean solution() {

        if (s == null) return false;
        if (s.length == 0) return false;

        // Otherwise, traverse the matrix
        int current_x = 0; // default start position
        int current_y = 0; // default start position

        int min_x = 0; // top wall
        int min_y = -1; // left wall
        int max_x = s.length; // bottom wall
        int max_y = s[0].length; // right wall
        int size = max_x * max_y;

        String direction = "right";

        boolean result = false;

        int cellsVisited = 1; // default start position "visited"

        while (cellsVisited < size) {

            while (canMove(current_x, current_y, min_x, min_y, max_x, max_y, direction)) {
                // traverse incrementally to the next position.
                // base it on direction, to know what current coordinate to modify.
                System.out.printf("TODO%n");
                current_y++; // TEMPORARY.
            }

            cellsVisited++; // TEMPORARY.

        }

        return cellsVisited == size;

    }

    private boolean canMove(int current_x, int current_y, int min_x, int min_y, int max_x, int max_y, String direction) {

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

}
