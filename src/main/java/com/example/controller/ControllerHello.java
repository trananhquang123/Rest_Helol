package com.example.controller;

import com.example.entites.HelloEntity;
import com.example.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helloworld")
public class ControllerHello {

    @Autowired
    ServiceHello serviceHello;

    @GetMapping("/")
    public List<HelloEntity> hello(){
       return serviceHello.hello();
    }

    @PostMapping("/add")
    public ResponseEntity<HelloEntity> addHello(@RequestBody HelloEntity addhello){
        HelloEntity  hello = serviceHello.save(addhello);

        return ResponseEntity.ok().body(hello);
    }
    @PutMapping("/update/{id}")
    public HelloEntity updateId(@PathVariable(value ="id") long id){
        Optional<HelloEntity> findId =serviceHello.findById(id);
        if(findId.isPresent()){
            return null;
        }
        serviceHello.updateHelloById(id,"Hola");
        Optional<HelloEntity> findIdUpdated =serviceHello.findById(id);

         return findIdUpdated.get();
    }

}
