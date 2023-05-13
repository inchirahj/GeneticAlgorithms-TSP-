import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;

class Main
{

  public static int numCities;
  public static String [] cities;
  public static int [][] travelCost;
  int generationCount = 0;

  
  public static void main(String[] args) throws Exception
  {
    // Ask the user to enter a file name.
    
    Scanner in = new Scanner(System.in);
		System.out.print("Enter file : ");
		String filename = in.nextLine();
		in.close();

    // Checking if the file exists.
    
    File file = new File(filename);
    Scanner rd = null;
    try 
      {
        rd = new Scanner(file);
        int numCities = rd.nextInt();
        //System.out.println(numCities);

        cities = new String [numCities];
        travelCost = new int [numCities][numCities];
        
        rd.nextLine();
        
        for (int i = 0; i < numCities; i++)
        {
          cities[i] = rd.nextLine();
          //System.out.println(cities[i]);
        }


        for(int i = 0; i < numCities;i++)
        {
          for(int j = 0; j < numCities; j++)
          {
            travelCost[i][j] = rd.nextInt();
            //System.out.print(travelCost[i][j] + " "); 
          }
          //System.out.println();
        }
        rd.close();
      }
  
      catch (FileNotFoundException e)
      {
        System.out.println("File not found.\n");
			  return;
      }

    GeneticAlgorithm ga = new GeneticAlgorithm();
    ArrayList <Individual> population = new ArrayList<Individual>();
    population = ga.getPopulation(10);
    int generation = 1;
    //System.out.println("Generation:" + generation);
    //System.out.println("Fittest:" + ga.getFitness(fittest));

    Individual solution = new Individual(); 
    solution = ga.getFittest(population);
    
    
    while(solution.getFitness(solution) != 1)
    {
    System.out.println("Generation:" + generation);
    System.out.println("Fittest:" + solution.getFitness(solution));
      
      //fittest = ga.selection(population);
      solution = ga.crossover(ga.getFittest(population), ga.getSecondFittest(population));
      solution = ga.mutation(solution);
      generation++;  
    }

    System.out.println("Best path found");
    ga.decode(solution);
    System.out.println("Path cost" + solution.getFitness(solution));
    

    
    
    

   
  }
}