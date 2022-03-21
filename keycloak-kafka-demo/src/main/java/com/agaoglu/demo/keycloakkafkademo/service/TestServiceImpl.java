package com.agaoglu.demo.keycloakkafkademo.service;

import com.agaoglu.demo.keycloakkafkademo.entity.TestEntity;
import com.agaoglu.demo.keycloakkafkademo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public ResponseEntity<String> createEntity(String entityName) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(entityName);
        testRepository.save(testEntity);
        return ResponseEntity.ok("Entity created");
    }

    @Override
    public ResponseEntity<String> updateEntity(long id) {
        TestEntity testEntity = testRepository.findById(id).get();
        testEntity.setName("updatedName");
        testRepository.save(testEntity);
        return ResponseEntity.ok("Entity updated");
    }

    @Override
    public ResponseEntity<String> deleteEntity(long id) {
        testRepository.deleteById(id);
        return ResponseEntity.ok("Entity deleted");
    }

    @Override
    public ResponseEntity<TestEntity> getEntity(long id) {
        return new ResponseEntity<>(testRepository.findById(id).get(), HttpStatus.OK);
    }
}
