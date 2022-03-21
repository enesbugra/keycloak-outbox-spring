package com.agaoglu.demo.keycloakkafkademo.repository;

import com.agaoglu.demo.keycloakkafkademo.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
