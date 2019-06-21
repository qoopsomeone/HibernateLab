package ru.mtuci.HibernateLab.model;
import javax.persistence.*;

@NamedQueries(
        {@NamedQuery(name = Student.GET_ALL, query = "SELECT s FROM Student s")
        })

@Entity
@Table(name = "students") //
public class Student extends BaseEntity{
    public static final String GET_ALL = "Student.getAll";
    private String lastname;
    private String firstname;
    private String patronym;

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name = "id_group", nullable = false)

    private Group group;
    public Student() {}
    public Student(Long id, String lastname, String firstname, String patronym) {
        super(id); this.lastname = lastname;
        this.firstname = firstname;
        this.patronym = patronym;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getPatronym() {
        return patronym;
    }
    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{"+"id='" + getId() + '\''+"  lastname='"
                +lastname+'\''+", firstname='"+firstname+'\''+", patronym='"+patronym+'\''+'}';}
}
