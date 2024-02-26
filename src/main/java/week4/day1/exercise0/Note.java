package week4.day1.exercise0;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String note;
    private String createdBy;
    private LocalDate dateCreated;

    @ManyToOne
    private Person person;

    public Note(String note, String createdBy, LocalDate dateCreated) {
        this.note = note;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }
}
