package io.myLogTrace.service;

import io.myLogTrace.command.ModifyCategory;
import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Category;
import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.repository.CategoryRepository;
import io.myLogTrace.repository.jpa.CategoryJpo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static io.myLogTrace.common.exception.LogExceptionCode.DATA_ALREADY_EXISTS;
import static io.myLogTrace.common.exception.LogExceptionCode.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    //
    private final CategoryRepository categoryRepository;

    public Category findCategory(String id) {
        //
        return this.getCategory(id);
    }

    public List<Category> findEnableCategories() {
        //
        return Category.toDomains(categoryRepository.findByRemovedFalseOrderByOrderNoAsc());
    }

    public String create(CategoryCdo cdo) {
        //
        if (categoryRepository.existsByName(cdo.getName())) {
            throw new DuplicateDataException(DATA_ALREADY_EXISTS.name());
        }
        Category entity = Category.create(cdo);
        CategoryJpo categoryJpo = categoryRepository.save(entity.toJpo());
        return categoryJpo.getId();
    }

    public String update(ModifyCategory command) {
        //
        Category Category = this.getCategory(command.getId());
        BeanUtils.copyProperties(command, Category);
        categoryRepository.save(Category.toJpo());
        return command.getId();
    }

    public void remove(String id) {
        //
        Category Category = this.getCategory(id);
        if (!Category.isRemoved()) {
            Category.setRemovedTrue();
            categoryRepository.save(Category.toJpo());
        }
    }

    private Category getCategory(String id) {
        //
        Optional<CategoryJpo> opt = categoryRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return Category.toDomain(opt.get());
    }
}
