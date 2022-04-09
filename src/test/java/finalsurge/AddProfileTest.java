package finalsurge;


import components.buttons.SaveChangesButton;
import io.qameta.allure.Step;
import model.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ProfileModelUtils;

//import static forms.InputProfile.delete;

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
}

