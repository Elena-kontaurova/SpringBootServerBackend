package lekasv.bek.model;

import jakarta.persistence.*;
import lekasv.bek.enums.TaskStatucEnum;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private TaskStatucEnum status = TaskStatucEnum.NOT_COMPLETED;
    private Integer userId;
}
