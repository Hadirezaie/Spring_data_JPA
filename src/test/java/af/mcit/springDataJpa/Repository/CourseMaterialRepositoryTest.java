package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Course;
import af.mcit.springDataJpa.Domain.CourseMaterial;
import af.mcit.springDataJpa.Domain.Guardian;
import af.mcit.springDataJpa.Domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
private  CourseMaterialRepository courseMaterialRepository;
    @Test
    public void SaveCourseMaterial(){
   Course course= Course.builder()
           .courseTitle("Software Enginnering")
           .credit(4)
           .build();
    CourseMaterial courseMaterial= CourseMaterial.builder()
            .url("www.google.com")
            .course(course)
            .build();
    courseMaterialRepository.save(courseMaterial);
}
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=
                courseMaterialRepository.findAll();
        System.out.println("Courser materials:"+courseMaterials);
    }





}