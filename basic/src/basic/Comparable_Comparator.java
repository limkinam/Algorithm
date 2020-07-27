package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparable_Comparator {

	static class Person implements Comparable<Person>{
		String name;
		int power;
		
		public Person(String name, int power) {
			super();
			this.name = name;
			this.power = power;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", power=" + power + "]";
		}

		@Override
		public int compareTo(Person p) {
			// TODO Auto-generated method stub
			return this.power - p.power;
		}
		
	}
	
	//파워 순으로 정렬
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("임기남",1000));
		list.add(new Person("현다이",3000));
		list.add(new Person("김싸피",2000));
		System.out.println("정렬전 : "+list.toString());
		
		
		Collections.sort(list);
		System.out.println("comparable 이용 오름차순 정렬후 : "+list.toString());
		
		Collections.sort(list,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o2.power-o1.power;
			}
			
		});		
		System.out.println("comparator 이용 내림차순 정렬후 : "+list.toString());
	}

}
