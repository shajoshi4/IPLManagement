package com.ipl.mgmt.controller;

import com.ipl.mgmt.model.IPLManagement;
import com.ipl.mgmt.service.IPLManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The IPLManagementController class is a REST controller that handles requests related to IPLManagement operations.
 * It provides endpoints to create, retrieve, update, and delete IPLManagement information.
 */
@RestController
@RequestMapping("/v1/iplmanagement")
@Slf4j
public class IPLManagementController {

    @Autowired
    private IPLManagementService iplManagementService;

    /**
     * Endpoint to save IPLManagement information.
     *
     * @return ResponseEntity representing the response status
     */
    @PostMapping("/iplmanagement")
    public ResponseEntity<?> saveIplManagement() {
        iplManagementService.saveIplManagementInfo();
        return ResponseEntity.created(null).build();
    }

    /**
     * Endpoint to retrieve all IPLManagement information.
     *
     * @return List of IPLManagement objects
     */
    @GetMapping
    public ResponseEntity<List<IPLManagement>> getAllIPLManagementInfo() {
        log.info("Retrieving all IPLManagement information");
        return ResponseEntity.ok(iplManagementService.getAllIPLManagementInfo());
    }

    /**
     * Endpoint to retrieve IPLManagement information by its ID.
     *
     * @param id the ID of the IPLManagement
     * @return ResponseEntity containing IPLManagement object
     */
    @GetMapping("/{id}")
    public ResponseEntity<IPLManagement> getIPLManagementInfoById(@PathVariable Long id) {
        log.info("Retrieving IPLManagement information by ID: {}", id);
        IPLManagement iplManagement = iplManagementService.getIPLManagementInfoById(id);
        if (iplManagement != null) {
            return ResponseEntity.ok(iplManagement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to create IPLManagement information.
     *
     * @param iplManagement the IPLManagement object to be created
     * @return ResponseEntity containing created IPLManagement object
     */
    @PostMapping
    public ResponseEntity<IPLManagement> createIPLManagementInfo(@RequestBody IPLManagement iplManagement) {
        log.info("Creating IPLManagement information: {}", iplManagement);
        IPLManagement createdIPLManagement = iplManagementService.saveIPLManagementInfo(iplManagement);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIPLManagement);
    }

    /**
     * Endpoint to update IPLManagement information by its ID.
     *
     * @param id            the ID of the IPLManagement
     * @param iplManagement the IPLManagement object with updated information
     * @return ResponseEntity containing updated IPLManagement object
     */
    @PutMapping("/{id}")
    public ResponseEntity<IPLManagement> updateIPLManagementInfo(@PathVariable Long id, @RequestBody IPLManagement iplManagement) {
        log.info("Updating IPLManagement information with ID: {}", id);
        IPLManagement existingIPLManagement = iplManagementService.getIPLManagementInfoById(id);
        if (existingIPLManagement != null) {
            iplManagement.setId(id);
            IPLManagement updatedIPLManagement = iplManagementService.saveIPLManagementInfo(iplManagement);
            return ResponseEntity.ok(updatedIPLManagement);
        } else {
            log.warn("IPLManagement not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to delete IPLManagement information by its ID.
     *
     * @param id the ID of the IPLManagement to be deleted
     * @return ResponseEntity representing the response status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIPLManagementInfo(@PathVariable Long id) {
        log.info("Deleting IPLManagement information with ID: {}", id);
        try {
            iplManagementService.deleteIPLManagementInfo(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.warn("Failed to delete IPLManagement with ID: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }
}
