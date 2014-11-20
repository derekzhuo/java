import java.util.concurrent.locks.*;

class ProducerConsumerDemo2
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

	private Lock lock = new ReentrantLock();
	private Condition condition = new lock.newCondition();

	//t1 t2
	public void Set(String name) throws InterruptedException
		{
			lock.lock();

			try
				{
					while(flag)
						condition.await();
			
					this.name = name + "--" + count++;
					System.out.println(Thread.currentThread().getName()+ "...producer" + this.name);
					flag = true;
					condition.signal();
				}
			finally
				{
					lock.unlock();		
				}
		}
	//t3 t4
	public void Out() throws InterruptedException
		{
			try
				{
					while(!flag)//t3 wait, and t4 wait
						condition.await();
					System.out.println(Thread.currentThread().getName()+ "......consumer" + this.name);
					flag = false;
					condition.signal();
				}
			finally
				{
					lock.unlock();
				}
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
					try
						{
							res.Set("+Goods!!!+");
						}
					
					catch(InterruptedException e)
						{
							
						}
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
					try
						{
							res.Out();
						}
					
					catch(InterruptedException e)
						{
							
						}
					
				}
		}

}

