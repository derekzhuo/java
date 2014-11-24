class StopThreadDemo
{
	public static void main(String[] args)
		{
			StopThread st = new StopThread();
			
			Thread t1 = new Thread(st);			
			Thread t2 = new Thread(st);

			t1.start();
			t2.start();

			int num = 0;

			while(true)
				{
					if(num++ == 100)
						{
						st.changeflag();
							break;
						}
					System.out.println(Thread.currentThread()
						.getName()+ "....." + num);
				}
			System.out.println("main over!!!!!!!");
		}
}


class StopThread implements Runnable
{
	private boolean flag = true;
	public void run()
		{
			while(flag)
				{
					System.out.println(Thread.currentThread()
						.getName()+"....");
				}
			System.out.println(Thread.currentThread().getName()+
				"...get out");
		}
	public void changeflag()
		{
			flag = false;
		}
}

