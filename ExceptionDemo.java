class Demo
{
	int div(int a, int b)
		{
			//if(b == 0)
				//throw new ArithmeticException("divided by 0");
			return a/b;
		}
}

class ExceptionDemo
{
	public static void main(String[] args)
		{

			Demo d = new Demo();

			//try
				//{
					int x = d.div(4,0);
					System.out.println("x="+x);
				//}

			System.out.println("over");
		}
}
