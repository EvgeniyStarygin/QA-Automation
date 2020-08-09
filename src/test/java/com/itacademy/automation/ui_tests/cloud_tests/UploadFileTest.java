package com.itacademy.automation.ui_tests.cloud_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.CloudMainPage;
import com.itacademy.automation.ui_task.services.FileCreator;
import com.itacademy.automation.ui_task.services.LoginService;

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
