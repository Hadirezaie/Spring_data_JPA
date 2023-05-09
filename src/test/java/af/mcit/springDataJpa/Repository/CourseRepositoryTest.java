package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Course;
import af.mcit.springDataJpa.Domain.Student;
import af.mcit.springDataJpa.Domain.Teacher;
import org.hibernate.tool.schema.internal.exec.AbstractScriptTargetOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.swing.plaf.IconUIResource;
import java.util.List;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
     @Test
    public void printCourses(){
         List<Course> courses=
         courseRepository.findAll();
         System.out.println("Courses: "+courses);
     }

     public  void saveCourseWithTeacherObject(){
         Teacher teacher= Teacher.builder()
                 .firstName("Mahdi")
                 .lastName("Dahmarda")
                 .build();

         Course course= Course.builder()
                 .courseTitle("Java")
                 .credit(3)
                 .teacher(teacher)
                 .build();
         courseRepository.save(course);
     }

//     Applying Pagination
        @Test
     public void findAllPagination(){
            Pageable firstPage= PageRequest.of(0,5);
//            page with 5 records
            Pageable secondPage= PageRequest.of(1,10);
//            page with 10 records

            List<Course> courses= courseRepository.findAll(firstPage).getContent();

            Long totalElements= courseRepository.findAll(firstPage).getTotalElements();
            Integer totalPages= courseRepository.findAll(firstPage).getTotalPages();

            System.out.println("Courses: "+ courses);
            System.out.println("Total Elements: "+ totalElements);
            System.out.println("Total Pages: "+ totalPages);

     }
//          Applying Sorting
    @Test
     public void findAllSorting(){
         Pageable sortByTitle= PageRequest.of(0,2,Sort.by("title"));
         Pageable sortByCridit= PageRequest.of(0,2,Sort.by("cridit").descending());
         Pageable sortByTitleAndCriditDesc= PageRequest.of(0,2,Sort.by("title").descending().and(Sort.by("cridit").descending()));

        List<Course> courses= courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses: "+courses);
    }

//    Custom Sorting
@Test
    public void printFindByTitleContaining(){
         Pageable firstPageWithFiveRecords= PageRequest.of(0,5);
         List<Course> courses= courseRepository.findByTitleContaining("A", firstPageWithFiveRecords).getContent();
    System.out.println("Courses: "+courses);
}

public void saveCourseWithStudentAndTeacher(){
      Teacher teacher= Teacher.builder()
              .firstName("Hadi")
              .lastName("Rezaie")
              .build();

    Student student= Student.builder()
            .firstName("Ali")
            .lastName("Ahmadi")
            .emailId("ahmadi@gmail.com")
            .build();

         Course course= Course.builder()
              .courseTitle("Java Spring boot")
              .credit(3)
              .teacher(teacher)
              .build();
            course.addStudents(student);
            courseRepository.save(course);
}

}