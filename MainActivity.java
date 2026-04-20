import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myTvWeb;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTvWeb = findViewById(R.id.myTvWeb);
        WebSettings webSettings = myTvWeb.getSettings();
        
        // Video play karne ki zaroori settings
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false); // Autoplay allowed
        webSettings.setAllowFileAccess(true);

        // *** SABSE MAIN DESI JUGAD ***
        // Ye TV browser ko ek Powerful Desktop Chrome browser bana dega
        String desktopAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36";
        webSettings.setUserAgentString(desktopAgent);

        // App ko bahar (Chrome me) khulne se rokne ke liye
        myTvWeb.setWebViewClient(new WebViewClient());
        
        // HTML5 Videos ko smoothly load karne ke liye
        myTvWeb.setWebChromeClient(new WebChromeClient());

        // Aapka GitHub link load karein
        myTvWeb.loadUrl("https://manish910527-ai.github.io/Android-app/");
    }
    
    // Remote ke Back button ka sahi istemaal
    @Override
    public void onBackPressed() {
        if (myTvWeb.canGoBack()) {
            myTvWeb.goBack(); // Pichle page par wapas le jaye
        } else {
            super.onBackPressed(); // App band kar de
        }
    }
}
