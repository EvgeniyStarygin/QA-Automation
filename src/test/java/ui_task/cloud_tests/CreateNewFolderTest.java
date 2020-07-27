package ui_task.cloud_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui_task.business_objects.UserFactory;
import ui_task.random.RandomGenerator;
import ui_task.screens.CloudMainPage;
import ui_task.services.LoginService;

public class CreateNewFolderTest {

    @BeforeMethod
    public void loginToCloud() {
        LoginService.loginToCloud(UserFactory.getUserWithCorrectCredentials());
    }

    @Test
    public void createNewFolderTest() {
        String folderName = RandomGenerator.generateRandomFolderName();
        new CloudMainPage()
                .clickCreateButton()
                .clickCreateNewFolderButton()
                .typeNewFolderName(folderName)
                .clickConfirmationButton();
    }
}
