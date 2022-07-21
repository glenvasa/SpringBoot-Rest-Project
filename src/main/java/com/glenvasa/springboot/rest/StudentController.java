package com.glenvasa.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// @RestController uses @ResponseBody annotation which converts return value (Java object) to HTTP response body
// (e.g. JSON) based on content-type in request HTTP header. Spring default is JSON
// Converter is MappingJackson2HttpMessageConverter
@RestController
public class StudentController {

    // REST API that returns Java bean/object to client
    // http://localhost:8080/student
    // to specify XML conversion for return value can use
    // @GetMapping(path = "/student", produces=MediaType.APPLICATION_XML_VALUE)
    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Glen", "Vasa");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ethan", "Vasa"));
        students.add(new Student("Nathan", "Vasa"));
        students.add(new Student("Denilse", "Goncalves"));
        students.add(new Student("Glen", "Vasa"));
        return students;
    }

    //http://localhost:8080/student/ethan/vasa
    // add URI template variables
    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable String firstName, @PathVariable String lastName) {
        return new Student(firstName, lastName);
    }


}
