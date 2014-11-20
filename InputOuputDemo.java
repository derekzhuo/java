class Res
{
	String name;
	String sex;
	boolean flag = false;//to test if there is a data

	public synchronized void set(String name, String sex)
		{
			if(flag)//true, means there is data, the sleep and wait for another thread to get the date out, else put a data in
				try{wait();}catch(Exception e){}
			
			this.name = name;
			this.sex = sex;

			flag = true;
			notify();
		}
	public synchronized void out()
		{
			if(!flag)//true, means there is data, get out the data, else wait another thread to put data in 
				try{wait();}catch(Exception e){}

			System.out.println(name + "..." + sex);
			flag = false;
			notify();
		}
}

class Input implements Runnable
{
	private Res r;
	Input(Res r)
		{
			this.r = r;
		}
	public void run()
		{
			int x = 0;

			while(true)
				{
					if(0 == x)
						r.set("mike", "man");
					else
						r.set("lili","woman");

					x = (x+1) % 2;
				}
		}
}

class Output implements Runnable
{
	Res r = new Res();
	Output(Res r)
		{
			this.r = r;
		}
	public void run()
		{
			while(true)
				r.out();
		}
}


class InputOutputDemo
{
	public static void main(String[] args)
		{
			Res r = new Res();

			new Thread(new Input(r)).start();
			new Thread(new Output(r)).start();
//			Input in = new Input(r);
//			Output out  =  new Output(r);

//			Thread t1 =  new Thread(in);
//			Thread t2 =  new Thread(out);

//			t1.start();
//			t2.start();
		}
	
}
