package case_study.service;

import java.io.IOException;

public interface IFacilityService {
    void displayListFacility() throws IOException;

    void addFacility() throws IOException;

    void displayFacilityMaintain() throws IOException;

    void maintainFacility() throws IOException;
}
