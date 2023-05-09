package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Guardian;
import af.mcit.springDataJpa.Domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class StudentRepositoryTest  {
    @Autowired
private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("Hadi@mail.com")
                .firstName("Hadi")
                .lastName("Rezaie")
//                .guardianName("Something")
//                .guardianEmail("Something@mail.com")
//                .guardianMobile("0797979797")
                        .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian= Guardian.builder()
                .email("Guardian@mail.com")
                .name("Guardian")
                .mobile("797979797")
                .build();
        Student student= Student.builder()
                .firstName("Hadi")
                .lastName("Rezaie")
                .emailId("email@mail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("Student List= "+ studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> students= studentRepository.findByFirstName("Hadi");
        System.out.println("Student: "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students= studentRepository.findByFirstNameContaining("Ha");
        System.out.println("Student: "+students);
    }
    public void printgetStudentByEmailAddress(){
        Student student= studentRepository.getStudentByEmailAddress("Hadi@mail.com");
        System.out.println("Student: "+student);
    }
    @Test
    public void printStudentEmailAddressNative(){
        Student student= studentRepository.getStudentByEmailAddressNative("hadi@mail.com");
        System.out.println("Student: "+student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student= studentRepository.printStudentByEmailAddressNativeNamedParam("hadi@mail.com");
        System.out.println("Student: "+student);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Hadirezaie","Hadi@mail.com");
    }
}