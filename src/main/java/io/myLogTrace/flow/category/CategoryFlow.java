package io.myLogTrace.flow.category;

import io.myLogTrace.command.category.ModifyCategory;
import io.myLogTrace.command.category.RemoveCategory;
import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryFlow {
    //
    private final CategoryService categoryService;

    @PostMapping("")
    public String create(@Valid @RequestBody CategoryCdo cdo) {
        //
        return categoryService.create(cdo);
    }

    @PutMapping("")
    public String update(@Valid @RequestBody ModifyCategory command) {
        //
        return categoryService.update(command);
    }

    @PatchMapping("")
    public ResponseEntity<String> remove(@Valid @RequestBody RemoveCategory command) {
        //
        categoryService.remove(command);
        return ResponseEntity.ok(command.getId());
    }
}
