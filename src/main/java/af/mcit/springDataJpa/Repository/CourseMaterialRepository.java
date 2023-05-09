package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.CourseMaterial;
import af.mcit.springDataJpa.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
