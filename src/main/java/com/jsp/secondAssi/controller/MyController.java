package com.jsp.secondAssi.controller;

import com.jsp.secondAssi.Student;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    //Add two number
    //api testing - http://localhost:8080/add?num1=10&num2=20
    @GetMapping("/add")
    public int addNumber(@RequestParam int num1,@RequestParam int num2){

        return num1+num2;
    }

    //Multiply Two number
    //api testing - http://localhost:8080/multiply?num1=10&num2=20
    @GetMapping("/multiply")
    public int mulNumber(@RequestParam int num1, @RequestParam int num2){

        return num1*num2;
    }

    //Average of Multiple number
    //api testing - http://localhost:8080/average?num=10&num=20&num=30&num=40
    @GetMapping("/average")
    public int average(@RequestParam ("num") List<Integer> num1){
        int sum = 0;
        for(int i: num1){
            sum = sum+i;
        }
        return sum/num1.size();
    }

    //Get - object
    //api testing - http://localhost:8080/studentGet
    @GetMapping("/studentGet")
    public Student studentGet(){

        return new Student();
    }

    //Post - object
    //api testing - http://localhost:8080/studentPost
    @PostMapping("/studentPost")
    public Student studentPost(){
        return new Student();
    }

    //Put - object
    //api testing - http://localhost:8080/studentPut
    @PutMapping("/studentPut")
    public Student studentPut(){
        return new Student();
    }

    //Patch - object
    //api testing - http://localhost:8080/studentPatch
    @PatchMapping("/studentPatch")
    public Student studentPatch(){

        return new Student();
    }

    //Delete - object
    //api testing - http://localhost:8080/studentDelete
    @DeleteMapping("/studentDelete")
    public Student studentDelete(){
        return new Student();
    }

    //Get - List
    //api testing - http://localhost:8080/studentGetList
    @GetMapping("/studentGetList")
    public List<Student> studentGetList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Post - List
    //api testing - http://localhost:8080/studentPostList
    @PostMapping("/studentPostList")
    public List<Student> studentPostList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Put - List
    //api testing - http://localhost:8080/studentPutList
    @PutMapping("/studentPutList")
    public List<Student> studentPutList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Patch - List
    //api testing - http://localhost:8080/studentPatchList
    @PatchMapping("/studentPatchList")
    public List<Student> studentPatchList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Delete - List
    //api testing - http://localhost:8080/studentDeleteList
    @DeleteMapping("/studentDeleteList")
    public List<Student> studentDeleteList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Filter - Course
    //api testing - http://localhost:8080/studentFilCouGet
    @GetMapping("/studentFilCouGet")
    public List<Student> studentFilterCourse(){
        List<Student> l = new ArrayList<>();
        l.add(new Student("Aryan","Java"));
        l.add(new Student("Shubham","Spring"));
        l.add(new Student("Rahul","Java"));
        List<Student> result = new ArrayList<>();
        for(Student s: l){
            if("Java".equals(s.getCourse())){
                result.add(s);
            }
        }
        return result;
    }

    //Multiple Filter - students
    //api testing - http://localhost:8080/studentMultiFilGet
    @GetMapping("/studentMultiFilGet")
    public List<Student> studentMultiFilter(){
        List<Student> l = new ArrayList<>();
        l.add(new Student("Aryan","Java"));
        l.add(new Student("Shubham","Spring"));
        l.add(new Student("Rahul","Java"));
        List<Student> result = new ArrayList<>();
        for(Student s: l){
            if("Spring".equals(s.getCourse()) && "Shubham".equals(s.getName())){
                result.add(s);
            }
        }
        return result;
    }

    //cookies
    //api testing - http://localhost:8080/avg?n=10&n=20&n=30
    @GetMapping("/avg")
    public int mul(@RequestParam List<Integer> n, HttpServletResponse resp){
        Cookie cookie = new Cookie("a","10");
        Cookie cookie1 = new Cookie("b","10");
        Cookie cookie2= new Cookie("c","10");
        Cookie cookie3= new Cookie("d","10");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        int sum = 0;
        for(int i: n){
            sum = sum+i;
        }
        return sum/n.size();
    }

    //reading cookie
    //api testing - http://localhost:8080/cookie
    @GetMapping("/cookie")
    public String cookie(@CookieValue String a){
        return a;
    }

    //using - PathVariable
    //api testing - http://localhost:8080/api/20/pr?id=10
    @GetMapping("/api/{num}/pr")
    public int pv(@RequestParam int id,@PathVariable int num){
        return id+num;
    }

}
