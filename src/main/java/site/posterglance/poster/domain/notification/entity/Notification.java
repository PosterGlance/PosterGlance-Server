package site.posterglance.poster.domain.notification.entity;

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
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "poster_id")
    private Poster poster;

    @Column(nullable = false)
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Notification(User user, Poster poster, String message, LocalDateTime createdAt) {
        this.user = user;
        this.poster = poster;
        this.message = message;
        this.createdAt = createdAt;
    }
}