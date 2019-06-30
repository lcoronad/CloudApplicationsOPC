package com.redhat.coolstore.inventory.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Specializes;

import com.redhat.freelance4j.gateway.model.Project;
import com.redhat.freelance4j.gateway.service.ProjectService;

@Specializes
public class MockStoreStatusService extends ProjectService {

    @Override
    public List<Project> getProjects() {
        return new ArrayList<Project>();
    }
}
