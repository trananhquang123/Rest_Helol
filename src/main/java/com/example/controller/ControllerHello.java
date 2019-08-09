package com.example.controller;

import com.example.entites.HelloEntity;
import com.example.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ControllerHello {

    @Autowired
    ServiceHello serviceHello;

    @GetMapping("/helloworld")
    public List<HelloEntity> hello1( ){
       return serviceHello.hello();
    }

    @PostMapping("/add-hello")
    public ResponseEntity<HelloEntity> addHello(@RequestBody HelloEntity addhello){
        HelloEntity  hello = serviceHello.save(addhello);

        return ResponseEntity.ok().body(hello);
    }
    @PutMapping("/update")
    public String update(){
         serviceHello.updateHello(8,"Hola");
         return "Update successfully";
    }
    @GetMapping("/asc")
    public List<HelloEntity> SortAsc(){
        return serviceHello.findById(1,new PageRequest(0,4, Sort.Direction.ASC,"message"));
    }
    @GetMapping("/lastname-asc")
    public List<HelloEntity> getLastName(){
        return serviceHello.findLastName();
    }
}
