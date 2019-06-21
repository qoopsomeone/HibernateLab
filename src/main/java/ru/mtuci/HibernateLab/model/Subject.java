package ru.mtuci.HibernateLab.model;
import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Subject.GET_ALL, query = "SELECT s FROM Subject s")
})
@Entity
@Table(name = "subjects")

public class Subject extends ru.mtuci.HibernateLab.model.BaseEntity {
    public static final String GET_ALL = "Subject.getAll";
    private String name;
    private String shortname;
    private Integer hours;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "groups_subjects",
            joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_group")
    )
    private List<Group> groups;
    public Subject() {}
    public Subject(Long id, String name, String shortname, Integer hours) {
        super(id); this.name = name; this.shortname = shortname; this.hours = hours;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortname() {
        return shortname;
    }
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public Integer getHours() {
        return hours;
    }
    public void setHours(Integer hours) {
        this.hours = hours;
    }
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    @Override
    public String toString() {
        return "Subject{" + "id='" + getId() + '\'' + "name='" + name + '\'' +
                ", shortname='" + shortname + '\'' + ", hours='" + hours + '\'' + '}';
    }
}