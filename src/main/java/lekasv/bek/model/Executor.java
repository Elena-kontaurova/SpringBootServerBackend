package lekasv.bek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name="executors")
public class Executor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer taskId;
    private Integer executorId;
    private LocalDateTime createdAt; // когда
    private Integer createdBy; // кто создал
}
