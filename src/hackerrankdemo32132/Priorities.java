package hackerrankdemo32132;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getCgpa()==o2.getCgpa()) {
			if(o1.getName()==o2.getName()) {
				if(o1.getId()==o2.getId()) {
					return 0;
				}else if(o1.getId()>o2.getId()) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return o1.getName().compareTo(o2.getName());
			}
			
			
			
		}else {
			return (int) (o1.getCgpa()-o2.getCgpa());
		}
		
			
		
		
		
	}

	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> students = new PriorityQueue<>(new Priorities());
		for(int i=0;i<events.size();i++) {
			if(events.get(i).contains("ENTER")) {
				String[] str=events.get(i).split(" ");
				double y=Double.parseDouble(str[2]);
				int k=Integer.parseInt(str[3]);
				students.add(new Student(k,str[1],y));
			}else {
				students.poll();
			}
		}
		ArrayList<Student> x=new ArrayList<>();
		while(!students.isEmpty()) {
			x.add(students.poll());
		}
		return x;
	}

}
