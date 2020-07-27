package task6.tests.cloudtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import task6.businessobjects.UserFactory;
import task6.random.RandomGenerator;
import task6.screens.CloudMainPage;
import task6.services.LoginService;

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
