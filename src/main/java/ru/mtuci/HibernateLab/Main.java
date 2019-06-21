package ru.mtuci.HibernateLab;
import ru.mtuci.HibernateLab.dao.GroupRepository;
import ru.mtuci.HibernateLab.dao.StudentRepository;
import ru.mtuci.HibernateLab.model.Group;
import ru.mtuci.HibernateLab.model.Student;

public class Main {
    public static void main(String[] args) {

        Student student = new Student(null, "Гончаров", "Владислав", "Сергеевич");
        Group group = new Group(null,"Новая");
        GroupRepository groupRepository = new GroupRepository();
        Group createdGroup = groupRepository.save(group);
        student.setGroup(createdGroup);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.save(student);
    }
}