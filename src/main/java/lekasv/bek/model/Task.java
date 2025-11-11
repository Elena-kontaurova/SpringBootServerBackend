package lekasv.bek.model;

import jakarta.persistence.*;
import lekasv.bek.Enum.TaskStatucEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
