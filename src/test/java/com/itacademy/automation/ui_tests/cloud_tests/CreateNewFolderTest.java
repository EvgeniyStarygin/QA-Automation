package com.itacademy.automation.ui_tests.cloud_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.CloudMainPage;
import com.itacademy.automation.ui_task.services.LoginService;
import com.itacademy.automation.ui_task.services.RandomGenerator;

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
