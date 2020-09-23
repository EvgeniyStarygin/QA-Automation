package com.itacademy.automation.ui_task.loggers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import com.itacademy.automation.ui_task.business_objects.Email;
import com.itacademy.automation.ui_task.business_objects.Letter;
import com.itacademy.automation.ui_task.business_objects.User;

import java.io.File;

import static java.lang.String.format;

public class CustomLogger {

    private static Logger logger = Logger.getLogger("CustomLogger");

    public static void logTestFailed(Throwable throwable) {
        logger.error(throwable.getMessage());
    }

    public static void logTestStarted(ITestResult testResult) {
        logger.info("Starting test: " + testResult.getName());
    }

    public static void logTestSuccess(ITestResult testResult) {
        logger.info("Test " + testResult.getName() + " - PASSED");
    }

    public static void logTestSkipped(ITestResult testResult) {
        logger.info("Test " + testResult.getName() + " - SKIPPED");
    }

    public static void logSendNewLetter(Letter letter) {
        logger.info(format("Sending new letter: address-%s, subject-%s, message-%s",
                letter.getAddress(), letter.getSubject(), letter.getText()));
    }

    public static void logSaveNewLetter(Letter letter) {
        logger.info(format("Saving new letter: address-%s, subject-%s, message-%s",
                letter.getAddress(), letter.getSubject(), letter.getText()));
    }

    public static void logDeleteLetterFromInboxAndSent() {
        logger.info("Deleting letter from Inbox and Sent");
    }

    public static void logDeleteLetterFromDraftsAndTrash() {
        logger.info("Deleting letter from Drafts and Trash");
    }

    public static void logSendNewLetterWithIncorrectAddress(Letter letter) {
        logger.info("Sending new letter with incorrect address: address - " + letter.getAddress());
    }

    public static void logClick(By locator) {
        logger.debug(format("Click element located: [%s]", locator));
    }

    public static void logTypeTo(By locator, String value) {
        logger.debug(format("Type [%s] to element located: [%s]", value, locator));
    }

    public static void logGetTextFrom(By locator) {
        logger.debug(format("Get text from element located [%s]", locator));
    }

    public static void logIsDisplayed(By locator) {
        logger.debug(format("Check that element located [%s] is displayed", locator));
    }

    public static void logFindElement(By locator) {
        logger.debug(format("Find element located [%s]", locator));
    }

    public static void logFindElements(By locator) {
        logger.debug(format("Find all elements located [%s]", locator));
    }

    public static void logSelect(By locator, String value) {
        logger.debug(format("Select [%s] from element located: [%s]", value, locator));
    }

    public static void logSelectCheckbox(By locator) {
        logger.debug(format("Select checkbox from element located: [%s]", locator));
    }

    public static void logWaitForVisibility(By locator, int seconds) {
        logger.debug(format("Wait for visibility of element located [%s] for %s seconds",
                locator, seconds));
    }

    public static void logWaitForClickable(By locator, int seconds) {
        logger.debug(format("Wait for clickable of element located [%s] for %s seconds",
                locator, seconds));
    }

    public static void logIsElementPresent(By locator) {
        logger.debug(format("Check that element located [%s] is present", locator));
    }

    public static void logSwitchToLastTab() {
        logger.debug("Switch to last opened tab");
    }

    public static void logSwitchToFrame(By locator) {
        logger.debug(format("Switch to frame located [%s]", locator));
    }

    public static void logSwitchToTab(String name) {
        logger.debug(format("Switched to tab [%s]", name));
    }

    public static void logLoginToCloud(User user) {
        logger.info(format("Signing into Cloud with User: [%s]", user));
    }

    public static void logEnterEmail(Email email) {
        logger.info(format("Entering Email: [%s]", email));
    }

    public static void logLoginToMail(User user) {
        logger.info(format("Signing into Mailbox with User: [%s]", user));
    }

    public static void logOpenPage(String url) {
        logger.debug(format("Open page by URL: [%s]", url));
    }

    public static void logCloseBrowser() {
        logger.debug("Close browser");
    }

    public static void logException(Exception exception) {
        logger.warn(exception.getMessage());
    }

    public static void logUploadFile(By locator, String path) {
        logger.debug(format("Upload file from [%s] to element located: [%s]", path, locator));
    }

    public static void logWaitForPresence(By locator, int seconds) {
        logger.debug(format("Wait for presence of element located [%s] for %s seconds",
                locator, seconds));
    }

    public static void logGetAttributeValue(By locator, String attributeName) {
        logger.debug(format("Get value of attribute [%s] from element located [%s]", attributeName, locator));
    }

    public static void logDeleteTestFile(File file) {
        logger.info(format("Delete file [%s]", file.getAbsolutePath()));
    }

    public static void logCreateTestFile(File file) {
        logger.info(format("Create file [%s]", file.getAbsolutePath()));
    }

    public static void logTakeScreenshot(File file) {
        logger.info(format("Take screenshot to the file [%s]", file.getAbsolutePath()));
    }

}
