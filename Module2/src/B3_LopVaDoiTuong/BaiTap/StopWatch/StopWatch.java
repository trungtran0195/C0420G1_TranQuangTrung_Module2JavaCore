package B3_LopVaDoiTuong.BaiTap.StopWatch;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
        startTime = LocalTime.now();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime start(){
        return this.startTime = LocalTime.now();
    }

    public LocalTime stop(){
        return this.endTime = LocalTime.now();
    }

    public double getElapsedTime(){
        return ChronoUnit.NANOS.between(this.startTime,this.endTime);
    }
}
