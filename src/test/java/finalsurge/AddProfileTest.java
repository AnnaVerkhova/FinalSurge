package finalsurge;


import components.buttons.SaveChangesButton;
import io.qameta.allure.Step;
import model.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ProfileModelUtils;

import static forms.InputProfile.delete;

public class AddProfileTest extends BaseTest {

    ProfileModel testProfile = ProfileModelUtils.getDefaultProfileModel();
    ProfileModel testProfile2 = ProfileModelUtils.checkResults();
    Logger log = LogManager.getLogger(AddProfileTest.class);

    @Test(description = "Тестирование нового профиля")
    public void addNewProfileTest() {
        mainStep
                .openFinalLoginPage()
                .loginWithValidCred()
                .openSettingPage()
                .openEditProfilePage()
                .createNewProfile(testProfile)
                .validateProfileCreated(testProfile2)
        ;

    }

//    @Step("Удаление данных профиля")
//    @AfterMethod
//    public void cleanTestData() {
//        ProfileModel profileModel = new ProfileModel();
//        profileModel.setBirthday(delete);
//        profileModel.setWeight(delete);
//        profileModel.setCountry("Select Country...");
//        profileModel.setState("Select Region...");
//        profileModel.setCity(delete);
//        profileModel.setZip(delete);
//        mainStep
//                .openSettingPage()
//                .openEditProfilePage()
//                .fillProfileForm(profileModel)
//        ;
//        log.info("Click [{}] button ","save");
//        driver.findElement(SaveChangesButton.SAVE_CHANGES_BUTTON_LABEL).click();
//    }
}

