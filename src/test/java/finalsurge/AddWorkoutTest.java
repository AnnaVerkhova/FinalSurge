package finalsurge;

import builders.WorkoutBuilder;
import model.WorkoutModel;
import org.testng.annotations.Test;
import utils.WorkoutModelUtils;

public class AddWorkoutTest extends BaseTest{

    WorkoutModel testWorkout = WorkoutModelUtils.getWorkModel();
    WorkoutModel testWorkoutTwo = WorkoutBuilder.buildDefault().build();

    @Test(description = "Тестирование добавления тренировки")
    public void addNewWorkoutTest(){
        mainStep
                .openFinalLoginPage()
                .loginWithValidCred()
                .addWorkout()
                .createNewWorkout(testWorkout)
                .validateWorkoutCreated(testWorkoutTwo);

    }
}
