package ui_task.cloud_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.BaseTest;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.CloudMainPage;
import ui_task.services.LoginService;
import ui_task.services.RandomGenerator;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class CreateNewFolderTest extends BaseTest {

    private static CloudMainPage cloudMainPage;

    @BeforeMethod
    public void setUp() {
        LoginService.loginToCloud(UserFactory.getUserWithCorrectCredentials());
        cloudMainPage = new CloudMainPage().deleteFilesIfExist();
    }

    @AfterMethod
    public void tearDown() {
        cloudMainPage.deleteFilesIfExist();
    }

    @Test
    public void createNewFolderTest() {
        String folderName = RandomGenerator.generateRandomFolderName();
        cloudMainPage.createNewFolder(folderName);
        assertEquals(cloudMainPage.getNameOfTheCreatedEntity(), folderName, "Unexpected folder name");
    }
}
