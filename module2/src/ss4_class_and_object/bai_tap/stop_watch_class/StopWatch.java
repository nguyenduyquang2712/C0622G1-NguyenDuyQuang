package ss4_class_and_object.bai_tap.stop_watch_class;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {

    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setStartTime() {
        startTime = LocalTime.now();
    }

    public void start() {
        this.setStartTime();
    }

    public void stop() {
        this.endTime = LocalTime.now();
    }

    public void getElapsedTime() {
        int elaspedTime = (this.getEndTime().toSecondOfDay() - this.getStartTime().toSecondOfDay()) * 1000;
        System.out.println("Số mili giây đếm đc:" + elaspedTime);
    }
}