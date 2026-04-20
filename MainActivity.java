import android.annotation.SuppressLint;
import android.os.Bundle;
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

        // XML wale WebView ko Java se connect kar rahe hain
        myTvWeb = findViewById(R.id.myTvWeb);
        WebSettings webSettings = myTvWeb.getSettings();
        
        // Video play karne aur website properly load hone ke liye settings
        webSettings.setJavaScriptEnabled(true); // JS chalu karna zaroori hai
        webSettings.setDomStorageEnabled(true); 
        webSettings.setMediaPlaybackRequiresUserGesture(false); // TV par autoplay ke liye

        // App ko usi app me open rakhne ke liye (bahar Chrome me na khule)
        myTvWeb.setWebViewClient(new WebViewClient());

        // Aapka GitHub link jo sidha app khulte hi load hoga
        myTvWeb.loadUrl("https://manish910527-ai.github.io/Android-app/");
    }
    
    // TV remote ka 'Back' button dabane par kya hoga
    @Override
    public void onBackPressed() {
        if (myTvWeb.canGoBack()) {
            myTvWeb.goBack(); // Agar pichla page hai to wahan jaye
        } else {
            super.onBackPressed(); // Warna app band ho jaye
        }
    }
}
