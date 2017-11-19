package ru.aplana.test.dvdxchange.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Описывает сущность ПОЛЬЗОВАТЕЛЬ.
 * Применяется также для аутентификации пользователя.
 * Для пользователя с администраторскими функциями признак supervisor должен быть установлен в true.
 * В качестве логина предполагается использовать email.
 *
 * @author bedritskiy_mr
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Disk> disks;

    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private Set<TakenItem> takenItems;

    @Email
    private String email;

    @Transient
    private String password;

    private boolean supervisor;
    private String name;

    public User() {
        supervisor = false;
        disks = new HashSet<>();
        takenItems = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSupervisor() {
        return supervisor;
    }

    public void setSupervisor(boolean supervisor) {
        this.supervisor = supervisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Disk> getDisks() {
        return disks;
    }

    public void setDisks(Set<Disk> disks) {
        this.disks = disks;
    }

    public Set<TakenItem> getTakenItems() {
        return takenItems;
    }

    public void setTakenItems(Set<TakenItem> takenItems) {
        this.takenItems = takenItems;
    }
}
