package com.tamnt.personal_finance_tracker.repository;

import com.tamnt.personal_finance_tracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //(0=Chi phí, 1=Thu nhập)
    List<Category> findByType(int type);
}
