package ru.aplana.test.dvdxchange.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Описывает сущность ПОЛЬЗОВАТЕЛЬ.
 * Применяется для аутентификации пользователя.
 * Для пользователя с администраторскими привилегиями признак supervisor должен быть установлен в true.
 * В качестве логина предполагается использовать email.
 *
 * @author bedritskiy_mr
 */
@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String username;
    private String email;
    private String password;
    private String displayName;
    private boolean supervisor = false;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Disk> disks = new HashSet<>();
    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private Set<TakenItem> takenItems = new HashSet<>();

    public User() {
    }

    public User(final String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (supervisor) ? Arrays.asList(Role.ADMIN, Role.USER) : Arrays.asList(Role.USER);
    }

    public enum Role implements GrantedAuthority {
        USER {
            @Override
            public String getAuthority() {
                return "USER";
            }
        }, ADMIN {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        };

        @Override
        public abstract String getAuthority();
    }
}
