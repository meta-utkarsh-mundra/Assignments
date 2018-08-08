package ds2Counselling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * this class does reading and printing from the files according to the functions requirements
 */
public class FileHandling {
	private static Queue<Student> studentQueue = new LinkedList<Student>();
	private static List<Program> programList = new ArrayList<Program>();
	
    /**
     * Returns queue of student, after reading from file 
     * @return queue containing student objects
     * @throws AssertionError if file is not found
     */
    public static Queue<Student> getListOfStudents() throws AssertionError {
    	//Here is the location of our text file student which consists the information of student
        String fileName = "G:\\Eclips Java\\DataStructures\\src\\ds2Counselling\\Students.txt";
        List<String> listOfEntries = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            listOfEntries = br.lines().collect(Collectors.toList());
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }

        //Here info is taken from student text file and added to the queue
        for(String entry: listOfEntries) {
            String[] listOfAttributes = entry.split(" ");

            if(listOfAttributes.length > 7) {
                throw new AssertionError("Number of attributes not equal to required");
            }
            int id = Integer.parseInt(listOfAttributes[0]);
            String name = listOfAttributes[1];
            String[] preferences = {listOfAttributes[2],
                                    listOfAttributes[3],
                                    listOfAttributes[4],
                                    listOfAttributes[5],
                                    listOfAttributes[6]};
            Student student = new Student(id, name, preferences);
            studentQueue.add(student);    
        }     
        return studentQueue;
    }

    /**
     * Returns list of programs, after reading from file
     * @return list of programs
     * @throws AssertionError if file is not found
     */
    public static List<Program> getListOfPrograms() throws AssertionError{
    	//Here is the location of our text file Program which consists the information of programs of a college
        String fileName = "G:\\Eclips Java\\DataStructures\\src\\ds2Counselling\\Programs.txt";
        List<String> listOfEntries = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            listOfEntries = br.lines().collect(Collectors.toList());

        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        //Here information of programs is taken from the text file and is added to the list
        for(String entry:listOfEntries) {
            String[] listOfAttributes = entry.split(" ");

            if(listOfAttributes.length < 2) {
                throw new AssertionError("Number of attributes not equal to required");
            }
            
            String name = listOfAttributes[0];
            int capacity = Integer.parseInt(listOfAttributes[1]);
            
            Program program = new Program(name, capacity);
            programList.add(program);
        }
        return programList;
    }

    /**
     * this class displays the result of counseling
     * @return true if file is created else returns false
     */
    public static boolean displayResult() {
        Counseling counseling = new Counseling();
        List<Student> studentList = counseling.getStudentList();

        try {
        	//If everything goes correct then a new file is created at this location with the result of counseling in it
            PrintWriter writer = new PrintWriter
                    ("G:\\Eclips Java\\DataStructures\\src\\ds2Counselling\\Result.txt", "UTF-8");
            for(Student student: studentList) {
                writer.println(student.getId() + "\t" +
                             student.getName() + "\t" +
                             student.getProgramAllocated());
            }
            writer.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }   
    }
}