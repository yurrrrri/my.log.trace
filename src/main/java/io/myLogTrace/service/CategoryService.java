package io.myLogTrace.service;

import io.myLogTrace.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    //
    private final CategoryRepository categoryRepository;
}
