package com.example.controller;

import com.example.entites.HelloEntity;
import com.example.repository.RepositoryHello;
import com.example.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/helloworld")
public class ControllerHello extends Resource<HelloEntity>{

    @Autowired
    ServiceHello serviceHello;

    @Autowired
    private RepositoryHello repositoryHello;


    @GetMapping("/")
    public ResponseEntity<?> allMessageHello(){
        List<HelloEntity>  allMessageHello = serviceHello.allMessageHello();

        return responseListData(allMessageHello);
    }

    @PostMapping("/add-hello")
    public ResponseEntity<?> addHello(@RequestBody HelloEntity addHello){
        addHello.setupdated(new Date());
        HelloEntity  messageHello = serviceHello.save(addHello);
        if(messageHello == null){
            return responseError("message hello already exits","200");
        }else {
            return responseSuccsess(messageHello,"success");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateId(@PathVariable(value ="id") long id){
        Optional<HelloEntity> findId =serviceHello.findById(id);
        if(findId.isPresent()){
            return responseError("id message hello already exits","200");
        }else{
            serviceHello.updateHelloById(id,"Hola");
            Optional<HelloEntity> findIdUpdated =serviceHello.findById(id);
            findIdUpdated.get().setupdated(new Date());
            serviceHello.save(findIdUpdated.get());
            return responseSuccsess(findIdUpdated.get(),"success");
        }

    }

}
