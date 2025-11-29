package lekasv.bek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="task_tag")
public class TaskTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer taskId;
    private Integer tagId;
    private LocalDateTime createdAt;
    private Integer createdBy;
}
