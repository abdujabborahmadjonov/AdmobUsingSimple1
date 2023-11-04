package dev.abdujabbor.admobusingsimple1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import dev.abdujabbor.admobusingsimple1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.bannerID.loadAd(adRequest) // Banner load

        binding.btnInterstitialAd.setOnClickListener {
            InterstitialAd.load(this,
                INTERSTITIAL_AD,
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        showMessage(adError.message)
                        mInterstitialAd = null
                        Intent(this@MainActivity, MainActivity2::class.java).apply {
                            startActivity(this)
                        }
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        showMessage("adinfo")
                        mInterstitialAd = interstitialAd
                        mInterstitialAd?.show(this@MainActivity)
                    }
                })
        }

    }
    private fun setBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    private fun showMessage(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }
    companion object {
        private const val TAG = "ANDROID ADMOB SAMPLE"
        private const val INTERSTITIAL_AD = "ca-app-pub-8556591133225509/1570862300"
        private const val REWARDED_AD = "ca-app-pub-8556591133225509/8922700722"
    }
}