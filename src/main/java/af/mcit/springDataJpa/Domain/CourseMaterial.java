package af.mcit.springDataJpa.Domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence",
                    sequenceName = "course_material_sequence",
                    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator ="course_material_sequence" )
   private  Long courseMaterialId;
   private  String url;

//   One to One Relationship
   @OneToOne(cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
   @JoinColumn(
           name = "course_id",
           referencedColumnName = "courseId"
   )
   private Course course;

}
// Check Test Part!!!
