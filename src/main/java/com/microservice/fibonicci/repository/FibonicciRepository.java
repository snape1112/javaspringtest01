package com.microservice.fibonicci.repository;

import com.microservice.fibonicci.model.Fibonicci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface FibonicciRepository extends CrudRepository<Fibonicci, Long> {
    @Query(value = "select o.id, o.number, o.frequent, o.result from Fiboniccis o where o.number = :number", nativeQuery = true )
    public List<Fibonicci> findByNumber(int number);
}