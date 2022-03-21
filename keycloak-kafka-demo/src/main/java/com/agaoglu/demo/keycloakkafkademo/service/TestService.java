package com.agaoglu.demo.keycloakkafkademo.service;

import com.agaoglu.demo.keycloakkafkademo.entity.TestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface TestService {

    ResponseEntity<String> createEntity(@RequestParam String entityName);

    ResponseEntity<String> updateEntity(@PathVariable long id );

    ResponseEntity<String> deleteEntity(@PathVariable long id );

    ResponseEntity<TestEntity> getEntity(@PathVariable long id );
}
