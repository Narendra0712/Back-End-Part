package com.mobigictest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobigictest.pojo.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
