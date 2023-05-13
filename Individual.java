import java.util.*;

class Individual
{
  
  public double fitness;
  public int distance;
  ArrayList <Integer> tour = new ArrayList<Integer>();
  public int [][] travelCost;
  public int numCities;
  public String [] cities;
  
  public Individual() 
  {
    Main m = new Main();
    this.numCities = m.numCities;
    this.travelCost = m.travelCost;
    this.cities = m.cities;
    new ArrayList<Integer>();
	}

  public Individual(int numCities) 
  {
		for (int i = 0; i < numCities; i++) 
    {
			tour.add(i);
		}
    Collections.shuffle(tour);
	}

  public void addCity(Individual ind, int city)
  {
    tour.add(city);
  }

  public void setCity(Individual ind, int key, int city)
  {
    for (int i = 0; i < tour.size(); i++)
      {
        if (key == i)
        {
          city = getCity(ind, i);
        }
      }
  }

  public int getCity(Individual ind, int key)
  {
    int city = -1;
    for (int i = 0; i < tour.size(); i++)
      {
        if (key == i)
        {
          city = tour.get(i);
        }
      }
    return city;
  }

  public int getDistance(Individual ind)
  {
    for (int i = 0; i < tour.size(); i++)
      {
        if (i < numCities)
        {
          distance += travelCost[i][i+1];
        }
        else if (i == numCities)
        {
          distance += travelCost[i][0];
        }
      }
    return distance;
  }

  public double getFitness(Individual ind)
  {
    fitness = 1/getDistance(ind);
    return fitness;
  }

}