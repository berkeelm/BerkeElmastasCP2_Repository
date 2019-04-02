package AssignmentPackage;

public class Student {
	private String Id;
	private String Name;
	private String Surname;
	private int Course1Grade;
	private int Course2Grade;
	private int Course3Grade;
	private int Course4Grade;
	private int Course5Grade;

	public Student() {

	}

	public Student(String _id, String _name, String _surname, int _g1, int _g2, int _g3, int _g4,
			int _g5) {
		this.Id = _id;
		this.Name = _name;
		this.Surname = _surname;
		this.Course1Grade = _g1;
		this.Course2Grade = _g2;
		this.Course3Grade = _g3;
		this.Course4Grade = _g4;
		this.Course5Grade = _g5;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getCourse1Grade() {
		return Course1Grade;
	}

	public void setCourse1Grade(int course1Grade) {
		Course1Grade = course1Grade;
	}

	public int getCourse2Grade() {
		return Course2Grade;
	}

	public void setCourse2Grade(int course2Grade) {
		Course2Grade = course2Grade;
	}

	public int getCourse3Grade() {
		return Course3Grade;
	}

	public void setCourse3Grade(int course3Grade) {
		Course3Grade = course3Grade;
	}

	public int getCourse4Grade() {
		return Course4Grade;
	}

	public void setCourse4Grade(int course4Grade) {
		Course4Grade = course4Grade;
	}

	public int getCourse5Grade() {
		return Course5Grade;
	}

	public void setCourse5Grade(int course5Grade) {
		Course5Grade = course5Grade;
	}

	public double getGpa() {
		return (Course1Grade + Course2Grade + Course3Grade + Course4Grade + Course5Grade) / 5;
	}
}
