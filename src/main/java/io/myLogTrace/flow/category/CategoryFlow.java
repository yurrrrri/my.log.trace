package io.myLogTrace.flow.category;

import io.myLogTrace.command.category.ModifyCategory;
import io.myLogTrace.command.category.ModifyCategoryOrder;
import io.myLogTrace.domain.entity.Category;
import io.myLogTrace.domain.entity.sdo.CategoryCdo;
import io.myLogTrace.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/categories")
@RestController
public class CategoryFlow {
  //
  private final CategoryService categoryService;

  @PostMapping("")
  public Category create(@Valid @RequestBody CategoryCdo cdo) {
    //
    return categoryService.create(cdo);
  }

  @PostMapping("/reorder")
  public List<String> modifyOrder(@RequestBody ModifyCategoryOrder command) {
    //
    return categoryService.modifyOrder(command);
  }

  @PutMapping("")
  public String update(@Valid @RequestBody ModifyCategory command) {
    //
    return categoryService.update(command);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> remove(@PathVariable String id) {
    //
    categoryService.remove(id);
    return ResponseEntity.ok(id);
  }
}
