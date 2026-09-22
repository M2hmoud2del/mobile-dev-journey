package com.excercise.androidads

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.excercise.androidads.ui.theme.AndroidAdsTheme
import com.google.android.libraries.ads.mobile.sdk.MobileAds
import com.google.android.libraries.ads.mobile.sdk.banner.AdSize
import com.google.android.libraries.ads.mobile.sdk.banner.AdView
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAd
import com.google.android.libraries.ads.mobile.sdk.banner.BannerAdRequest
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadResult
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest
import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationConfig
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAd
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAdEventCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val backgroundScope = CoroutineScope(Dispatchers.IO)
        backgroundScope.launch {
            MobileAds.initialize(
                this@MainActivity,
                InitializationConfig.Builder("ca-app-pub-3940256099942544~3347511713").build()
            ) { }
        }

        enableEdgeToEdge()
        setContent {
            AndroidAdsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        BannerAd()
        MInterstitialAd()
    }
}

@Composable
fun BannerAd(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { ctx ->
            AdView(ctx).apply {
                val adSize = AdSize.getLargeAnchoredAdaptiveBannerAdSize(ctx, 360)
                val adRequest = BannerAdRequest.Builder(
                    "ca-app-pub-3940256099942544/9214589741",
                    adSize
                ).build()
                loadAd(adRequest, object : AdLoadCallback<BannerAd> {
                    override fun onAdLoaded(ad: BannerAd) {
                        Log.d("BannerAd", "Banner ad loaded successfully.")
                    }

                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.e("BannerAd", "Banner ad failed to load: $adError")
                    }
                })
            }
        },
        update = { adView ->
            adView.requestLayout()
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun MInterstitialAd(modifier: Modifier = Modifier) {
    var interstitialAd by remember { mutableStateOf<InterstitialAd?>(null) }
    val activity = LocalActivity.current

    LaunchedEffect(Unit) {
        InterstitialAd.load(
            AdRequest.Builder("ca-app-pub-3940256099942544/1033173712").build(),
            object : AdLoadCallback<InterstitialAd> {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    Log.d("MInterstitialAd", "Interstitial ad loaded successfully.")
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    interstitialAd = null
                    Log.e("MInterstitialAd", "Interstitial ad failed to load: $adError")
                }
            },
        )
    }

    Button(
        onClick = {
            activity?.let {
                showAd(interstitialAd, it)
            }
        }
    ) {
        Text("Next")
    }
}

private fun showAd(interstitialAd: InterstitialAd?, activity: Activity) {
    // Show the ad.
    val ad = interstitialAd
    if (ad != null) {
        ad.adEventCallback =
            object : InterstitialAdEventCallback {
                override fun onAdDismissedFullScreenContent() {
                    // Interstitial ad did dismiss.
                    //Navigate to second screen
                }

                override fun onAdFailedToShowFullScreenContent(fullScreenContentError: FullScreenContentError) {
                    // Navigate to second screen
                }
            }
        ad.show(activity)
    } else {
        // Navigate to second screen
    }
}
@Preview
@Composable
private fun HomeScreenPreview() {

}