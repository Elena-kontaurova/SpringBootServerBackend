package lekasv.bek.model;

import jakarta.persistence.*;
import lekasv.bek.enums.TaskStatucEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private TaskStatucEnum status = TaskStatucEnum.NOT_COMPLETED;
    private Integer userId; // ответсвенный
    private Integer parentTaskId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer createdBy;
    private Integer updatedBy;
}
