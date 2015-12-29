import java.util.Random;
import java.util.Scanner;

public class test1
{
	static Random rand = new Random();
	public static void main(String[] args)
	{
		Driver driver1 = new Driver(1, false, 1, 1, 0);
		int age = 0;
		boolean conviction = false;
		
		System.out.println("Would you like to generate a driver? (y/n)");
		Scanner scan = new Scanner(System.in);
		String randDriverQ = scan.nextLine();
		
		if (randDriverQ.equals("n")){
			System.out.println("Enter Driver's age:");
			age = scan.nextInt();
			System.out.println(age);
			System.out.println("Does the driver have a conviction?");
			conviction = scan.nextBoolean();
			System.out.println(conviction);
		}
		else if (randDriverQ.equals("y")){
			RandomData randomdata = new RandomData();
			randomdata.generateDriver(driver1);
			age = driver1.getAge();
			conviction = driver1.isConviction();
		}
		
		float experience = driver1.getExperience();
		float aggression = driver1.getAggression();
		System.out.println("experience:" + experience);
		System.out.println("aggression:" + aggression);
		CrashChance crashchance1 = new CrashChance();
		crashchance1.crashProb(driver1);
		float crashChance = driver1.getCrashChance();
		
		System.out.println("Age: " + age);
		
		if (conviction == true)
		{
			System.out.println("You have a conviction, it is illegal for you to drive");
		}
		else if (age > 80)
		{
			System.out.println("you are too old to drive");
		}
		else if (age <= 80 && age > 25)
		{
			System.out.println("you can old enough to drive");
		}
		else if (age <= 25 && age > 16)
		{
			System.out.println("you can old enough to drive but you can't afford to");
		}
		else if (age <= 16 && age > 4)
		{
			System.out.println("you are not old enough to drive");
		}
		else if (age <= 4)
		{
			System.out.println("you are a baby");
		}
		
		System.out.println("you are " + crashChance + "% likely to crash");
		
		if (age > 16 && conviction != true && crashChance < 10 && experience > 10){
			System.out.println("Insurance available");
		}
		else {
			System.out.println("too dangerous to insure");
		}
	}
}