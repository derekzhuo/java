import java.util.*;

/*
1.the method add() just get an address of an object
2.the args of this method is "Object", so that it can get any kind of args
*/

class CollectionDemo
{
	public static void main(String[] args)
		{
			//new a collection object
			ArrayList al01 = new ArrayList();
			ArrayList al02 = new ArrayList();

			//1.add elements
			al01.add("java01");
			al01.add("java02");
			al01.add("java03");
			al01.add("java04");


			al02.add("java05");
			al02.add("java06");
			al02.add("java07");
			al02.add("java08");


			al01.retainAll(al02);

			sop(al01);
			sop(al02);
//			sop(al);


			//2.remove elements
//			al.remove("java01");
//			al.clear();
			//judge
//			sop("is there java03..." + al.contains("java03"));
//			sop("is al empty..." + al.isEmpty());

//			sop(al);

			
//			sop("size:" + al.size());
		}

	public static void sop(Object obj)
		{
			System.out.println(obj);
		}
}
