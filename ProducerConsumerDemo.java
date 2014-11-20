class ProducerConsumerDemo
{
	public static void main(String[] args)
		{
			Resource r = new Resource();

			Producer pro = new Producer(r);
			Consumer con = new Consumer(r);

			Thread t1 = new Thread(pro);
			Thread t2 = new Thread(pro);
			Thread t3 = new Thread(con);
			Thread t4 = new Thread(con);

			t1.start();
			t2.start();
			t3.start();
			t4.start();

		}
}

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

	//t1 t2
	public synchronized void Set(String name)
		{
			while(flag)//t1 wait, and t2 wait
				try{wait();}catch(Exception e){}
			this.name = name + "--" + count++;
			System.out.println(Thread.currentThread().getName()+ "...producer" + this.name);
			flag = true;
			notifyAll();
		}
	//t3 t4
	public synchronized void Out()
		{
			while(!flag)//t3 wait, and t4 wait
				try{wait();}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+ "......consumer" + this.name);
			flag = false;
			notifyAll();
		}
}


class Producer implements Runnable
{
	private Resource res;
	Producer(Resource res)
		{
			this.res = res;
		}
	public void run()
		{
			while(true)
				{
					res.Set("+Goods!!!+");
				}
		}
}

class Consumer implements Runnable
{
	private Resource res;
	Consumer(Resource res)
		{
			this.res = res;
		}
	public void run()
		{
			while(true)
				{
					res.Out();
				}
		}

	
}
