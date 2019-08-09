package com.example.repository;

import com.example.entitys.hello_Entity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface repository_Hello extends JpaRepository<hello_Entity,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update hello_Entity set id =:newId WHERE message1 =:message1")
    void updateHelloById(@Param("newId") int id ,@Param("message1") String message);

    List<hello_Entity> findById(int id, PageRequest message);

    @Query(value = "select p From hello_Entity p ORDER BY message ASC ")
    List<hello_Entity> findByLastName();
}
