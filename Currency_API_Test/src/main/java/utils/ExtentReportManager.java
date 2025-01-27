package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    public static void initializeReport() {
        if (extent == null) {
        	String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
            sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Environment", "Test");
            extent.setSystemInfo("Tester", "Jeena");
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        return extent.createTest(testName);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}