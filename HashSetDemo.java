import java.util.*;

class HashSetDemo
{
	public static void main(String[] args)
		{
			HashSet hs = new HashSet();

			hs.add(new Person("derekzhuo", 26));
			hs.add(new Person("derekzhuo", 26));
			hs.add(new Person("bonniezhang", 23));
			hs.add(new Person("kobebriang", 36));
			hs.add(new Person("nicklin", 26));
			hs.add(new Person("jessicali", 23));

			Iterator it = hs.iterator();

			while(it.hasNext())
				{
					Person p = (Person)it.next();
					sop(p.getName() + "..." + p.getAge());
				}
		}

	public static void sop(Object obj)
		{
			System.out.println(obj);
		}

}



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

	public int hashCode()
		{
			System.out.println("hashcode");
			return name.hashCode();
		}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
			return false;

		Person p =(Person)obj;
		System.out.println(this.name + "..equalssssss.." + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}
}

