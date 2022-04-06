package steps;

import forms.CreateProfileFormComponent;
import forms.DropdownProfile;
import forms.InputProfile;
import forms.SelectProfile;
import io.qameta.allure.Step;
import model.ProfileModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.EditProfilePage;
import pages.SettingsPage;



public class EditProfileSteps extends AbstractStep {

    private EditProfilePage editProfilePage;
    SettingsPage settingsPage = new SettingsPage(driver);



    public EditProfileSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Создание нового профиля")
    public SettingsSteps createNewProfile(ProfileModel profileModel) {
        CreateProfileFormComponent form = new CreateProfileFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillProfileForm(profileModel);
        form.save();
        validatePageIsLoaded(settingsPage);
        return new SettingsSteps(driver);
    }

    @Step("Заполнение данными созданного профиля")
    public void fillProfileForm(ProfileModel profileModel) {
        new SelectProfile(driver, "Gender").clickGender();
        new InputProfile(driver, "Birthday").insertBirthDay(profileModel.getBirthday());
        new InputProfile(driver, "Weight").insert(String.valueOf(profileModel.getWeight()));
        new SelectProfile(driver, "WeightType").clickKg();
        new InputProfile(driver, "City").insert(profileModel.getCity());
        new InputProfile(driver, "Zip").insert(profileModel.getZip());
        new DropdownProfile(driver, "Country").selectOption(profileModel.getCountry());
        new DropdownProfile(driver, "State").selectOption(profileModel.getState());
    }
}
