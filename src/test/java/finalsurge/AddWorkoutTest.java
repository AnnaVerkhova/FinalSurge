package finalsurge;

import model.WorkoutModel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;
import utils.WorkoutModelUtils;

@Listeners({TestListener.class})
public class AddWorkoutTest extends BaseTest{

    WorkoutModel testWorkout = WorkoutModelUtils.getWorkModel();
    WorkoutModel testWorkoutTwo = WorkoutModelUtils.checkValidationResults();

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
