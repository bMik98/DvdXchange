package ru.aplana.test.dvdxchange.domain;

import javax.persistence.*;

@Entity
@Table(name = "taken_items")
public class TakenItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Disk disk;

    private User holder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }
}
