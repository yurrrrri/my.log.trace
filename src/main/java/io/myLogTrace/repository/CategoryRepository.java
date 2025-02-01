package io.myLogTrace.repository;

import io.myLogTrace.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    //
    List<Category> findByRemovedFalseOrderNoAsc();
    boolean existsByName(String name);
}
