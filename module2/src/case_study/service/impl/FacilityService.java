package case_study.service.impl;

import case_study.model.furama_resort.Facility;
import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;
import case_study.model.furama_resort.VillaFurama;
import case_study.service.IFacilityService;
import case_study.service.impl.exception.InfoFacilityException;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.io.IOException;
import java.util.*;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityMaintainList= new LinkedHashMap<>();
    private static final String SRC_DATA_FACILITY_FILE_CSV = "src\\case_study\\data\\Facility.csv";
    private static final String SRC_DATA_FACILITY_MAINTAIN_FILE_CSV="src\\case_study\\data\\FacilityMaintain.csv";

    @Override
    public void displayListFacility() throws IOException {
        this.checkMaintainFacility();
        facilityList = readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        if(facilityList.size()==0){
            System.out.println("No data");
            return;
        }
        Set<Facility> facilitySet = facilityList.keySet();
        for (Facility facility : facilitySet) {
            System.out.println(facility + ", Times to use: " + facilityList.get(facility));
        }
    }

    private void checkMaintainFacility() throws IOException {
        try {
            facilityList = readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        facilityMaintainList = readFacilityFile(SRC_DATA_FACILITY_MAINTAIN_FILE_CSV);
    Set<Facility> facilitySet = facilityList.keySet();
        for(Facility facility:facilitySet){
           if( facilityList.get(facility)>=5){
               facilityMaintainList.put(facility,facilityList.get(facility));
           }
        }
        Set<Facility> facilityMaintainSet = facilityMaintainList.keySet();
        for(Facility facility:facilityMaintainSet){
            facilityList.remove(facility);
        }
        writeFacilityFile(SRC_DATA_FACILITY_FILE_CSV, facilityList);
        writeFacilityFile(SRC_DATA_FACILITY_MAINTAIN_FILE_CSV,facilityMaintainList);
    }

    @Override
    public void addFacility() throws IOException {
        facilityList = readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        while (true) {
            System.out.println("Enter the type Facility you want to add to the list Facility");
            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Facility villa = this.addNewVilla();
                        facilityList.put(villa,0);
                        break;
                    case 2:
                        Facility house = this.addNewHouse();
                        facilityList.put(house, 0);
                        System.out.println("Completed add new House");
                        break;
                    case 3:
                        Facility room = this.addNewRoom();
                        facilityList.put(room, 0);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Not Valid choice, please reenter the choice");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            writeFacilityFile(SRC_DATA_FACILITY_FILE_CSV, facilityList);
        }
    }

    @Override
    public void displayFacilityMaintain() throws IOException {
        facilityMaintainList = readFacilityFile(SRC_DATA_FACILITY_MAINTAIN_FILE_CSV);
        if(facilityMaintainList.size()==0){
            System.out.println("no data");
            return;
        }
        for (Map.Entry<Facility, Integer> entry : facilityMaintainList.entrySet()) {
                System.out.println(entry.getKey()+" Time to use: "+entry.getValue());
        }
    }

    @Override
    public void maintainFacility() throws IOException {
        try {
            facilityMaintainList = readFacilityFile(SRC_DATA_FACILITY_MAINTAIN_FILE_CSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            facilityList = readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Facility> facilityMaintainSet = facilityMaintainList.keySet();
        for(Facility facility:facilityMaintainSet){
            facilityList.put(facility,0);
        }
        facilityMaintainList.clear();
        System.out.println("Completed Maintain Facility");
        writeFacilityFile(SRC_DATA_FACILITY_MAINTAIN_FILE_CSV,facilityMaintainList);
        writeFacilityFile(SRC_DATA_FACILITY_FILE_CSV,facilityList);
    }

    private Facility addNewRoom() {
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter usableArea of Room:");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea < 30) {
                    throw new InfoFacilityException("Not valid information,please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCost;
        while (true) {
            try {
                System.out.println("Enter rental Cost of Room");
                rentalCost = Double.parseDouble(scanner.nextLine());
                if (rentalCost <= 0) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int maxPeople;
        while (true) {
            try {
                System.out.println("Enter Max number of people");
                maxPeople = Integer.parseInt(scanner.nextLine());
                if (maxPeople < 0 || maxPeople > 20) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter the rental Type of Room");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("\\D{3,20}") || !rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter the service Code ");
                serviceID = scanner.nextLine();
                if (!serviceID.matches("^[0-9]{4}$")) {
                    throw new NumberFormatException("not number, reenter");
                }
                serviceID = "SVRO-" + serviceID;
                if (findServiceID(serviceID)) {
                    throw new InfoFacilityException("Not valid information, please reeter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String freeServiceIncluded;
        while (true) {
            try {
                System.out.println("Enter free Service of Room");
                freeServiceIncluded = scanner.nextLine();
                if (!freeServiceIncluded.matches("\\D{3,20}") || !freeServiceIncluded.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Facility roomFurama = new RoomFurama("RoomFurama", usableArea, rentalCost, maxPeople, rentalType, serviceID, freeServiceIncluded);
        return roomFurama;
    }

    private Facility addNewVilla() {
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter usableArea of Villa:");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea < 30) {
                    throw new InfoFacilityException("Not valid information,please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCost;
        while (true) {
            try {
                System.out.println("Enter rental Cost of Villa");
                rentalCost = Double.parseDouble(scanner.nextLine());
                if (rentalCost <= 0) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int maxPeople;
        while (true) {
            try {
                System.out.println("Enter Max number of people");
                maxPeople = Integer.parseInt(scanner.nextLine());
                if (maxPeople < 0 || maxPeople > 20) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter the rental Type of Villa");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("\\D{3,20}") || !rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter the service Code ");
                serviceID = scanner.nextLine();
                if (!serviceID.matches("^[0-9]{4}$")) {
                    throw new NumberFormatException("not number, reenter");
                }
                serviceID = "SVVL-" + serviceID;
                if (findServiceID(serviceID)) {
                    throw new InfoFacilityException("Not valid information, please reeter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String roomStandard;
        while (true) {
            try {
                System.out.println("Enter the standard type of Villa");
                roomStandard = scanner.nextLine();
                if (!roomStandard.matches("\\D{3,20}") || !roomStandard.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double swimmingOfArea;

        while (true) {
            try {
                System.out.println("Enter the swimming of Area");
                swimmingOfArea = Double.parseDouble(scanner.nextLine());
                if (swimmingOfArea < 30) {
                    throw new InfoFacilityException("Not valid information,please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        int numberOfFloor;
        while (true) {
            try {
                System.out.println("Enter the number of floor in Villa");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
                if (numberOfFloor < 0 || numberOfFloor > 10) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Facility villaFurama = new VillaFurama("VillaFurama", usableArea, rentalCost, maxPeople, rentalType, serviceID, roomStandard, swimmingOfArea, numberOfFloor);
        return villaFurama;
    }

    private Facility addNewHouse() {
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter usableArea of House:");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea < 30) {
                    throw new InfoFacilityException("Not valid information,please reenter");
                }
                break;
            } catch (InfoFacilityException | NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCost;
        while (true) {
            try {
                System.out.println("Enter rental Cost of House");
                rentalCost = Double.parseDouble(scanner.nextLine());
                if (rentalCost <= 0) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int maxPeople;
        while (true) {
            try {
                System.out.println("Enter Max number of people");
                maxPeople = Integer.parseInt(scanner.nextLine());
                if (maxPeople < 0 || maxPeople > 20) {
                    throw new InfoFacilityException("Not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter the rental Type of House");
                rentalType = scanner.nextLine();
                if (!rentalType.matches("\\D{3,20}") || !rentalType.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter the service Code ");
                serviceID = scanner.nextLine();
                if (!serviceID.matches("^[0-9]{4}$")) {
                    throw new NumberFormatException("not number, reenter");
                }
                serviceID = "SVHO-" + serviceID;
                if (findServiceID(serviceID)) {
                    throw new InfoFacilityException("Not valid information, please reeter");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String roomStandard;
        while (true) {
            try {
                System.out.println("Enter the standard type of house");
                roomStandard = scanner.nextLine();
                if (!roomStandard.matches("\\D{3,20}") || !roomStandard.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new InfoFacilityException("not valid information, please reenter");
                }
                break;
            } catch (InfoFacilityException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int numberOfFloor;
        System.out.println("Enter the number of floor in house");
        numberOfFloor = Integer.parseInt(scanner.nextLine());
        Facility house = new HouseFurama("HouseFurama", usableArea, rentalCost, maxPeople, rentalType, serviceID, roomStandard, numberOfFloor);
        return house;
    }

    private boolean findServiceID(String id) throws IOException {
        facilityList = readFacilityFile(SRC_DATA_FACILITY_FILE_CSV);
        Set<Facility> facilitySet = facilityList.keySet();
        for (Facility facility : facilitySet) {
            if (facility.getServiceID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Facility, Integer> readFacilityFile(String path) throws IOException {
        List<String> strings = ReadFile.readFile(path);
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
//        if(strings.size()==0){
//            return null;
//        }
        String[] info;
        for (String line : strings) {
            if (!line.equals("")) {
                info = line.split(",");
                if (info[0].contains("Villa")) {
                    facilityList.put((new VillaFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), (info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]))), Integer.parseInt(info[9]));
                } else if (info[0].contains("House")) {
                    facilityList.put(new HouseFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), info[4], info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                } else if (info[0].contains("Room")) {
                    facilityList.put(new RoomFurama(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]), info[4], info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
        }
        return facilityList;
    }

    public static void writeFacilityFile(String path, Map<Facility, Integer> facilities) throws IOException {
        String data = "";
        Set<Facility> facilitySet = facilities.keySet();
        for (Facility facility : facilitySet) {
            data += facility.toString() + "," + facilities.get(facility);
            data += "\n";
        }
        WriteFile.writeFile(path, data);
    }
}
