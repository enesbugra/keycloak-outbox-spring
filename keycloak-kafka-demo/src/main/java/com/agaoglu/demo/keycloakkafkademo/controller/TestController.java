package com.agaoglu.demo.keycloakkafkademo.controller;

import com.agaoglu.demo.keycloakkafkademo.entity.TestEntity;
import com.agaoglu.demo.keycloakkafkademo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PreAuthorize("hasRole('ROLE_CRUD')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> createEntity(@RequestBody String entityName) {
        return testService.createEntity(entityName);
    }

    @PreAuthorize("hasRole('ROLE_CRUD')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEntity(@PathVariable long id ) {
        return testService.updateEntity(id);
    }

    @PreAuthorize("hasRole('ROLE_CRUD')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEntity(@PathVariable long id ) {
        return testService.deleteEntity(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestEntity> getEntity(@PathVariable long id ) {
        return testService.getEntity(id);
    }
}
