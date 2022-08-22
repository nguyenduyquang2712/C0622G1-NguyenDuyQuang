package bonus_homework.work1.service;

import java.io.IOException;

public interface IStudentService  {

    void addStudent() throws IOException;
    void showAllStudent() throws IOException;
    void removeStudent() throws IOException;
    void changeInfoStudent() throws IOException;
    void findInforStudent() throws IOException;
}