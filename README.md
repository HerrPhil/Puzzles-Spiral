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

When the look-ahead sees the next position is the wall, then pull the wall left one position.

Turn right.

The solution goes down, down, and down.

When the look-ahead sees the next position is the wall, then pull the wall up one position.

Turn right.

The solution goes left, left, and left.

When the look-ahead sees the next position is the wall, then pull the wall right one position.

Turn right.

The solution goes up, and up.

When the look-ahead sees the next position is the wall, then pull the wall down one position.

Turn right.

The solution goes right, and right.

When the look-ahead sees the next position is the wall, then pull the wall left one position.

Turn right.

The solution goes down.

When the look-ahead sees the next position is the wall, then pull the wall up one position.

Turn right.

The solution goes left.

When the look-ahead sees the next position is the wall, then pull the wall right one position.

Turn right.

The solution goes nowhere.

The look-ahead sees the next position is the wall, already.

Stop.

It is boxed in when the next position the traversal was to move is "covered" by a wall.
