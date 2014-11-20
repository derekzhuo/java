class Outer
{
	private static int x = 3;
	
	static class Inner
	{
		static void function()
		{
			System.out.println("inner :" + x);
		}
	}

	static class Inner2
		{
			void show()
				{
					System.out.println("inner2 show");
				}
		}

	public static void method()
		{
			//Inner.function();
			new Inner2().show();
		}
	
}

class InnerClassDemo
{
	public static void main(String[] args)
		{
			//Outer.Inner().function();
			//Outer out = new Outer();
			//out.method();
			//Outer.Inner in = new Outer().new Inner();
			//in.function();
		}
}
