# AdmobUsingSimple1
Admob using by Abdujabbor
**Ad implementation**
```
    implementation( "com.google.android.gms:play-services-ads:22.5.0")

```
**Id for your app**
```
    ca-app-pub-8556591133225509~9357814990

```
**Id for banner ads**
```
    ca-app-pub-8556591133225509/5427729728

```

**Id for interstitial ads**
```
    ca-app-pub-8556591133225509/1570862300
```

**Id for rewarded ads**
```
ca-app-pub-8556591133225509/8922700722
```
**Using from this**
```
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
```

** I am happy for your coding😊😊😊😊**
