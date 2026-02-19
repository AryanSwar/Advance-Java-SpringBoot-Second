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
    @GetMapping("/add")
    public int addNumber(@RequestParam int num1,@RequestParam int num2){

        return num1+num2;
    }
    //Multiply Two number
    @GetMapping("/multiply")
    public int mulNumber(@RequestParam int num1, @RequestParam int num2){

        return num1*num2;
    }

    //Average of Multiple number
    @GetMapping("/average")
    public int average(@RequestParam ("num") List<Integer> num1){
        int sum = 0;
        for(int i: num1){
            sum = sum+i;
        }
        return sum/num1.size();
    }

    //Get - object
    @GetMapping("/studentGet")
    public Student studentGet(){

        return new Student();
    }

    //Post - object
    @PostMapping("/studentPost")
    public Student studentPost(){
        return new Student();
    }

    //Put - object
    @PutMapping("/studentPut")
    public Student studentPut(){
        return new Student();
    }

    //Patch - object
    @PatchMapping("/studentPatch")
    public Student studentPatch(){

        return new Student();
    }

    //Delete - object
    @DeleteMapping("/studentDelete")
    public Student studentDelete(){
        return new Student();
    }
    //Get - List
    @GetMapping("/studentGetList")
    public List<Student> studentGetList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Post - List
    @PostMapping("/studentPostList")
    public List<Student> studentPostList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Put - List
    @PutMapping("/studentPutList")
    public List<Student> studentPutList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Patch - List
    @PatchMapping("/studentPatchList")
    public List<Student> studentPatchList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Delete - List
    @DeleteMapping("/studentDeleteList")
    public List<Student> studentDeleteList(){
        List<Student> l = new ArrayList<>();
        return l;
    }

    //Filter - Course
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

    @GetMapping("/cookie")
    public String cookie(@CookieValue String a){
        return a;
    }
}
