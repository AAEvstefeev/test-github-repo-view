package com.example.alexev.npmtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.alexev.npmtest.activitys.MainActivity;
import com.example.alexev.npmtest.fragments.RepoListFragment;
import com.example.alexev.npmtest.presenters.RepoListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

public class RepoListFragmentTest extends BaseTest {

    @Inject
    protected RepoListPresenter repoListPresenter;

    private RepoListFragment repoListFragment;
    private MainActivity activity;

    private Bundle bundle;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
      //  ((TestComponent)(TestApplication.getComponent())).inject(this);
       /* TestViewComponent testViewComponent = DaggerTestViewComponent.builder()
                .testViewDynamicModule(new TestViewDynamicModule())
                .build();*/

   //     testViewComponent.inject(this);
        component.inject(this);
        repoListFragment = new RepoListFragment();
        activity = Robolectric.setupActivity(MainActivity.class);
        bundle = Bundle.EMPTY;

     //   repoListFragment.setViewComponent(testViewComponent);

        repoListFragment.onCreate(null); // need for DI
    }


    @Test
    public void testOnCreateView() {
        repoListFragment.onCreateView(LayoutInflater.from(activity), (ViewGroup) activity.findViewById(R.id.repositories_list_fragment), null);
        verify(repoListPresenter).onCreate();
    }

    @Test
    public void testOnCreateViewWithBundle() {
        //repoListFragment.onCreateView(LayoutInflater.from(activity), (ViewGroup) activity.findViewById(R.id.container), bundle);
        //(repoListPresenter).onCreateView(bundle);
    }

    @Test
    public void testOnStop() {
        repoListFragment.onStop();
      //  verify(repoListPresenter).onStop();
    }

    @Test
    public void testOnDestroy() {
        repoListFragment.onDestroy();
          verify(repoListPresenter).onDestroy();
    }

    @Test
    public void testOnSaveInstanceState() {
        repoListFragment.onSaveInstanceState(null);
      //  verify(repoListPresenter).onSaveInstanceState(null);
    }

    @Test
    public void testOnSaveInstanceStateWithBundle() {
        repoListFragment.onSaveInstanceState(bundle);
      //  verify(repoListPresenter)..onSaveInstanceState(bundle);
    }


}