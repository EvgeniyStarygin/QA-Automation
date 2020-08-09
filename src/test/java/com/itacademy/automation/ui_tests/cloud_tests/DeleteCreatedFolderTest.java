package com.itacademy.automation.ui_tests.cloud_tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.itacademy.automation.ui_tests.BaseTest;
import com.itacademy.automation.ui_task.business_objects.UserFactory;
import com.itacademy.automation.ui_task.listeners.TestListener;
import com.itacademy.automation.ui_task.screens.CloudMainPage;
import com.itacademy.automation.ui_task.services.LoginService;
import com.itacademy.automation.ui_task.services.RandomGenerator;

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
