package itshendson.springbootsandbox.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Implements Builder pattern
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    // @Length(max = 5, min = 1)
    // @Size(max = 10, min = 1)
    // @Email
    // @Positive is integer positive?
    // @Negative
    // @PositiveOrZero
    // @Pattern
    @NotBlank(message = "Department name required.")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
