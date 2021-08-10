package io.jmix.petclinic.app.visit.app;

import io.jmix.petclinic.app.visit.VisitTestDataCreation;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("petclinic_VisitTestDataCreationService")
public class VisitTestDataCreationService {

    @Inject
    protected VisitTestDataCreation visitTestDataCreation;


    @Inject
    protected VisitRepository visitRepository;


    public void createVisits() {
        visitTestDataCreation.createData();
    }

    public boolean necessaryToCreateVisitTestData() {
        return visitRepository.count() == 0;
    }
}