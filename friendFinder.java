import java.util.*;


public class friendFinder {

	public static class Person {
		// The class is to build the "Person", give some attributes a person must 
		// have(Such as age, name, and his/her friends).
		public Boolean friendOfSomeone;
		public String name ;
		public int age ;
		public Set<String> friends; // Initial a empty friend's frame to trace who is his/her friends.

		public Person( String name, int age, String friends ){ // Constructor for a person.
			this.friendOfSomeone = false;
			this.name = name;
			this.age = age;
			String[] tokens = friends.split(",");
			this.friends = new HashSet<String>(); // Using hashmap to record the data.
			for( String token : tokens ){
				this.friends.add(token);
			}
		}
		// Call the information of the person.
		public String toString(){
			return this.name + " " + this.age + " " + this.friends;
		}

	}

    // The sort function is to compare two person by their name.
	public static class SortByName implements Comparator<Person>{
		public int compare( Person a, Person b ){
			return a.name.compareTo(b.name);
		}
	}

	public static void main(String[] args) {
		// Data loading...
		Scanner scanner = new Scanner(System.in);
		List<Person> people = new ArrayList<Person>();
		// Build the person class for each person.
		while( scanner.hasNext() ){
			String name = scanner.next();
			int age = scanner.nextInt();
			String friends = scanner.next();
			Person p = new Person(name, age, friends);
			people.add( p );
		}

		// task1: Find average age.
		System.out.println("--task1--");
		int sum = 0;
		for( Person p : people ){ sum+=p.age; }
		double mean = Double.valueOf(sum)/people.size();
		System.out.println(Math.round(mean));

		// task2: Find the person who's friend list include Chris.Redfield and all people of Beneviento's family 
		System.out.println("--task2--");
		List<Person> ps = new ArrayList<Person>();
		for( Person p : people )
			if( p.name.contains("Beneviento") && p.friends.contains("Chris.Redfield") )
				ps.add( p );
		Collections.sort(ps, new SortByName()); // Sort by names
		for( Person p : ps )
			System.out.println(p.name);
	}

}