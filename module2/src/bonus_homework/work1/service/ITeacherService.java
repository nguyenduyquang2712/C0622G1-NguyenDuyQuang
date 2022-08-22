package bonus_homework.work1.service;

import java.io.IOException;

public interface ITeacherService {
    void showAllTeacher() throws IOException;

    void addTeacher() throws IOException;

    void removeTeacher() throws IOException;

    void searchTeacher() throws IOException;
}