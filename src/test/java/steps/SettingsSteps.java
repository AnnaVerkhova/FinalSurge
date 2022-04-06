package steps;

import components.check.CheckProfile;
import io.qameta.allure.Step;
import model.ProfileModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.EditProfilePage;
import pages.SettingsPage;

public class SettingsSteps extends AbstractStep {

    private SettingsPage settingsPage;
    private EditProfilePage editProfilePage;

    public SettingsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Открывается страница профиля")
    public EditProfileSteps openEditProfilePage() {
        settingsPage = new SettingsPage(driver);
        settingsPage.openEditProfileForm();
        editProfilePage = new EditProfilePage(driver);
        validatePageIsLoaded(new EditProfilePage(driver));
        return new EditProfileSteps(driver);
    }

    @Step("Проверка созданного профиля")
    public void validateProfileCreated(ProfileModel expectedModel) {
        ProfileModel actualModel = getActualProfile();
        Assert.assertEquals(
                actualModel,
                expectedModel,
                String.format("Account is not valid: %s", actualModel)
        );
    }

    private ProfileModel getActualProfile( ) {
        ProfileModel actualModel = new ProfileModel();
        actualModel.setGender(new CheckProfile(driver, "Gender").getValue());
        actualModel.setBirthday(new CheckProfile(driver, "Birthday").getValue());
        actualModel.setWeight(new CheckProfile(driver, "Weight").getValue().split("\\.")[0]);
         actualModel.setWeightType(new CheckProfile(driver, "Weight").getValue().split(" ")[1]);
        actualModel.setCountry(new CheckProfile(driver, "Country").getValue());
        actualModel.setState(new CheckProfile(driver, "State").getValue());
        actualModel.setCity(new CheckProfile(driver,"City").getValue());
        actualModel.setZip(new CheckProfile(driver,"Zip").getValue());
        return new ProfileModel();
    }
}
