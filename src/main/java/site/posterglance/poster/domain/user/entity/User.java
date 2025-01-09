package site.posterglance.poster.domain.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.posterglance.poster.domain.adminlog.entity.AdminLog;
import site.posterglance.poster.domain.poster.entity.Poster;
import site.posterglance.poster.domain.notification.entity.Notification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false, length = 50)
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Role cannot be blank")
    @Column(nullable = false)
    private String role;  // "admin" 또는 "user"

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Poster> posters = new ArrayList<>();  // 사용자가 작성한 포스터

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();  // 사용자가 받은 알림

    @OneToMany(mappedBy = "admin")
    private List<AdminLog> adminLogs = new ArrayList<>();  // 관리자의 활동 로그

    @Builder
    public User(String username, String password, String role, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }
}