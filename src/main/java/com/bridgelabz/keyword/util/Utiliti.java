package com.bridgelabz.keyword.util;

import com.bridgelabz.keyword.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Utiliti extends BaseClass {

    public static void captureScreenshot() {

        Object driver = null;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs((OutputType.FILE));

        File destinationFile = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + "_screenshot.png");

        try {
            FileHandler.copy(sourceFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
