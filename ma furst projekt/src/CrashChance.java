
public class CrashChance {

	public float crashProb(Driver driver1){
		
		int age = driver1.getAge();
		float experience = driver1.getExperience();
		float aggression = driver1.getAggression();
		float crashChance = ((aggression/(experience*5))*(age/5));
		
		driver1.setCrashChance(crashChance);
		
		return crashChance;
	}
}