package junit.testing.assertions;

import junit.testing.Student;
import junit.testing.StudentNotFoundException;
import junit.testing.StudentService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTest(){
        StudentService studentService=new StudentService();
       // Student student=new Student(1,"Ram");
        List<Student> list=studentService.getStudents();
        //studentService.addStudent(student);
        boolean actualResult=list.isEmpty();
       // assertTrue(actualResult);
        //assertTrue(()->actualResult);
        //assertTrue(actualResult,"List Of Students is empty");
        //assertTrue(()->actualResult,"List is empty");
       // assertTrue(actualResult,()->"List of students is empty");
            assertTrue(()->actualResult,()->"List is empty");
    }

    @Test
    public void getStudentsTestUsingAssertFalse(){
         StudentService studentService=new StudentService();
        //Student student=new Student(1,"Ram");
         List<Student> list=studentService.getStudents();
        // studentService.addStudent(student);
         boolean actualResult=list.isEmpty();

         //assertFalse(actualResult);
         assertFalse(actualResult,"Student list should not be empty");

    }


    @Test
    public void getStudentNamesByDepartmentTest(){

        StudentService studentService=new StudentService();
        Student student=new Student(1,"Ram","Science");
        Student student1=new Student(2,"Ramesh","Science");
        Student student2=new Student(3,"Ramu","History");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        String[] actualArray=studentService.getStudentNamesByDepartment("Science");
        String[] exceptedArray={"Ram","Ramesh"};
        //assertArrayEquals(exceptedArray,actualArray);
        //assertArrayEquals(exceptedArray,actualArray,"Student names are not equal");
        //assertArrayEquals(exceptedArray,actualArray,()->"student names are not equal");
        Integer[] actualStudentIds=studentService.getStudentIdsByDepartment("Science");
        Integer[] expectedStudentIds={1,2};
        assertArrayEquals(expectedStudentIds,actualStudentIds);
     }


     @Test
    public void getStudentsAssertIterable(){
         StudentService studentService=new StudentService();
         Student student=new Student(1,"Ram","Science");
         Student student1=new Student(2,"Ramesh","Science");
         Student student2=new Student(3,"Ramu","History");
         studentService.addStudent(student);
         studentService.addStudent(student1);
         studentService.addStudent(student2);

         List<String> actualStudent=studentService.getStudentNamesListByDepartment("Science");
         List<String> expectedStudent= Arrays.asList("Ram","Ramesh");
         assertIterableEquals(expectedStudent,actualStudent);
    }

    @Test
    public void getStudentByNameUsingAssertThrows(){

        StudentService studentService=new StudentService();
        Student student=new Student(1,"Ram","Science");
        //Student student1=new Student(2,"Ramesh","Science");
        //Student student2=new Student(3,"Ramu","History");
        studentService.addStudent(student);
        //studentService.addStudent(student1);
        //studentService.addStudent(student2);

/*
        assertThrows(StudentNotFoundException.class,
                ()->studentService.getStudentByname("Sam"));
*/

        /*assertThrows(StudentNotFoundException.class,
                ()->studentService.getStudentByname("Ram"),
                "StudentNotFoundException should be throw.but it wasn't");
*/
     /*   assertThrows(StudentNotFoundException.class,
                ()->studentService.getStudentByname("Ram"),
                  "StudentNotFoundException should be throw.but it wasn't");
*//*
        assertThrowsExactly(StudentNotFoundException.class,
                ()->studentService.getStudentByname("SAM"));*/

        StudentNotFoundException exception=assertThrowsExactly(StudentNotFoundException.class,
                ()->studentService.getStudentByname("Ram"),()->"Student not found with name"+student.getName());

        assertEquals("Student not found with name"+student.getName(),exception.getMessage());
    }

}