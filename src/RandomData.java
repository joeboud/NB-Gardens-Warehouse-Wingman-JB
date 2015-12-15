import java.util.Random;

public class RandomData {

	public CustomerOrder generateCO(CustomerOrder){
		
		Random rand = new Random();
		int age = rand.nextInt(100);
		boolean conviction = rand.nextBoolean();
		int experience = rand.nextInt(25);
		int aggression = rand.nextInt(100);
		
		driver1.setAge(age);
		driver1.setConviction(conviction);
		driver1.setExperience(experience);
		driver1.setAggression(aggression);
		
		return driver1;
		
	}
	
}