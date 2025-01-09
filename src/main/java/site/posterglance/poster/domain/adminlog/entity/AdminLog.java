package site.posterglance.poster.domain.adminlog.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.posterglance.poster.domain.poster.entity.Poster;
import site.posterglance.poster.domain.user.entity.User;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "admin_logs")
public class AdminLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @ManyToOne
    @JoinColumn(name = "poster_id", nullable = false)
    private Poster poster;

    @Column(nullable = false)
    private String action;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Builder
    public AdminLog(User admin, Poster poster, String action, LocalDateTime timestamp) {
        this.admin = admin;
        this.poster = poster;
        this.action = action;
        this.timestamp = timestamp;
    }
}