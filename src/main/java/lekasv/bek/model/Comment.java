package lekasv.bek.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer taskId;
    private Integer createdBy;
    private Integer updatedBy;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
