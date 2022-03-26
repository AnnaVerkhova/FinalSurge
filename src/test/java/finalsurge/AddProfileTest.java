package finalsurge;


import model.ProfileModel;
import org.testng.annotations.Test;
import utils.ProfileModelUtils;

public class AddProfileTest extends BaseTest {

    ProfileModel testProfile = ProfileModelUtils.getDefaultProfileModel();


    @Test(description = "Тестирование нового профиля")
    public void addNewProfileTest(){
        mainStep
                .openFinalLoginPage()
                .loginWithValidCred()
                .openSettingPage()
                .openEditProfilePage()
                ;

    }
}
