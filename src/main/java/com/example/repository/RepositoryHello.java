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
import java.util.Optional;

@Repository
public interface RepositoryHello extends JpaRepository<HelloEntity,Long> {

    //Tìm id và sửa lại id
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update HelloEntity set id =:newId WHERE message =:message")
    void updateHelloById(@Param("newId") Long newid ,@Param("message") String message);

    List<HelloEntity> findById(int id, PageRequest message);

    //Query findById đã có trong DB chưa
    @Query(value = "select u from HelloEntity u where u.id = ?1 ")
    Optional<HelloEntity> findById(Long id);


    //Tìm sắp xếp cột message theo kiểu ASC
    @Query(value = "select * From HelloEntity ORDER BY  message =:message ASC ",nativeQuery = true)
    List<HelloEntity> SortAscMessage(@Param("message") String message);

//    @Query(value = "select p From HelloEntity p ORDER BY message ASC ")
//    List<HelloEntity> SortAscMessage();
}
