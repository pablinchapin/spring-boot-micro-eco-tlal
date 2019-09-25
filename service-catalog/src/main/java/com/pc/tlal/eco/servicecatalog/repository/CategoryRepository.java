package com.pc.tlal.eco.servicecatalog.repository;

import com.pc.tlal.eco.servicecatalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
