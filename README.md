# GeneticAlgorithms-TSP-

Description:
-------------
The Traveling Salesman problem (TSP) is a famous problem in Computer Science, both because it is a very hard problem to solve (one of a class called NP-complete), and because there are many approximation algorithms to find a decent solution to it. TSP can be quickly summarized by assuming that there are N cities, with a cost of travel from every city to every other city defined. TSP asks us to find the lowest cost path from a given city back to that city that passes through every other city once and only once.
One way of obtaining a solution to a TSP problem is to use a genetic algorithm. We will be implementing a genetic algorithm to find a solution to TSP problems.

Details:
---------
Your project should solve any TSP given to it, with a few assumptions. The information for the TSP will be found in a file in the following format. The first line of the file contains a number N indicating the total number of cities. After that are N lines, each row i containing the name of the i-th city (you may assume that this name contains no spaces). After that are N lines, each containing N numbers which indicate the cost of traveling from city i to city j, where i is the row and j is the number in that row. You may assume that the city graph is completely connected (you can get from any city to any other city).


Your program should do the following:
- Prompt the user to enter a file name.
- Open the file and read in the information about the TSP. If the file doesn’t exist, you should print an appropriate error message and exit the program.
- Run a genetic algorithm to find the best path for the TSP. While running, your program should print the cost of the best tour it has found during each generation.
- When your program is finished, print the best path found, and the resulting path cost.
