import java.util.*;
import java.util.Random;

class GeneticAlgorithm
{
  public int [][] travelCost;
  public int numCities;
  public String [] cities;

  public GeneticAlgorithm()
  {
    Main m = new Main();
    this.numCities = m.numCities;
    this.travelCost = m.travelCost;
    this.cities = m.cities;
  }

  ArrayList <Individual> population = new ArrayList<Individual>();
  
  public ArrayList getPopulation(int populationSize)
  {
    for (int i = 0; i < populationSize; i++)
      {
        Individual ind = new Individual(numCities);
        population.add(ind);
      }
    return population;
  }

  public Individual getFittest(ArrayList<Individual> population)
  {
    Individual fittest = new Individual();
    Individual ind = new Individual();
    fittest = population.get(0);
    for (int i = 1; i < population.size(); i++)
      {
        if (fittest.getFitness(fittest) < ind.getFitness(population.get(i)))
        {
          fittest = population.get(i);
        }
      } 
    return fittest;
  }

  
  public Individual getSecondFittest(ArrayList<Individual> population)
  {
    Individual secondFittest = new Individual();
    Individual ind = new Individual();
    secondFittest = population.get(0);
    for (int i = 1; i < population.size(); i++)
      {
        if (secondFittest.getFitness(secondFittest) < ind.getFitness(population.get(i)) && secondFittest.getFitness(secondFittest) > ind.getFitness(getFittest(population)) )
        {
          secondFittest = population.get(i);
        }
      } 
    return secondFittest;
  }

  public void selection(ArrayList<Individual> population)
  {
    Individual parent1 = getFittest(population);
    Individual parent2 = getSecondFittest(population);
  }

  public Individual crossover(Individual parent1, Individual parent2) 
  {
    Individual child = new Individual();
    Random rn = new Random();
    int crossOverPoint = rn.nextInt(numCities);
 
    for (int i = 0; i < crossOverPoint; i++) 
    {
      child.addCity(child, (parent1.getCity(parent1,i)));
    }

    for (int i = crossOverPoint; i < numCities; i++) 
    {
      child.addCity(child, (parent2.getCity(parent2,i)));
    }
    return child;
  }

  public Individual mutation (Individual ind)
  {
    Random rn = new Random();
    int mutationPoint1 = rn.nextInt(numCities);
    int mutationPoint2 = rn.nextInt(numCities);
    for (int i = 0; i < numCities; i++)
      {
        if (mutationPoint1 == i)
        {
          ind.setCity(ind, mutationPoint1, ind.getCity(ind, mutationPoint2));
        }
        else if (mutationPoint2 == i)
        {
          ind.setCity(ind, mutationPoint2, ind.getCity(ind, mutationPoint1));
        }
      }
    return ind;
  }

  public void decode(Individual ind)
  {
    for (int i = 0; i < numCities; i++)
      {
        int cityIndex = ind.getCity(ind, i);
        System.out.println(cities[cityIndex]);
      }
  }


  
}