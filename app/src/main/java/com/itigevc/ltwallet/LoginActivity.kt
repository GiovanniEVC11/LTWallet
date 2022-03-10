package com.itigevc.ltwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.fragment.app.Fragment
import com.google.accompanist.pager.ExperimentalPagerApi
import com.itigevc.ltwallet.util.listener.OnFragmentActionsListener
import com.itigevc.ltwallet.view.OnBoardingUtilFragment
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), OnFragmentActionsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout_activity_login, OnBoardingUtilFragment())
            .commit()

    }

    override fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout_activity_login, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onClickBtnFragment() { Toast.makeText(this, "El botón ha sido pulsado", Toast.LENGTH_SHORT).show() }

}