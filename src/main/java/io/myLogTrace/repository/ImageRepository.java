package io.myLogTrace.repository;

import io.myLogTrace.repository.jpa.ImageJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageJpo, String> {
    //
}
