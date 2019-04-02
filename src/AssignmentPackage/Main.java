package AssignmentPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = null;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Welcome to the student system!");
		ShowMainMenu();
	}

	private static void ShowMainMenu() {
		System.out.println();
		System.out.println("[1] - Show student information by student id.");
		System.out.println("[2] - Show all students information.");
		System.out.println("[3] - Update student information by student id.");
		System.out.println("[4] - Delete student information by student id.");
		System.out.println("[5] - Show student gpa by student id.");
		System.out.println("[6] - Show the average gpa of all students.");
		System.out.println();
		System.out.print("Enter your selection : ");
		String selection = scanner.next();

		System.out.println();

		if (selection.equals("1"))
			ShowStudentInformationByStudentId();
		else if (selection.equals("2"))
			ShowAllStudentInformation();
		else if (selection.equals("3"))
			UpdateStudentInformationByStudentId();
		else if (selection.equals("4"))
			DeleteStudentInformationByStudentId();
		else if (selection.equals("5"))
			ShowStudentGpaByStudentId();
		else if (selection.equals("6"))
			ShowAllStudentsAverageGPA();
		else
			ShowMainMenu();
	}

	private static void UpdateStudentInformationByStudentId() {
		System.out.print("Enter student id : ");
		String studentId = scanner.next();

		Student s = TxtIO.GetInstance().GetStudentById(studentId);
		System.out.println();

		if (s == null) {
			System.out.println("No student found with id " + studentId);
		} else {
			System.out.println("Student Information");
			PrintStudentInformation(s);
			System.out.println();
			System.out.print("Enter new student name (enter -1 if its not changed): ");

			String name = scanner.next();

			if (name.equals("-1") == false)
				s.setName(name);

			System.out.print("Enter new student surname (enter -1 if its not changed): ");

			String surname = scanner.next();

			if (surname.equals("-1") == false)
				s.setSurname(surname);

			System.out.print("Enter new student grade 1 (enter -1 if its not changed): ");

			String g1 = scanner.next();

			if (g1.equals("-1") == false)
				s.setCourse1Grade(Integer.parseInt(g1));

			System.out.print("Enter new student grade 2 (enter -1 if its not changed): ");

			String g2 = scanner.next();

			if (g2.equals("-1") == false)
				s.setCourse2Grade(Integer.parseInt(g2));

			System.out.print("Enter new student grade 3 (enter -1 if its not changed): ");

			String g3 = scanner.next();

			if (g3.equals("-1") == false)
				s.setCourse3Grade(Integer.parseInt(g3));

			System.out.print("Enter new student grade 4 (enter -1 if its not changed): ");

			String g4 = scanner.next();

			if (g4.equals("-1") == false)
				s.setCourse4Grade(Integer.parseInt(g4));

			System.out.print("Enter new student grade 5 (enter -1 if its not changed): ");

			String g5 = scanner.next();

			if (g5.equals("-1") == false)
				s.setCourse5Grade(Integer.parseInt(g5));

			ArrayList<Student> allStudents = TxtIO.GetInstance().GetAllStudents();

			Boolean isUpdated = false;
			for (int i = 0; i < allStudents.size() && !isUpdated; i++) {
				if (allStudents.get(i).getId().equals(studentId)) {
					allStudents.set(i, s);
					isUpdated = true;
				}
			}

			System.out.println();
			
			
			if (isUpdated) {
				System.out.print("Are you sure (y or n)? ");
				String answer = scanner.next().toLowerCase();

				while (!answer.equals("y") && !answer.equals("n")) {
					System.out.print("Are you sure (y or n)? ");
					answer = scanner.next().toLowerCase();
				}

				if (answer.equals("y")) {
					TxtIO.GetInstance().SaveStudentListIntoTxt(allStudents);
					System.out.println();
					System.out.println("Student updated!");
				}
				
			} else {
				System.out.println("An error occured");
			}
		}

		ShowMainMenu();
	}

	private static void DeleteStudentInformationByStudentId() {
		System.out.print("Enter student id : ");
		String studentId = scanner.next();

		ArrayList<Student> students = TxtIO.GetInstance().GetAllStudents();

		if (students.size() == 0) {
			System.out.println("No students found.");
			return;
		}

		Boolean isDeleted = false;

		for (int i = 0; i < students.size() && !isDeleted; i++) {
			if (students.get(i).getId().equals(studentId)) {
				students.remove(i);
				isDeleted = true;
			}
		}

		if (isDeleted) {
			System.out.print("Are you sure (y or n)? ");
			String answer = scanner.next().toLowerCase();

			while (!answer.equals("y") && !answer.equals("n")) {
				System.out.print("Are you sure (y or n)? ");
				answer = scanner.next().toLowerCase();
			}

			if (answer.equals("y")) {
				TxtIO.GetInstance().SaveStudentListIntoTxt(students);
				System.out.println();
				System.out.println("Student deleted!");
			}
		} else {
			System.out.println("No student found with id " + studentId);
		}

		ShowMainMenu();
	}

	private static void ShowAllStudentsAverageGPA() {
		ArrayList<Student> students = TxtIO.GetInstance().GetAllStudents();

		if (students.size() == 0) {
			System.out.println("No students found.");
		} else {
			double sum = 0;
			for (Student s : students) {
				sum += s.getGpa();
			}

			System.out.println("The average GPA is : " + (sum / students.size()));
		}

		ShowMainMenu();
	}

	private static void ShowStudentGpaByStudentId() {
		System.out.print("Enter student id : ");
		String studentId = scanner.next();

		Student s = TxtIO.GetInstance().GetStudentById(studentId);
		System.out.println();

		if (s == null) {
			System.out.println("No student found with id " + studentId);
		} else {
			System.out.println(s.getName() + "'s GPA is " + s.getGpa());
		}

		ShowMainMenu();
	}

	private static void ShowAllStudentInformation() {
		ArrayList<Student> students = TxtIO.GetInstance().GetAllStudents();

		if (students.size() == 0) {
			System.out.println("No students found.");
		} else {
			for (Student s : students) {
				PrintStudentInformation(s);
				System.out.println();
			}
		}

		ShowMainMenu();
	}

	private static void ShowStudentInformationByStudentId() {
		System.out.print("Enter student id : ");
		String studentId = scanner.next();

		Student s = TxtIO.GetInstance().GetStudentById(studentId);
		System.out.println();

		if (s == null) {
			System.out.println("No student found with id " + studentId);
		} else {
			PrintStudentInformation(s);
		}

		ShowMainMenu();
	}

	private static void PrintStudentInformation(Student s) {
		System.out.println("Id: " + s.getId());
		System.out.println("Name: " + s.getName());
		System.out.println("Surname: " + s.getSurname());
		System.out.println("Course 1 Grade: " + s.getCourse1Grade());
		System.out.println("Course 2 Grade: " + s.getCourse2Grade());
		System.out.println("Course 3 Grade: " + s.getCourse3Grade());
		System.out.println("Course 4 Grade: " + s.getCourse4Grade());
		System.out.println("Course 5 Grade: " + s.getCourse5Grade());
	}
}
