package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Course;
import af.mcit.springDataJpa.Domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private  TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course springBootCourse=Course.builder()
                .courseTitle("Spring boot")
                .credit(5)
                .build();

        Course javaCourse=Course.builder()
                .courseTitle("Java")
                .credit(3)
                .build();

        Teacher teacher= Teacher.builder()
                .firstName("Hadi")
                .lastName("Rezaie")
                .courses(List.of(springBootCourse, javaCourse))
                .build();
        teacherRepository.save(teacher);
    }

}