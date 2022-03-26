package steps;

import forms.DropdownProfile;
import forms.InputProfile;
import io.qameta.allure.Step;
import model.ProfileModel;
import org.openqa.selenium.WebDriver;
import pages.EditProfilePage;


public class EditProfileSteps extends AbstractStep{

    private EditProfilePage editProfilePage;

    public EditProfileSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение данными созданного профиля")
    private void fillProfileForm(ProfileModel profileModel) {
        new InputProfile(driver, "Gender").insert(profileModel.getGender());
        new InputProfile(driver, "Birthday").insert(profileModel.getBirthday());
        new InputProfile(driver, "Weight").insert(String.valueOf(profileModel.getWeight()));
        new InputProfile(driver, "City").insert(profileModel.getCity());
        new InputProfile(driver, "Zip").insert(profileModel.getZip());

        new DropdownProfile(driver, "Country").selectOption(profileModel.getCountry());
        new DropdownProfile(driver, "State").selectOption(profileModel.getState());
    }
}
