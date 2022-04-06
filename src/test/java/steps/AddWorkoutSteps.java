package steps;

import forms.CreatedWorkoutComponent;
import forms.DropdownWorkout;
import forms.InputWorkout;
import io.qameta.allure.Step;
import model.WorkoutModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddWorkoutPage;
import pages.HomePage;

public class AddWorkoutSteps extends AbstractStep {

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }
    private HomePage homePage;

    AddWorkoutPage addWorkoutPage = new AddWorkoutPage(driver);

    @Step("Добавить тренировку")
    public AddWorkoutSteps addWorkout(){
        homePage = new HomePage(driver);
        homePage.openAddWorkoutButton();
        validatePageIsLoaded(addWorkoutPage);
        return this;
    }

    @Step("Заполнение и сохранение тренировки")
    public AddWorkoutSteps createNewWorkout(WorkoutModel workoutModel){
        addWorkoutPage.addRunningWorkout();
        fillAccountForm(workoutModel);
        addWorkoutPage.saveWorkout();
        return this;

    }

    @Step("Заполнение данных")
    private void fillAccountForm(WorkoutModel workoutModel){

        new InputWorkout(driver, "Name").input(workoutModel.getWorkoutName());
        new InputWorkout(driver, "Duration").input(String.valueOf(workoutModel.getDuration()));
        new InputWorkout(driver, "MinHR").input(String.valueOf(workoutModel.getMinHR()));
        new InputWorkout(driver, "kCal").input(workoutModel.getCaloriesBurned());
        new InputWorkout(driver, "hf_great").click();
        new InputWorkout(driver, "IsRace").click2();
        new InputWorkout(driver, "Pace").input(String.valueOf(workoutModel.getPace()));
        new DropdownWorkout(driver, "WorkoutTime").selectOption(workoutModel.getTimeOfDay());
        new DropdownWorkout(driver, "PerEffort").selectOption2(workoutModel.getPerceivedEffort());
        new InputWorkout(driver, "OverallPlace").input(String.valueOf(workoutModel.getOverallPlace()));
        new InputWorkout(driver, "AgeGroupPlace").input(String.valueOf(workoutModel.getAgeGroupPlace()));
        new InputWorkout(driver, "Distance").input(String.valueOf(workoutModel.getDistance()));

    }

    @Step("Проверка правильно созданной тренировки")
    public void validateWorkoutCreated(WorkoutModel expectedModel) {
        WorkoutModel actualModel = getCreatedWorkout();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("New workout is not valid: %s", actualModel)
        );
    }

    @Step("Актуальные данные созданной тренировки")
    private WorkoutModel getCreatedWorkout( ) {
        WorkoutModel workoutModel = new WorkoutModel();
        workoutModel.setDistance(new CreatedWorkoutComponent(driver, "Workout Statistics:").getValueWorkout());
        workoutModel.setRun(new CreatedWorkoutComponent(driver, "Run").getValueWorkout());
        workoutModel.setMarkAsRace(new CreatedWorkoutComponent(driver, "Race Results:").getValueWorkout());
        workoutModel.setOverallPlace(new CreatedWorkoutComponent(driver, "Overall Place:").getValueWorkout());
        workoutModel.setAgeGroupPlace(new CreatedWorkoutComponent(driver, "Age Group Place:").getValueWorkout());
        workoutModel.setHowIFelt(new CreatedWorkoutComponent(driver, "How I Felt:").getValueWorkout());
        workoutModel.setPerceivedEffort(new CreatedWorkoutComponent(driver, "Perceived Effort").getValueWorkout());
        workoutModel.setMinHR(new CreatedWorkoutComponent(driver, "Min HR:").getValueMinAndCalories());
        workoutModel.setCaloriesBurned(new CreatedWorkoutComponent(driver, "Calories Burned:").getValueMinAndCalories());
        return new WorkoutModel();
    }
}
