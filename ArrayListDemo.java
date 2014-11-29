import java.util.*;

class ArrayListDemo
{
	public static void main(String[] args)
		{
			ArrayList al = new ArrayList();

			al.add("java01");
			al.add("java02");
			al.add("java01");
			al.add("java01");
			al.add("java03");
			al.add("java01");

			sop(al);
			al = singleElement(al);
			sop(al);
		}

	public static ArrayList singleElement(ArrayList al)
		{
			ArrayList newal = new ArrayList();
			Iterator it = al.iterator();

			while(it.hasNext())
				{
					Object obj = it.next();
					if(!newal.contains(obj))
						newal.add(obj);
				}

			return newal;
			
		}

	public static void sop(Object obj)
		{
			System.out.println(obj);
		}
}