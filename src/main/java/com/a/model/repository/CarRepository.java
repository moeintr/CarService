package com.a.model.repository;

import com.a.model.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select o from car o where o.personId=:personId")
    List<Car> selectCarsByPersonId(@Param("personId") Long personId);
}
