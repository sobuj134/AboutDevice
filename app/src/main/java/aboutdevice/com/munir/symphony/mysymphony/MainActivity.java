package aboutdevice.com.munir.symphony.mysymphony;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import aboutdevice.com.munir.symphony.mysymphony.networking.DataSync;
import aboutdevice.com.munir.symphony.mysymphony.networking.DataSyncListener;
import aboutdevice.com.munir.symphony.mysymphony.ui.LoginActivity;
import aboutdevice.com.munir.symphony.mysymphony.ui.NewsListActivity;
import aboutdevice.com.munir.symphony.mysymphony.ui.NewsWebActivity;
import aboutdevice.com.munir.symphony.mysymphony.ui.MainFragment;
import aboutdevice.com.munir.symphony.mysymphony.ui.UserProfileActivity;
import aboutdevice.com.munir.symphony.mysymphony.utils.ConnectionUTils;
import aboutdevice.com.munir.symphony.mysymphony.utils.LoadingDialog;
import aboutdevice.com.munir.symphony.mysymphony.utils.Temp;
import butterknife.ButterKnife;

import static aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp.getContext;
import static aboutdevice.com.munir.symphony.mysymphony.ui.FourFrgment.newFacebookIntent;


public class MainActivity extends BaseActivity implements DataSyncListener {
    private static final String TAG = "MainActivity";
    public AdView mAdView;
    public static final  int REQUEST_INVITE = 1;
    public String userLocality = "";
    private String brand = Build.BRAND;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    DataSync dataSync;
    LoadingDialog loadingDialog;
    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySymphonyApp.getComponent().inject(this);
        ButterKnife.bind(this);
        getItemWidth();
        isGooglePlayServicesAvailable(this);
        MobileAds.initialize(getContext(), "ca-app-pub-4365083222822400~7196026575");
        mAdView = (AdView)findViewById(R.id.adView);
        loadingDialog = LoadingDialog.newInstance(this, "Please Wait!!");
        if(ConnectionUTils.isNetworkConnected(this)){
            dataSync = new DataSync(this);
            dataSync.getFeature();
            loadingDialog.show();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public boolean isGooglePlayServicesAvailable(Activity activity) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int status = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        if (status != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(status)) {
                Dialog df = googleApiAvailability.getErrorDialog(activity, status, 2404);
                df.setCancelable(false);
                df.show();
            }
            return false;
        }
        return true;
    }
    public String getSystemProperty(String key) {
        String value = null;

        try {
            value = (String) Class.forName("android.os.SystemProperties")
                    .getMethod("get", String.class).invoke(null, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }


    public void loadNews(View view){
        Intent intent = new Intent(getContext(), NewsListActivity.class);
        startActivity(intent);
    }

    public void loadInvitation(View view){
        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                .setMessage(getString(R.string.invitation_message))
                .setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
                .setCustomImage(Uri.parse(getString(R.string.invitation_custom_image)))
                .setCallToActionText(getString(R.string.invitation_cta))
                .build();
        startActivityForResult(intent, REQUEST_INVITE);
    }

    public void loadFeatureFragment(View v){

    }

    public void loadContactFragment(View v){

    }

    public void loadCCFragment(View v){

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);
        if(requestCode == REQUEST_INVITE){
            if(resultCode == RESULT_OK){
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode,data);
                for(String id : ids){
                    Log.d(TAG, "onActivityResult: sent invitation " + id);
                }
            }
            else{
                Toast.makeText(this,getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void logout() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                });
    }

    public void editProfile(View view){
        Intent i  = new Intent(this, UserProfileActivity.class);
        i.putExtra("USERDATA","");
        startActivity(i);
    }


    public void loadFacebook(View v){
        String url = "https://www.facebook.com/symphonymobile/";
        PackageManager pkm = getContext().getPackageManager();
        Intent i = newFacebookIntent(pkm,url);
        startActivity(i);
    }

    public void loadWeb(View v){
        String url = "https://www.symphony-mobile.com";
        Intent intent = new Intent(MySymphonyApp.getContext(), NewsWebActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("targetUrl", url);
        intent.putExtra("SYSTRAY","systray");
        MySymphonyApp.getContext().startActivity(intent);
    }

    public void loadInstagram(View v){
        Uri uri = Uri.parse("http://instagram.com/_u/symphony_mobile/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/symphony_mobile/")));
        }
    }


    @Override
    public void onSuccess() {
        loadingDialog.dismiss();
        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).addToBackStack("one").commit();
    }

    @Override
    public void onError() {
    loadingDialog.dismiss();
    }

    public void getItemWidth(){
        if(!Temp.IS_ITEM_WIDTH_CAL){
            Rect rect = new Rect();
            Window win = getWindow();
            win.getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = rect.top;
            int contentViewTop = win.findViewById(Window.ID_ANDROID_CONTENT).getTop();
            int titleBarHeight = contentViewTop - statusBarHeight;
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int screenHeight = metrics.heightPixels;
            int screenWidth = metrics.widthPixels;
            int layoutHeight = screenHeight - (titleBarHeight + statusBarHeight);
            int layoutWidth = screenWidth * 2 / 3;
            Temp.itemWidth  = new Point(layoutWidth, layoutHeight);
            Temp.IS_ITEM_WIDTH_CAL = true;
        }
    }
}