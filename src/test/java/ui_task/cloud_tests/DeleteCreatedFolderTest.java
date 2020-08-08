package ui_task.cloud_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.BaseTest;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.CloudMainPage;
import ui_task.services.LoginService;
import ui_task.services.RandomGenerator;

import static org.testng.Assert.assertFalse;

@Listeners({TestListener.class})
public class DeleteCreatedFolderTest extends BaseTest {

    private static CloudMainPage cloudMainPage;

    @BeforeMethod
    public void setUp() {
        LoginService.loginToCloud(UserFactory.getUserWithCorrectCredentials());
        String folderName = RandomGenerator.generateRandomFolderName();
        cloudMainPage = new CloudMainPage()
                .deleteFilesIfExist()
                .createNewFolder(folderName);
    }

    @Test
    public void deleteCreatedFolderTest() {
        cloudMainPage.deleteFilesIfExist();
        assertFalse(cloudMainPage.isEntityExists(), "Folder hasn't been deleted");
    }
}
