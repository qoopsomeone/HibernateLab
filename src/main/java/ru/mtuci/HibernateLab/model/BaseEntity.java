package ru.mtuci.HibernateLab.model;
import org.hibernate.Hibernate;
import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public class BaseEntity implements HasId{

        @Id
    @SequenceGenerator(name = "sequence123", sequenceName = "sequence123", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence123")
    @Access(value = AccessType.PROPERTY)

    private Long id;
    public BaseEntity() {}
    public BaseEntity(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true; }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {return false;}
        BaseEntity that = (BaseEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", getClass().getName(),getId());
    }
}