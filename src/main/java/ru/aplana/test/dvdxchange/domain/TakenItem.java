package ru.aplana.test.dvdxchange.domain;

import javax.persistence.*;

@Entity
@Table(name = "taken_items")
public class TakenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "disk_id")
    private Disk disk;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User holder;

    public TakenItem() {
    }

    public TakenItem(Disk disk, User holder) {
        this.disk = disk;
        this.holder = holder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
