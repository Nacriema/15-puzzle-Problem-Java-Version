# 15-puzzleProblem
My project in **Java** to solve a problem in **AI** domain. The problem is defined here: [15 puzzle - Wikipedia](https://en.wikipedia.org/wiki/15_puzzle)

## Authors
* Huy Mai TRUONG you can find my profile [**here**](https://nacriema.github.io/).

## Program

### Description

My goal is to improve the time complexity when solving this problem. In this fist attempt, I use BFS, this method always gave the shortest path but it took a lot of time to peform Unifomed Search like this. 

So in next attempt, I use branch and bound techique on this game, you can find the video of this here, I not sure what I implemented is this Algorithm because it seem like A Star by using heuristic to place the order of visited node.

In next version, I will compare the time and length of solution. Wait be to come back ^^

Prepresent the puzzle

|   | 1 | 2 | 3 |
|---|---|---|---|
| 4 | 5 | 6 | 7 |
| 8 | 9 | 10 | 11|
| 12 | 13 | 14 | 15 |

where 0 is the blankspace

This implementation treats the goal state as:

| 1 | 2 | 3 | 4 |
|---|---|---|---|
| 5 | 6 | 7 | 8 |
| 9 | 10 | 11 | 12 |
| 13 | 14 | 15 | 0 |


### Returns:
* Path to the goal. 
* Excecuted time.
* Length of the path.


## Why I do this ? 

* To solve problem gaved by my teacher Mr.Tuan at University - my first lesson is to learn about searching Algorithm.


## References

* Documentation about the A* Algorithm I learn from [**here**.](https://www.redblobgames.com/pathfinding/a-star/introduction.html)

* Video I learn the idea to write the Algorithm [**video**](https://www.youtube.com/watch?reload=9&v=5zr1jjSOklo)


