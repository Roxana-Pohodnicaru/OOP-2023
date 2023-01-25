package ie.tudublin;

public class Cat {

    String name;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Cat()
	{
	}
	
	public Cat(String name)
	{
	}
	
	public void speak()
	{
		System.out.println("Meow");
	}

	int numLives = 9;

	public void kill()
	{
        if(this.numLives > 0)
        {
            this.numLives = this.numLives - 1;
		    System.out.println("Ouch");
        }
        else if(this.numLives == 0)
		{
			System.out.println("Dead");
		}
	}
}
