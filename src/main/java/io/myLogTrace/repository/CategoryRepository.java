package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.CategoryJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryJpo, String> {
  //
  List<CategoryJpo> findByOrderByOrderNoAsc();
  boolean existsByName(String name);
}
