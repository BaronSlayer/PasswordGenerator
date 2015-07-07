package password_Generator;

public class Generator_Driver
{
	public static void main(String[] args)
	{
		int upperCase = 1;
		int numbers = 1;
		int specials = 1;
		
		char[] password = Generator.generate (upperCase, numbers, specials);

		System.out.println("Length = " + password.length + ", " + new String(password));
	}
}

