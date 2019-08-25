package com.example.repository;

import com.example.entites.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RepositoryHello extends JpaRepository<HelloEntity,Long> {

    //Tìm id và sửa lại id
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update HelloEntity set id =:newId WHERE message =:message")
    void updateHelloById(@Param("newId") long newid ,@Param("message") String message);


    //Query findById đã có trong DB chưa
    @Query(value = "select u from HelloEntity u where u.id = ?1 ")
    Optional<HelloEntity> findById(long id);


}
