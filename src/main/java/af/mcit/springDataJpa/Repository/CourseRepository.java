package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

//    Custom Sorting
    Page<Course> findByTitleContaining(String title, Pageable pageable);

}
