package ds2Counselling;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * This class does the counceling process, interacts with Program and Student class
 */
public class Counseling {

	private static List<Student> studentList = new ArrayList<Student>();

	/**
	 * Allocates program to each student according to the preferences provided by them
	 * If the preference given by the student is not listed in the programs provided by college then next preference is checked
	 * If the preference given by student is already filled then next peference is checked
	 */
	public void allocatePrograms() {
		Queue<Student> studentQueue = FileHandling.getListOfStudents();
		List<Program> programList = FileHandling.getListOfPrograms();
		
		boolean isStudentQueueEmpty = studentQueue.isEmpty();

		//Here one student is removed from the queue at a time and added to the student list
		while(! isStudentQueueEmpty) {
			Student student = studentQueue.remove();
			studentList.add(student);
			
			String[] preferences = student.getPreferences();

			outer:for(int i = 0; i < preferences.length; i++) {
				//Here preference is checked for each student one by one
				for(Program program : programList) {
					String programName = program.getName();
					if(programName.equals(preferences[i])) {
						int numberOfAllocatedStudents = program.getNumberOfAllocatedStudents();
						int capacityOfProgram = program.getCapacity();

						//If capacity of program is not full then student is assigned the program
						if(numberOfAllocatedStudents < capacityOfProgram) {
							student.setProgramAllocated(programName);
							program.increaseNumberOfAllocatedStudents();
							break outer;
						}
					}
				}
			}
			isStudentQueueEmpty = studentQueue.isEmpty();
		}
	}

	/**
	 * To get the Student list which are taking part in counseling process
	 * @return list of students enrolled in counseling
	 */
	public List<Student> getStudentList() {
		return studentList;
	}
}
