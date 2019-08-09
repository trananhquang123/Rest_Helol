package com.example.repository;

import com.example.entites.HelloEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RepositoryHello extends JpaRepository<HelloEntity,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update HelloEntity set id =:newId WHERE message1 =:message1")
    void updateHelloById(@Param("newId") int id ,@Param("message1") String message);

    List<HelloEntity> findById(int id, PageRequest message);

    @Query(value = "select p From HelloEntity p ORDER BY message ASC ")
    List<HelloEntity> findByLastName();
}
