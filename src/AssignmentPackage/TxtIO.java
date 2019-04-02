package AssignmentPackage;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtIO {
	private static TxtIO instance = null;

	private TxtIO() {
	}

	public static TxtIO GetInstance() {
		if (instance == null) {
			instance = new TxtIO();
		}

		return instance;
	}

	private ArrayList<String> ReadLinesFromFile(String fileName) {
		try {
			ArrayList<String> returnList = new ArrayList<String>();
			Scanner scanner = new Scanner(new FileInputStream(fileName)).useDelimiter("\n");

			while (scanner.hasNext())
				returnList.add(scanner.next());

			return returnList;
		} catch (Exception e) {
			return null;
		}
	}

	private void SaveLinesToFile(ArrayList<String> list, String fileName) {
		try {
			FileWriter writer = new FileWriter(fileName);
			for (String str : list) {
				writer.write(str);
			}
			writer.close();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public ArrayList<Student> GetAllStudents() {
		try {
			ArrayList<String> txtLines = ReadLinesFromFile("students.txt");
			ArrayList<Student> returnList = new ArrayList<Student>();

			for (String item : txtLines) {
				String[] splitted = item.split("\t");
				String id = splitted[0].trim();
				String name = splitted[1].trim();
				String surname = splitted[2].trim();

				splitted[7] = splitted[7].trim();

				int g1 = Integer.parseInt(splitted[3].trim());
				int g2 = Integer.parseInt(splitted[4].trim());
				int g3 = Integer.parseInt(splitted[5].trim());
				int g4 = Integer.parseInt(splitted[6].trim());
				int g5 = Integer.parseInt(splitted[7].trim());

				Student s = new Student(id, name, surname, g1, g2, g3, g4, g5);
				returnList.add(s);
			}

			return returnList;
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
	}

	public void SaveStudentListIntoTxt(ArrayList<Student> studentList) {
		ArrayList<String> saveList = new ArrayList<String>();

		for (Student s : studentList) {
			String str = "";
			str += s.getId() + "\t";
			str += s.getName() + "\t";
			str += s.getSurname() + "\t";
			str += s.getCourse1Grade() + "\t";
			str += s.getCourse2Grade() + "\t";
			str += s.getCourse3Grade() + "\t";
			str += s.getCourse4Grade() + "\t";
			str += s.getCourse5Grade() + "\n";
			saveList.add(str);
		}

		SaveLinesToFile(saveList, "students.txt");
	}

	public Student GetStudentById(String _studentId) {
		try {
			ArrayList<String> txtLines = ReadLinesFromFile("students.txt");

			for (String item : txtLines) {
				String[] splitted = item.split("\t");
				String id = splitted[0].trim();

				if (!id.equals(_studentId))
					continue;

				String name = splitted[1].trim();
				String surname = splitted[2].trim();

				int g1 = Integer.parseInt(splitted[3].trim());
				int g2 = Integer.parseInt(splitted[4].trim());
				int g3 = Integer.parseInt(splitted[5].trim());
				int g4 = Integer.parseInt(splitted[6].trim());
				int g5 = Integer.parseInt(splitted[7].trim());

				Student s = new Student(id, name, surname, g1, g2, g3, g4, g5);
				return s;
			}

			return null;
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		}
	}
}