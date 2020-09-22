package listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.jetbrains.annotations.NotNull;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;


public class ExtentReporterNG extends TestListenerAdapter implements IReporter, ITestResult {
    private ExtentReports extent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getFailedConfigurations(), LogStatus.ERROR);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
            }
        }

        extent.flush();
        extent.close();
    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                StringBuilder testExecutionLog = new StringBuilder("<pre>");
                Reporter.getOutput(result).forEach(item -> testExecutionLog.append(item).append("\n"));

                if (result.getThrowable() != null) {
                    testExecutionLog.append(String.format("\n\n-------Error Occurred---------\n\n%s", convertStackTraceToString(result.getThrowable())));
                }
                testExecutionLog.append("</pre>");
                test.log(status, testExecutionLog.toString());
                extent.endTest(test);
            }
        }
    }

    private String convertStackTraceToString(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int status) {

    }

    @Override
    public ITestNGMethod getMethod() {
        return null;
    }

    @Override
    public Object[] getParameters() {
        return new Object[0];
    }

    @Override
    public void setParameters(Object[] parameters) {

    }

    @Override
    public IClass getTestClass() {
        return null;
    }

    @Override
    public Throwable getThrowable() {
        return null;
    }

    @Override
    public void setThrowable(Throwable throwable) {

    }

    @Override
    public long getStartMillis() {
        return 0;
    }

    @Override
    public long getEndMillis() {
        return 0;
    }

    @Override
    public void setEndMillis(long millis) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public Object getInstance() {
        return null;
    }

    @Override
    public Object[] getFactoryParameters() {
        return new Object[0];
    }

    @Override
    public String getTestName() {
        return null;
    }

    @Override
    public String getInstanceName() {
        return null;
    }

    @Override
    public ITestContext getTestContext() {
        return null;
    }

    @Override
    public void setTestName(String name) {

    }

    @Override
    public boolean wasRetried() {
        return false;
    }

    @Override
    public void setWasRetried(boolean wasRetried) {

    }

    @Override
    public List<ITestNGMethod> getSkipCausedBy() {
        return null;
    }

    @Override
    public int compareTo(@NotNull ITestResult o) {
        return 0;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public Set<String> getAttributeNames() {
        return null;
    }

    @Override
    public Object removeAttribute(String name) {
        return null;
    }
}

