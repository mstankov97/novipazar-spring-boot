package com.example.pazar43.repository;

import com.example.pazar43.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
