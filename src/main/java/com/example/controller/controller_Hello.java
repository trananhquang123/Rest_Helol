package com.example.controller;

import com.example.entitys.hello_Entity;
import com.example.service.service_Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class controller_Hello {

    @Autowired
    service_Hello serviceHello;

    @GetMapping("/helloworld")
    public List<hello_Entity> hello1( ){
       return serviceHello.hello();
    }

    @PostMapping("/add-hello")
    public ResponseEntity<hello_Entity> addHello(@RequestBody hello_Entity addhello){
        hello_Entity  hello = serviceHello.save(addhello);

        return ResponseEntity.ok().body(hello);
    }
    @PutMapping("/update")
    public String update(){
         serviceHello.updateHello(8,"Hola");
         return "Update successfully";
    }
    @GetMapping("/ASC")
    public List<hello_Entity> SortAsc(){
        return serviceHello.findById(1,new PageRequest(0,4, Sort.Direction.ASC,"message"));
    }
    @GetMapping("/lastname")
    public List<hello_Entity> getLastName(){
        return serviceHello.findLastName();
    }
}
