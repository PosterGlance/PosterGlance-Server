package site.posterglance.poster.domain.poster.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.posterglance.poster.domain.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "posters")
public class Poster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String status;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "display_period")
    private String displayPeriod;

    @Column(name = "display_location")
    private String displayLocation;

    @Builder
    public Poster(User user, String title, String content, String status, String rejectionReason,
                  LocalDateTime createdAt, LocalDateTime expirationDate, String displayPeriod, String displayLocation) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.status = status;
        this.rejectionReason = rejectionReason;
        this.createdAt = createdAt;
        this.expirationDate = expirationDate;
        this.displayPeriod = displayPeriod;
        this.displayLocation = displayLocation;
    }
}