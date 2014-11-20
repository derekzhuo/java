abstract class AbsClass
{
	abstract void  show();
}

class Outer
{
	int x = 3;

	public void function()
	{
	        new AbsClass()
		{
			void show()
			{
				System.out.println("show" + x);
			}
		}.show();
	}
}


class InnerClassDemo4
{
	public static void  main(String[] args)
	{
		Outer out = new Outer();
		out.function();
	}
}
