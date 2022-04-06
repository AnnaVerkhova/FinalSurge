package utils;


import builders.WorkoutBuilder;
import model.WorkoutModel;

public class WorkoutModelUtils {
    public static WorkoutModel getWorkModel() {
        WorkoutModel workoutModel = new WorkoutModel();
        workoutModel.setCaloriesBurned("300");
        workoutModel.setWorkoutName("Running");
        workoutModel.setDistance("3");
        workoutModel.setDuration(1.30);
        workoutModel.setMinHR("32" );
        workoutModel.setWorkoutDescription("Running");
        workoutModel.setPerceivedEffort("2 (Light)");
        workoutModel.setTimeOfDay("06:15 AM");
        workoutModel.setAgeGroupPlace("21");
        workoutModel.setPace(2);
        workoutModel.setOverallPlace("345");
        workoutModel.setMarkAsRace("01.20");
        return workoutModel;
    }

    public static WorkoutModel checkValidationResults() {
        WorkoutBuilder.newValues()
                .setCaloriesBurned("300 kCal")
                .setDistance("3.00 mi ~ 0:01.30")
                .setHowIFelt("Great")
                .setMinHR("3 bpm")
                .setPerceivedEffort("2 (Light)")
                .setAgeGroupPlace("21")
                .setOverallPlace("345")
                .setRun("Running")
                .build();
        return new WorkoutModel();
    }

}
