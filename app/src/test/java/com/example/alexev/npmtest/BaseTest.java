package com.example.alexev.npmtest;

import com.example.alexev.npmtest.other.AppApplication;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = TestApplication.class,
        constants = BuildConfig.class,
        sdk = 21)
@Ignore
public class BaseTest {

    public TestComponent component;
    public TestUtils testUtils;

    @Before
    public void setUp() throws Exception {
        component = (TestComponent) AppApplication.getComponent();
        testUtils = new TestUtils();
    }

}
