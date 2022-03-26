package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
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
}
