import java.util.*;

class Person
{
	private String name;
	private int age;
	Person(String name, int age)
		{
			this.name = name;
			this.age = age;
		}

	public String getName()
		{
			return this.name;
		}
	public int getAge()
		{
			return this.age;
		}
	public boolean equals(Object obj)
		{
			if(!(obj instanceof Person))
				return false;

			Person p =(Person)obj;
			System.out.println(this.name + "...." + p.name);
			return this.name.equals(p.name) && this.age == p.age;
		}
}

class ArrayListDemo2
{

	public static void main(String[] args)
		{
			ArrayList al = new ArrayList();

			al.add(new Person("derickross", 28));
			al.add(new Person("derickross", 28));
			al.add(new Person("bonniezhang", 23));
			al.add(new Person("kobebriant", 36));
			al.add(new Person("iverson", 30));

			Iterator it = al.iterator();

			while(it.hasNext())
				{
					Person p = (Person)it.next();
					sop(p.getName()+ "::"
						+ p.getAge());
				}

			System.out.println();

			al = singleElement(al);//need to rewrite method equals() of class Person
			
			Iterator itt = al.iterator();
			while(itt.hasNext())
				{
					Person p = (Person)itt.next();
					sop(p.getName()+ "::" + p.getAge());
				}


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
