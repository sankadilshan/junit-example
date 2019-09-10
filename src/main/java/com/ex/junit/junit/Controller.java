package com.ex.junit.junit;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cnt")
public class Controller {
   @GetMapping("/hello")
    public String hello(){
       return "hello world!";
   }

   @GetMapping("/sum")
    public int sum(int i, int j){
       return i+j;
   }

   @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student student(){
      return new Student("IN3200" ,"sanka");
   }
         public class Student{
          private String id;
          private String name;

             public Student(String id, String name) {
                 this.id = id;
                 this.name = name;
             }

             public String getId() {
                 return id;
             }

             public void setId(String id) {
                 this.id = id;
             }

             public String getName() {
                 return name;
             }

             public void setName(String name) {
                 this.name = name;
             }
         }

}
