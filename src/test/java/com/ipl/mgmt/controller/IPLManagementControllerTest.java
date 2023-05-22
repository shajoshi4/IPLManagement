package com.ipl.mgmt.controller;

import com.ipl.mgmt.model.IPLManagement;
import com.ipl.mgmt.service.IPLManagementService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IPLManagementControllerTest {

    @Mock
    private IPLManagementService iplManagementService;

    @InjectMocks
    private IPLManagementController iplManagementController;

    @Test
    void testSaveIPLManagement() {
        ResponseEntity<?> response = iplManagementController.saveIplManagement();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(iplManagementService, times(1)).saveIplManagementInfo();
    }

    @Test
    void testGetAllIPLManagementInfo() {
        List<IPLManagement> iplManagementList = new ArrayList<>();
        iplManagementList.add(new IPLManagement(1L, "IPL Management 1", null, null, null));
        iplManagementList.add(new IPLManagement(2L, "IPL Management 2", null, null, null));

        when(iplManagementService.getAllIPLManagementInfo()).thenReturn(iplManagementList);

        ResponseEntity<List<IPLManagement>> response = iplManagementController.getAllIPLManagementInfo();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(iplManagementList, response.getBody());
        verify(iplManagementService, times(1)).getAllIPLManagementInfo();
    }

    @Test
    void testGetIPLManagementInfoById() {
        Long id = 1L;
        IPLManagement iplManagement = new IPLManagement(id, "IPL Management", null, null, null);

        when(iplManagementService.getIPLManagementInfoById(id)).thenReturn(iplManagement);

        ResponseEntity<IPLManagement> response = iplManagementController.getIPLManagementInfoById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(iplManagement, response.getBody());
        verify(iplManagementService, times(1)).getIPLManagementInfoById(id);
    }


    @Test
    void testCreateIPLManagementInfo() {
        IPLManagement iplManagement = new IPLManagement(1L, "IPL Management", null, null, null);

        when(iplManagementService.saveIPLManagementInfo(iplManagement)).thenReturn(iplManagement);

        ResponseEntity<IPLManagement> response = iplManagementController.createIPLManagementInfo(iplManagement);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(iplManagement, response.getBody());
        verify(iplManagementService, times(1)).saveIPLManagementInfo(iplManagement);
    }

    @Test
    void testDeleteIPLManagementInfo() {
        Long id = 1L;

        ResponseEntity<Void> response = iplManagementController.deleteIPLManagementInfo(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(iplManagementService, times(1)).deleteIPLManagementInfo(id);
    }

    @Test
    void testDeleteIPLManagementInfo_NotFound() {
        Long id = 1L;

        doThrow(IllegalArgumentException.class).when(iplManagementService).deleteIPLManagementInfo(id);

        ResponseEntity<Void> response = iplManagementController.deleteIPLManagementInfo(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(iplManagementService, times(1)).deleteIPLManagementInfo(id);
    }
}
