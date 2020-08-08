package ui_task.cloud_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_task.BaseTest;
import ui_task.business_objects.UserFactory;
import ui_task.listeners.TestListener;
import ui_task.screens.CloudMainPage;
import ui_task.services.FileCreator;
import ui_task.services.LoginService;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class UploadFileTest extends BaseTest {

    private static CloudMainPage cloudMainPage;

    @BeforeMethod
    public void setUp() {
        LoginService.loginToCloud(UserFactory.getUserWithCorrectCredentials());
        FileCreator.createTestFile();
        cloudMainPage = new CloudMainPage();
        cloudMainPage.deleteFilesIfExist();
    }

    @AfterMethod
    public void tearDown() {
        cloudMainPage.deleteFilesIfExist();
        FileCreator.deleteTestFile();
    }

    @Test
    public void uploadFileTest() {
        cloudMainPage
                .clickUploadButton()
                .uploadNewFile(FileCreator.getFile().getAbsolutePath());
        if (cloudMainPage.isFileUploaded()) {
            cloudMainPage
                    .closeUploadResultWindow()
                    .clickMyFilesLink();
        }
        assertEquals(cloudMainPage.getNameOfTheCreatedEntity(), FileCreator.getFileName(), "Unexpected file name");
    }
}
