package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist,Integer> {

}