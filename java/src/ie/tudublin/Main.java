package ie.tudublin;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello world\n");
		
		Dog penny = new Dog();
		penny.setName("Penny");
		penny.speak();


		System.out.println("\nCat\n");

		Cat kiwi = new Cat();
		kiwi.setName("Kiwi");
		kiwi.speak();
		
		for(int i = 0; i < 10; i++)
		{
			kiwi.kill();
		}
	}
	
}