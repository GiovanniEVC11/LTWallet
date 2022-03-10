package com.itigevc.ltwallet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*

import com.itigevc.ltwallet.databinding.UtilFragmentOnboardingBinding
import com.itigevc.ltwallet.domain.model.OnBoardingPage
import com.itigevc.ltwallet.ui.theme.LTWalletTheme
import com.itigevc.ltwallet.viewmodel.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class OnBoardingUtilFragment : Fragment() {

    private var _binding: UtilFragmentOnboardingBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = UtilFragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        val onBoardingViewModel: OnBoardingViewModel by viewModels()

        binding.composeViewOnBoarding.apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                LTWalletTheme {
                    WelcomeScreen(welcomeViewModel = onBoardingViewModel)
                }
            }

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @ExperimentalAnimationApi
    @ExperimentalPagerApi
    @Composable
    fun WelcomeScreen(welcomeViewModel: OnBoardingViewModel)
    {
        val pages = listOf(
            OnBoardingPage.First,
            OnBoardingPage.Second,
            OnBoardingPage.Third
        )
        val pagerState = rememberPagerState()

        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                modifier = Modifier.weight(10f),
                count = 3,
                state = pagerState,
                verticalAlignment = Alignment.Top
            ) { position ->
                PagerScreen(onBoardingPage = pages[position])
            }
            HorizontalPagerIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                pagerState = pagerState
            )
            FinishButton(
                modifier = Modifier.weight(1f),
                pagerState = pagerState
            ) {
                welcomeViewModel.saveOnBoardingState(completed = true)
            }
        }
    }

    @Composable
    fun PagerScreen(onBoardingPage: OnBoardingPage) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.7f),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "Pager Image"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = onBoardingPage.title,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .padding(top = 20.dp),
                text = onBoardingPage.description,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }

    @ExperimentalAnimationApi
    @ExperimentalPagerApi
    @Composable
    fun FinishButton(
        modifier: Modifier,
        pagerState: PagerState,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage == 2
            ) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Finish")
                }
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun FirstOnBoardingScreenPreview() {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.First)
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun SecondOnBoardingScreenPreview() {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.Second)
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun ThirdOnBoardingScreenPreview() {
        Column(modifier = Modifier.fillMaxSize()) {
            PagerScreen(onBoardingPage = OnBoardingPage.Third)
        }
    }

}