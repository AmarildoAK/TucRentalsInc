package utils;
import java.util.Random;

public class Randomizer {

	
public static int randomNumber;
static Random rand = new Random();
	public static int createRandomNums() {
		 randomNumber = rand.nextInt(9000) + 1000;
		return randomNumber;
	}
}
