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
@RequestMapping("/helloworld")
public class ControllerHello {

    @Autowired
    ServiceHello serviceHello;

    @GetMapping("/")
    public List<HelloEntity> hello(){
       return serviceHello.hello();
    }

    @PostMapping("/add-hello")
    public ResponseEntity<HelloEntity> addHello(@RequestBody HelloEntity addhello){
        HelloEntity  hello = serviceHello.save(addhello);

        return ResponseEntity.ok().body(hello);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable(value ="id") Long id){
        Optional<HelloEntity> findId =serviceHello.findById(id);
        if(findId.isPresent()){
            return "Id da co san trong DB , vui long chon id khac";
        }
         serviceHello.updateHelloById(id,"Hola");
         return "Update successfully";
    }
    @GetMapping("/asc")
    public List<HelloEntity> SortAsc(){
        return serviceHello.findById(1,new PageRequest(0,4, Sort.Direction.ASC,"message"));
    }
    @GetMapping("/{lastname-asc}")
    public List<HelloEntity> SortAscMessage(@PathVariable(value = "lastname-asc") String message ) {
        return serviceHello.SortAscMessage(message);
    }
//    @GetMapping("/lastname-asc")
//    public List<HelloEntity> SortAscMessage() {
//        return serviceHello.SortAscMessage();
//    }
}
