package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.contract.Contract;
import case_study.service.IContractService;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.io.IOException;
import java.util.*;

public class ContractService implements IContractService {
    private static Scanner scanner = new Scanner(System.in);
    private BookingService bookingService = new BookingService();
    private Set<Booking> bookingSetOfContract = new TreeSet<>();
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private static List<Contract> contracts = new ArrayList<>();
    private static final String SRC_DATA_BOOKINFOFCONTRACT_FILE_CSV = "src\\case_study\\data\\BookingforContract.csv";
    private static final String SRC_DATA_CONTRACT_FILE_CSV = "src\\case_study\\data\\Contract.csv";
    @Override
    public void createContract() {
       Contract contract = this.infoContract();
       if(contract==null){
           System.out.println("no data to create contract");
           return;
       }
       contracts.add(contract);
       bookingSetOfContract.remove(bookingQueue.poll());
       bookingService.writeFileBooking(SRC_DATA_BOOKINFOFCONTRACT_FILE_CSV,bookingSetOfContract);
       writeFileContract(SRC_DATA_CONTRACT_FILE_CSV,contracts);
    }

    @Override
    public void displayListContract() {
        contracts = readFileContract(SRC_DATA_CONTRACT_FILE_CSV);
        if(contracts==null){
            System.out.println("no data");
            return;
        }
        for(Contract contract: contracts){
            System.out.println(contract);
        }
    }

    @Override
    public void editListContract() {
        contracts = readFileContract(SRC_DATA_CONTRACT_FILE_CSV);
        if(contracts==null){
            System.out.println("No data");
            return;
        }
        System.out.println("List booking:  ");
        displayListContract();
        System.out.println("Enter the contract number you want to edit");
        String contractnumber = scanner.nextLine();
        for (int i = 0; i < contracts.size() ; i++) {
            if(contracts.get(i).getNumberContract().equals(contractnumber)){
                contracts.set(i,inforEditingContract(contracts.get(i)));
                System.out.println("Completed Edit");
            }
        }
        writeFileContract(SRC_DATA_CONTRACT_FILE_CSV,contracts);
    }

    private void pushBooking() {
        bookingSetOfContract = bookingService.readFileBooking(SRC_DATA_BOOKINFOFCONTRACT_FILE_CSV);
        for (Booking booking : bookingSetOfContract) {
            bookingQueue.add(booking);
            System.out.println(booking);
        }
    }
    private Contract inforEditingContract(Contract contract){
        String numberContract;
        System.out.println("Enter number contract");
        numberContract = scanner.nextLine();
        String bookingID;
        bookingID = contract.getBookingId();
        System.out.println("Booking ID is: "+bookingID);
        String customerId;
        customerId = contract.getcustomerID();
        System.out.println("Customer ID is:"+customerId);
        double depositAmount;
        System.out.println("Enter deposit Amount ");
        depositAmount = Double.parseDouble(scanner.nextLine());
        double totalAmount;
        System.out.println("Enter total Amount");
        totalAmount = Double.parseDouble(scanner.nextLine());

        Contract newcontract = new Contract(numberContract, bookingID, depositAmount, totalAmount, customerId);
        return newcontract;
    }
    private Contract infoContract() {
        pushBooking();
        if(bookingQueue.size()==0){
            return null;
        }
        String numberContract;
        System.out.println("Enter number contract");
        numberContract = scanner.nextLine();
        String bookingID;
        bookingID = bookingQueue.peek().getBookingId();
        System.out.println(bookingID);
        String customerId;
        customerId = bookingQueue.peek().getCustomerBookingId();
        System.out.println(customerId);
        double depositAmount;
        System.out.println("Enter deposit Amount ");
        depositAmount = Double.parseDouble(scanner.nextLine());
        double totalAmount;
        System.out.println("Enter total Amount");
        totalAmount = Double.parseDouble(scanner.nextLine());

        Contract contract = new Contract(numberContract, bookingID, depositAmount, totalAmount, customerId);
        return contract;
    }

    public static List<Contract>readFileContract(String path){
        List<String> strings = ReadFile.readFile(path);
        List<Contract> contractList = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            if(!line.equals("")) {
                info = line.split(",");
                contractList.add(new Contract(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), info[4]));
            }  
        }
        return contractList;
    }
    public static void writeFileContract(String path, List<Contract> contractList) {
        String data = "";
        for (Contract contract : contractList) {
            data += contract.toString();
            data += "\n";
        }
        try {
            WriteFile.writeFile(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
