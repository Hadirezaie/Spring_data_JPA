package af.mcit.springDataJpa.Repository;

import af.mcit.springDataJpa.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long > {
public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
//    JPQL Query
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);
//Native Query
@Query(value = "SELECT * FROM tbl_student s where s.email_address=?1",
        nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);
// Native Named parameter
    @Query(value = "SELECT * FROM tbl_student s where s.email_address= :emailId",
            nativeQuery = true)
    Student printStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
//Update data
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2",
    nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId );
}
