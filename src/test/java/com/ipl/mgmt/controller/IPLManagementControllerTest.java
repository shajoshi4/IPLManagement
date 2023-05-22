package com.ipl.mgmt.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ipl.mgmt.controller.IPLManagementController;
import com.ipl.mgmt.model.IPLManagement;
import com.ipl.mgmt.service.IPLManagementService;



@ExtendWith(MockitoExtension.class)
public class IPLManagementControllerTest {

    @Mock
    private IPLManagementService iplManagementService;

    @InjectMocks
    private IPLManagementController iplManagementController;

    @Test
    public void testSaveIplManagement() {
        ResponseEntity response = iplManagementController.saveIplManagement();
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(iplManagementService, times(1)).saveIplManagementInfo();
    }

    @Test
    public void testGetAllIPLManagementInfo() {
        List<IPLManagement> iplManagementList = new ArrayList();
        iplManagementList.add(new IPLManagement());
        iplManagementList.add(new IPLManagement());
        when(iplManagementService.getAllIPLManagementInfo()).thenReturn(iplManagementList);

        List<IPLManagement> result = iplManagementController.getAllIPLManagementInfo();

        assertEquals(2, result.size());
        verify(iplManagementService, times(1)).getAllIPLManagementInfo();
    }

    @Test
    public void testGetIPLManagementInfoById() {
        Long id = 1L;
        IPLManagement iplManagement = new IPLManagement();
        when(iplManagementService.getIPLManagementInfoById(id)).thenReturn(iplManagement);

        IPLManagement result = iplManagementController.getIPLManagementInfoById(id);

        assertNotNull(result);
        assertEquals(iplManagement, result);
        verify(iplManagementService, times(1)).getIPLManagementInfoById(id);
    }

    @Test
    public void testCreateIPLManagementInfo() {
        IPLManagement iplManagement = new IPLManagement();
        when(iplManagementService.saveIPLManagementInfo(iplManagement)).thenReturn(iplManagement);

        IPLManagement result = iplManagementController.createIPLManagementInfo(iplManagement);

        assertNotNull(result);
        assertEquals(iplManagement, result);
        verify(iplManagementService, times(1)).saveIPLManagementInfo(iplManagement);
    }

    @Test
    public void testUpdateIPLManagementInfo() {
        Long id = 1L;
        IPLManagement iplManagement = new IPLManagement();
        iplManagement.setId(id);
        when(iplManagementService.saveIPLManagementInfo(iplManagement)).thenReturn(iplManagement);

        IPLManagement result = iplManagementController.updateIPLManagementInfo(id, iplManagement);

        assertNotNull(result);
        assertEquals(iplManagement, result);
        verify(iplManagementService, times(1)).saveIPLManagementInfo(iplManagement);
    }

    @Test
    public void testDeleteIPLManagementInfo() {
        Long id = 1L;
        iplManagementController.deleteIPLManagementInfo(id);
        verify(iplManagementService, times(1)).deleteIPLManagementInfo(id);
    }
}
