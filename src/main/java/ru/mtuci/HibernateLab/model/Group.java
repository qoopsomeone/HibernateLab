package ru.mtuci.HibernateLab.model;
import javax.persistence.*;
import java.util.List;

@NamedQueries({@NamedQuery(name = Group.GET_ALL, query = "SELECT g FROM Group g")})
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    public static final String GET_ALL = "Group.getAll";
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Student> students;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "groups_subjects",
            joinColumns = @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private List<Subject> subjects;
    public Group() {}
    public Group(Long id, String name) {
        super(id); this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString(){
        return "Group{" + "id='" + getId() + '\'' + "name='" + name + '\'' + '}';
    }
}