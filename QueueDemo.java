import java.util.*;

class QueueDemo
{
	public static void main(String[] args)
		{
			Queue q = new Queue();
			q.myAdd("java01");
			q.myAdd("java02");			
			q.myAdd("java03");
			q.myAdd("java04");
			q.myAdd("java05");

			while(!q.isNull())
				System.out.println(q.MyGet());
		}
}

class Queue
{
	private LinkedList link;
	Queue()
		{
			link = new LinkedList();
		}
	public void myAdd(Object obj)
		{
			link.addFirst(obj);
		}
	public Object MyGet()
		{
//			return link.removeLast();//queue
			return link.removeFirst();//stack
		}
	public boolean isNull()
		{
			return link.isEmpty();
		}
	
}