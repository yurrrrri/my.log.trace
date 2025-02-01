package io.myLogTrace.service;

import io.myLogTrace.command.category.ModifyCategory;
import io.myLogTrace.command.category.RemoveCategory;
import io.myLogTrace.common.exception.DuplicateDataException;
import io.myLogTrace.domain.entity.Category;
import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.repository.CategoryRepository;
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

    public List<Category> findEnableCategories() {
        //
        return categoryRepository.findByRemovedFalseOrderNoAsc();
    }

    public String create(CategoryCdo cdo) {
        //
        if (categoryRepository.existsByName(cdo.getName())) {
            throw new DuplicateDataException(DATA_ALREADY_EXISTS.name());
        }
        Category entity = Category.create(cdo);
        Category category = categoryRepository.save(entity);
        return category.getId();
    }

    public String update(ModifyCategory command) {
        //
        Category category = this.getCategory(command.getId());
        BeanUtils.copyProperties(command, category);
        categoryRepository.save(category);
        return command.getId();
    }

    public void remove(RemoveCategory command) {
        //
        Category category = this.getCategory(command.getId());
        if (!category.isRemoved()) {
            category.setRemovedTrue();
            categoryRepository.save(category);
        }
    }

    private Category getCategory(String id) {
        //
        Optional<Category> opt = categoryRepository.findById(id);
        if (opt.isEmpty()) throw new EntityNotFoundException(DATA_NOT_FOUND.name());
        return opt.get();
    }
}
