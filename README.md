# Puzzles-Spiral

Implement a spiral traversal of a 2D grid. Start in the top-left corner, and start traversing to the right.

## Notes from leetcode videoe

This is a from a FAANG interview question.

We are given a matrix (grid), say, 
```

   5   1   9  11

   2   4   8  10

  13   3   6   7

  15  14  12  16

```
The idea is to set four different walls out of bounds of the matrix - top, right, bottom, left.

Here is the trick. Your top wall should be on the first row.

Start on the top-left element, and begin the traversal going to the right.

The solution goes right, right, and right.

Before we hit our right wall, on the right, we are going to turn right and move one position down.

Now we move the right wall inward, one position.

The solution goes down, and down.

Before we hit our bottom wall, on the bottom, we are goint to turn right and move one position left.

Now we move the bottom wall inward, one position.

The soluition goes left, and left.

Before we hit our left wall, on the left, we are going to turn right and move one position up.

Now we move the left wall inward, one position.

The solution goes up.

Beore we hit our top wall, on the top, we are going to turn right and move one position right.

Now we move the top wall inward, one position.

And so on.

Stop condition is when the traversal position is boxed in.

It is boxed in when the next position the traversal was to move is "covered" by a wall.
