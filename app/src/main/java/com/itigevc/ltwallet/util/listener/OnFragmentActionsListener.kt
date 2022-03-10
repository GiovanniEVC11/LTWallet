package com.itigevc.ltwallet.util.listener

import android.os.Bundle
import androidx.fragment.app.Fragment

interface OnFragmentActionsListener {

    fun replaceFragment(fragment: Fragment)

    fun onClickBtnFragment()

}