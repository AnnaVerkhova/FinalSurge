package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.EditProfilePage;
import pages.FinalLoginPage;
import pages.HomePage;
import pages.SettingsPage;


public class MainStep extends AbstractStep {

    private FinalLoginPage loginPage;
    private HomePage homePage;
    private SettingsPage settingsPage;
    private EditProfilePage editProfilePage;

    private static final String VALID_LOGIN = System.getProperty("login");
    public static final String VALID_PASSWORD = System.getProperty("password");

    public MainStep(WebDriver driver) {
        super(driver);
    }

    @Step("Открывается страница логина")
    public MainStep openFinalLoginPage() {
        loginPage = new FinalLoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Ввод логина и пароля")
    public MainStep loginWithValidCred() {
        loginPage.login(VALID_LOGIN, VALID_PASSWORD);
        homePage = new HomePage(driver);
        validatePageIsLoaded(homePage);
        return this;
    }

    @Step("Открывается страница настроек")
    public SettingsSteps openSettingPage() {
        homePage = new HomePage(driver);
        homePage.openSettingsPage();
        settingsPage = new SettingsPage(driver);
        validatePageIsLoaded(new SettingsPage(driver));
        return new SettingsSteps(driver);
    }
}
