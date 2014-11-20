interface inter
{
	void method();
}

class Test
{
	static inter function()
	{
		return new inter()
		{
			public void method()
			{
				System.out.println("method");
			}		
		};	
	}
}

class InnerClassTest
{
	public static void main(String[] args)
	{
		Test.function().method();
	}
}
