package com.ipl.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.mgmt.model.IPLManagement;
import com.ipl.mgmt.service.IPLManagementService;

/**
 * The IPLManagementController class is a REST controller that handles requests related to IPLManagement operations.
 * It provides endpoints to create, retrieve, update, and delete IPLManagement information.
 */
@RestController
@RequestMapping("/v1/iplmanagement")
public class IPLManagementController {

    @Autowired
    private IPLManagementService iplManagementService;

    
    
    /**
     * Endpoint to save IPLManagement information.
     *
     * @return ResponseEntity representing the response status
     */
    @RequestMapping("/iplmanagement")
    public ResponseEntity saveIplManagement() {
        iplManagementService.saveIplManagementInfo();
        return ResponseEntity.created(null).build();
    }

    
    
    /**
     * Endpoint to retrieve all IPLManagement information.
     *
     * @return List of IPLManagement objects
     */
    @GetMapping
    public List<IPLManagement> getAllIPLManagementInfo() {
        return iplManagementService.getAllIPLManagementInfo();
    }
    
    

    /**
     * Endpoint to retrieve IPLManagement information by its ID.
     *
     * @param id the ID of the IPLManagement
     * @return IPLManagement object
     */
    @GetMapping("/{id}")
    public IPLManagement getIPLManagementInfoById(@PathVariable Long id) {
        return iplManagementService.getIPLManagementInfoById(id);
    }

    
    
    /**
     * Endpoint to create IPLManagement information.
     *
     * @param iplManagement the IPLManagement object to be created
     * @return created IPLManagement object
     */
    @PostMapping
    public IPLManagement createIPLManagementInfo(@RequestBody IPLManagement iplManagement) {
        return iplManagementService.saveIPLManagementInfo(iplManagement);
    }
    
    

    /**
     * Endpoint to update IPLManagement information by its ID.
     *
     * @param id             the ID of the IPLManagement
     * @param iplManagement  the IPLManagement object with updated information
     * @return updated IPLManagement object
     */
    @PutMapping("/{id}")
    public IPLManagement updateIPLManagementInfo(@PathVariable Long id, @RequestBody IPLManagement iplManagement) {
        iplManagement.setId(id);
        return iplManagementService.saveIPLManagementInfo(iplManagement);
    }
    
    

    /**
     * Endpoint to delete IPLManagement information by its ID.
     *
     * @param id the ID of the IPLManagement to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteIPLManagementInfo(@PathVariable Long id) {
        iplManagementService.deleteIPLManagementInfo(id);
    }
}