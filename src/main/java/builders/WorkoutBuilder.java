package builders;

import model.WorkoutModel;

public class WorkoutBuilder {

    WorkoutModel workoutModel = new WorkoutModel();

    public WorkoutBuilder() {

    }
    public static WorkoutBuilder newValues() {
        return new WorkoutBuilder();
    }


    public WorkoutBuilder setCaloriesBurned(String caloriesBurned) {
        this.workoutModel.setCaloriesBurned(caloriesBurned);
        return this;
    }

    public WorkoutBuilder setRun(String run) {
        this.workoutModel.setRun(run);
        return this;
    }
    public WorkoutBuilder setDistance(String distance) {
        this.workoutModel.setDistance(distance);
        return this;
    }

    public WorkoutBuilder setHowIFelt(String howIFelt) {
        this.workoutModel.setHowIFelt(howIFelt);
        return this;
    }

    public WorkoutBuilder setMinHR(String minHR) {
        this.workoutModel.setMinHR(minHR);
        return this;
    }
    public WorkoutBuilder setPerceivedEffort(String perceivedEffort) {
        this.workoutModel.setPerceivedEffort(perceivedEffort);
        return this;
    }
    public WorkoutBuilder setAgeGroupPlace(String ageGroupPlace) {
        this.workoutModel.setAgeGroupPlace(ageGroupPlace);
        return this;
    }
    public WorkoutBuilder setOverallPlace(String overallPlace) {
        this.workoutModel.setOverallPlace(overallPlace);
        return this;}

    public WorkoutModel build() {
        return workoutModel;
    }
}
