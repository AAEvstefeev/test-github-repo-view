package com.example.alexev.npmtest.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpDelegate;


public class MvpAppCompatFragment extends Fragment
{
	private MvpDelegate<? extends MvpAppCompatFragment> mMvpDelegate;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getMvpDelegate().onCreate(savedInstanceState);
	}

	public void onStart()
	{
		super.onStart();

		getMvpDelegate().onAttach();
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();

		getMvpDelegate().onDetach();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();

		if (isRemoving())
		{
			getMvpDelegate().onDestroy();
		}
	}

	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);

		getMvpDelegate().onSaveInstanceState(outState);
	}

	public MvpDelegate getMvpDelegate()
	{
		if (mMvpDelegate == null)
		{
			mMvpDelegate = new MvpDelegate<>(this);
		}

		return mMvpDelegate;
	}
}