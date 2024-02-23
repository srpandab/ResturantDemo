package com.resturantDemo.repository;

import com.resturantDemo.entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResturantRepository extends JpaRepository<Resturant,Long> {
    @Query("from Resturant where resName=:name")
    List<Resturant> findName(String name);
}
