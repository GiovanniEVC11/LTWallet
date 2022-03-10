package com.itigevc.ltwallet.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
import com.itigevc.ltwallet.R
import com.itigevc.ltwallet.databinding.LaFragmentForgotpwdBinding
import com.itigevc.ltwallet.ui.theme.LTWalletTheme

//import com.itigevc.ltwallet.viewModel.login.AuthViewModel

class ForgotPwdLaFragment : Fragment(R.layout.la_fragment_forgotpwd) {

    private var _binding: LaFragmentForgotpwdBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LaFragmentForgotpwdBinding.inflate(inflater, container, false)
        val view = binding.root

        //val authViewModel: AuthViewModel by viewModels()

        binding.composeViewForgotPwd.apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                LTWalletTheme {
                    //composeViewLogin(authViewModel)
                }
            }

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}