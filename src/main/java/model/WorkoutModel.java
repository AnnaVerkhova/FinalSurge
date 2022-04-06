package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Getter
@Setter
public class WorkoutModel {
    String WorkoutName;
    String WorkoutDescription;
    String Distance;
    double Duration;
    int Pace;
    String HowIFelt;
    String MinHR;
    String CaloriesBurned;
    String PerceivedEffort;
    String MarkAsRace;
    String TimeOfDay;
    String OverallPlace;
    String AgeGroupPlace;
    String Run;

    public WorkoutModel() {
    }
}


