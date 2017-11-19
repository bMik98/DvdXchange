package ru.aplana.test.dvdxchange.domain;

import javax.persistence.*;

@Entity
@Table(name = "disks")
public class Disk {
    @Id
    @Column(name = "disk_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String title;

    public Disk(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
