package ViratKohli;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Virat {

	HashMap<String, Integer> bowlers; //used to store no. of balls per bowler
	int numberOfBalls, totalBowlers;
	
	//constructor
	public Virat(int numberOfBalls, HashMap<String, Integer> bowlers) throws AssertionError
	{
	    if(numberOfBalls <= 0)
	        throw new AssertionError("Number of balls should be more than zero");
	    
	    for(String bowler: bowlers.keySet())
	    {
	        if(bowlers.get(bowler) < 0)
	            throw new AssertionError("Number of balls cannot be negative");
	    }
	    
		if(sum(bowlers) >= numberOfBalls) 
		{
			this.numberOfBalls = numberOfBalls; 
			this.bowlers = bowlers;
			this.totalBowlers = bowlers.size();
		}
		else
			throw new AssertionError("Insufficient bowlers!!");
	}
	
	
	/**
	 * calculates the bowling order in order to minimize the runs scored by Virat Kohli
	 * @return bowlingOrder
	 */
	public List<String> bowlingOrder()
	{
		List<String> bowlingOrder = new ArrayList<>();
		
		for(int i = 0; i < numberOfBalls; i++)
		{
			String bowler = findBowler();
			bowlingOrder.add(bowler);
			bowlers.put(bowler, bowlers.get(bowler) - 1);
		}
		
		return bowlingOrder;
	}
	
	
	/**
	 * helper method to find the bowler with the maximum number of balls left to bowl
	 * @return
	 */
	private String findBowler()
	{
		int maxBalls = 0;
		String bowler = null;
		
		for(String bowlerName: bowlers.keySet())
		{
			int balls = bowlers.get(bowlerName);
			if(maxBalls < balls)
			{
				maxBalls = balls;
				bowler = bowlerName;
			}
		}
		
		return bowler;
	}
	
	
	/**
	 * helper method to add the total number of balls of all the bowlers
	 * @param bowlers
	 * @return sum
	 */
	private int sum(HashMap<String, Integer> bowlers)
	{
		int sum = 0;
		
		for(String bowler: bowlers.keySet())
			sum += bowlers.get(bowler);
		
		return sum;
	}
}
