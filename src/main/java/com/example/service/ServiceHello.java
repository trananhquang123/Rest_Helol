package com.example.service;

import com.example.entites.HelloEntity;
import com.example.repository.RepositoryHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHello{

    @Autowired
    private RepositoryHello  repositoryHello;

    public List<HelloEntity> hello() {
        return repositoryHello.findAll();
    }

    public HelloEntity save(HelloEntity hello){
        return repositoryHello.save(hello);
    }

    public  void updateHelloById(Long id , String message){
       repositoryHello.updateHelloById(id, message);
    }

    public List<HelloEntity> findById(int id, PageRequest message) {
        return repositoryHello.findById(id,message);
    }

    public Optional<HelloEntity> findById(Long id) {
        return repositoryHello.findById(id);
    }

    public List<HelloEntity> SortAscMessage(String message) {
         return repositoryHello.SortAscMessage(message);
    }

//    public List<HelloEntity> SortAscMessage() {
//        return repositoryHello.SortAscMessage();
//    }
}
