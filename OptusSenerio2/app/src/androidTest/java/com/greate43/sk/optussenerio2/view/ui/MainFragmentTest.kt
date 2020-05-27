package com.greate43.sk.optussenerio2.view.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.greate43.sk.optussenerio2.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainFragmentTest {
    val TAG = MainFragmentTest::class.java.simpleName
    private lateinit var scenario: FragmentScenario<MainFragment>

    @Before
    fun setup() {
        scenario = launchFragment<MainFragment>()

    }

    @Test
    fun test_getItemCount() {
        scenario.onFragment {
            scenario.onFragment { mainFragment ->
                mainFragment.mainViewModel.listUser().observe(mainFragment.viewLifecycleOwner,
                    androidx.lifecycle.Observer { it ->
                        it.let {
                            mainFragment.adapter.setData(it)
                            //initial state
                            val initialExpected = 10
                            val initialActual: Int = mainFragment.adapter.itemCount
                            Assert.assertEquals(initialExpected, initialActual)
                        }
                    })
            }
        }
    }

    @Test
    fun checkIfTitleHasTheData() {
        scenario.onFragment { mainFragment ->
            Assert.assertEquals(mainFragment.activity?.title ,mainFragment.getString(R.string.userInfoTitle))
        }
    }
}