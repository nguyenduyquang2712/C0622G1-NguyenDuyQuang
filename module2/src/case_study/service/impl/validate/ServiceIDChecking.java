package case_study.service.impl.validate;

import case_study.model.furama_resort.Facility;
import case_study.service.impl.FacilityService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ServiceIDChecking {
    private static FacilityService facilityService = new FacilityService();
    private static final String SRC_DATA_FACILITY_FILE_CSV = "src\\case_study\\data\\Facility.csv";
    public static boolean checkingServiceID(String serviceID) throws IOException {
        Map<Facility, Integer> facilityList ;
        facilityList = facilityService.readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        if(facilityList==null){
            return false;
        }
        Set<Facility> facilitySet = facilityList.keySet();
        for (Facility facility : facilitySet) {
            if (facility.getServiceID().equals(serviceID)) {
                return true;
            }
        }
        return false;
    }
}
