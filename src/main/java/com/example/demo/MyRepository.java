package com.example.demo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MyRepository extends CrudRepository<MyEntity, Long> {

    MyEntity findByBusinessKey(String businessKey);
    // List<MyEntity> findByField1(String field1);
    Optional<MyEntity> findByBusinessKeyAndField1AndField2AndField3(String businessKey, String field1, String field2, String field3);
    @Query("select * FROM MY_ENTITY M WHERE M.BUSINESS_KEY = :businessKey")
    Optional<MyEntity> findByBusinessKeyQuery(@Param("businessKey") String businessKey);

}

