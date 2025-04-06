package com.DataJpa.Practice.repository;

import com.DataJpa.Practice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course , Long> {
}
