package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> students = new HashMap<>();

    private static Long counter = 0L;

    @Override
    public Student create(Student student) {
        Long currentId = ++counter;
        student.setId(currentId);
        students.put(currentId, student);
        return student;
    }

    @Override
    public Student read(Long studentId) {
        return students.get(studentId);
    }

    @Override
    public Student update(Long studentId, Student student) {
        Student student1 = students.get(studentId);
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        return student1;
    }

    @Override
    public void delete(Long studentId) {
        students.remove(studentId);
    }

    @Override
    public List<Student> getAllByAge(int age) {
        return students.values()
                .stream()
                .filter(it -> it.getAge() == age)
                .toList();
    }
}
