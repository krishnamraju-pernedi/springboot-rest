package com.hackerrank.github;

import com.hackerrank.github.requests.*;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    EventsControllerTest.class,
    ResourcesControllerTest.class,
    NoResourcesEventsControllerTest.class
})
public class TestSuite {

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(TestSuite.class);
    }
}
