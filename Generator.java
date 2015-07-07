package password_Generator;

import java.util.Random;

public class Generator
{
	private static final String UPPERCASE 	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIALS = "!@#$%^&*()_=+-/";

	public static char[] generate (int upperCase,	int numbers, int specials)
	{
		Random rand = new Random();
		int length = Integer.parseInt(GeneratorPanel.numbers.getText());
		char[] password = new char[length];
		int index = 0;
		
		for (int i = 0; i < upperCase; i++)
		{
			index = nextIndex (rand, length, password);
			password[index] = UPPERCASE.charAt(rand.nextInt(UPPERCASE.length()));
		}
		for (int i = 0; i < numbers; i++)
		{
			index = nextIndex (rand, length, password);
			password[index] = NUMBERS.charAt(rand.nextInt(NUMBERS.length()));
		}
		for (int i = 0; i < specials; i++)
		{
			index = nextIndex (rand, length, password);
			password[index] = SPECIALS.charAt(rand.nextInt(SPECIALS.length()));
		}
		for(int i = 0; i < length; i++)
		{
			if(password[i] == 0)
			{
				password[i] = LOWERCASE.charAt(rand.nextInt(LOWERCASE.length()));
			}
		}
		return password;
	}
	
	private static int nextIndex (Random rand, int length, char[] password) {
		int index = rand.nextInt(length);
		while(password[index = rand.nextInt(length)] != 0);
		return index;
	}
}
