package io.jmix.petclinic.app.visit.app;

import io.jmix.core.repository.JmixDataRepository;
import io.jmix.petclinic.entity.visit.Visit;

import java.util.UUID;

public interface VisitRepository extends JmixDataRepository<Visit, UUID> {

}