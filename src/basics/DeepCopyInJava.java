package basics;

class Course implements Cloneable {
	String subject1;
	String subject2;
	String subject3;

	public Course(String sub1, String sub2, String sub3) {
		this.subject1 = sub1;
		this.subject2 = sub2;
		this.subject3 = sub3;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Student implements Cloneable {
	int id;
	String name;
	Course course;

	public Student(int id, String name, Course course) {
		this.id = id;
		this.name = name;
		this.course = course;
	}

	// Overriding clone() method to create a deep copy of an object.

	protected Object clone() throws CloneNotSupportedException {
		
		//return super.clone(); //shallow coppy
		
		Student student = (Student) super.clone(); //get student-clone, and insert course-clone into it.
		student.course = (Course) course.clone();
		return student;
	}
	//https://www.journaldev.com/60/java-clone-object-cloning-java
	//clonning for hashmap, it's same as reference.
	/*public Object clone() throws CloneNotSupportedException {

		Object obj = super.clone(); //utilize clone Object method

		Employee emp = (Employee) obj;

		// deep cloning for immutable fields
		emp.setProps(null);
		Map<String, String> hm = new HashMap<>();
		String key;
		Iterator<String> it = this.props.keySet().iterator();
		// Deep Copy of field by field
		while (it.hasNext()) {
			key = it.next();
			hm.put(key, this.props.get(key));
		}
		emp.setProps(hm);
		
		return emp;
	}*/
}

public class DeepCopyInJava {
	public static void main(String[] args) {
		Course science = new Course("Physics", "Chemistry", "Biology");
		Student student1 = new Student(111, "John", science);
		Student student2 = null;

		try {
			// Creating a clone of student1 and assigning it to student2
			student2 = (Student) student1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// Printing the subject3 of 'student1'
		System.out.println(student1.course.subject3); // Output : Biology

		// Changing the subject3 of 'student2'
		student2.course.subject3 = "Maths";

		// This change will not be reflected in original student 'student1'
		System.out.println(student1.course.subject3); // Output : Biology
	}
}