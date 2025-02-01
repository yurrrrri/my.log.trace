package io.myLogTrace.flow.category;

import io.myLogTrace.domain.entity.Category;
import io.myLogTrace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategorySeek {
    //
    private final CategoryService categoryService;

    @GetMapping("")
    public List<Category> findCategories() {
        //
        return categoryService.findEnableCategories();
    }
}
