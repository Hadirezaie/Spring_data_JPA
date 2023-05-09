package af.mcit.springDataJpa.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique", columnNames = "email_address"))
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
                        sequenceName = "student_dequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private  Long studentId;
    private  String firstName;
    private  String lastName;
    @Column(name = "email_address",
        nullable = false)
    private  String emailId;
    @Embedded
    private Guardian guardian;

}
