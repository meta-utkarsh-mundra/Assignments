
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringUniqueCharacterCheck {
	HashMap<String,Integer> cache = new HashMap<String,Integer>();
	
	public int findTheUniqueCharacterIn(String stringWithAStatement)
	{
		Set<Character> uniqueCharacterSet = new HashSet<Character>();
		if(cache.containsKey(stringWithAStatement)){
			return cache.get(stringWithAStatement);
		}
		else
		{
			System.out.println("lOGIC aPLIED");
			for(int index=0;index<stringWithAStatement.length();index++)
			{
				if(stringWithAStatement.charAt(index)==32){
					continue;
				}
				uniqueCharacterSet.add(stringWithAStatement.charAt(index));
			}
			
			cache.put(stringWithAStatement, uniqueCharacterSet.size());
			return uniqueCharacterSet.size();
		}
	}


	public static void main(String args[])
	{
		StringUniqueCharacterCheck obj = new StringUniqueCharacterCheck();
		int count = obj.findTheUniqueCharacterIn("Hello Ajay Kumar Vijay");
		System.out.println(count);
		count = 1;
		count = obj.findTheUniqueCharacterIn("Hello Ajay Kumar Vijay");
		System.out.println(count);
	}
}
