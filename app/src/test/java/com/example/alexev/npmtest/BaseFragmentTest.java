package com.example.alexev.npmtest;


import com.example.alexev.npmtest.activitys.MainActivity;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BaseFragmentTest extends BaseTest {


    private MainActivity activity;


    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        component.inject(this);

        activity = mock(MainActivity.class);

       /* RepoInfoFragment repoInfoFragment = RepoInfoFragment.newInstance(repository);
        baseFragment = repoInfoFragment;
        baseFragment.onCreate(null); //for Di
        baseFragment.onAttach(activity); //for link activity

        basePresenter = repoInfoFragment.presenter;*/
    }

    @Test
    public void testAttachActivityCallback() throws Exception {
      //  assertNotNull(baseFragment.activityCallback);
    }

    @Test
    public void testShowLoadingState() throws Exception {
       // baseFragment.showLoading();
      //  verify(activity).showProgressBar();
    }

    @Test
    public void testHideLoadingState() throws Exception {
      //  baseFragment.hideLoading();
     //   verify(activity).hideProgressBar();
    }

    @Test
    public void testOnStop() {
     //   baseFragment.onStop();
      // verify(basePresenter).onStop();
    }
}