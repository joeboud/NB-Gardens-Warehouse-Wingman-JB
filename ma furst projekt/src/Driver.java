
public class Driver {
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isConviction() {
		return conviction;
	}

	public void setConviction(boolean conviction) {
		this.conviction = conviction;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public float getAggression() {
		return aggression;
	}

	public void setAggression(int aggression) {
		this.aggression = aggression;
	}
	
	public float getCrashChance() {
		return crashChance;
	}

	public void setCrashChance(float crashChance) {
		this.crashChance = crashChance;
	}
	
	private int age;
	private boolean conviction;
	private float experience;
	private float aggression;
	private float crashChance;
	
	
	public Driver(int age, boolean conviction, float experience, float aggression, float crashChance){
		this.age = age;
		this.conviction = conviction;
		this.experience = experience;
		this.aggression = aggression;
		this.crashChance = crashChance;
	}

	
}
