package com.DataJpa.Practice.repository;

import com.DataJpa.Practice.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial , Long> {
}
