package com.glenvasa.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
