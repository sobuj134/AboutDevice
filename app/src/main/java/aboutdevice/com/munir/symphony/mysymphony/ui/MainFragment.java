package aboutdevice.com.munir.symphony.mysymphony.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.util.List;

import javax.inject.Inject;

import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.R;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IAppGames;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.INewsModel;
import aboutdevice.com.munir.symphony.mysymphony.model.AppUser;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp.getContext;
import static aboutdevice.com.munir.symphony.mysymphony.ui.FourFrgment.newFacebookIntent;
import static android.app.Activity.RESULT_OK;


/**
 * Created by munirul.hoque on 5/16/2016.
 */
public class MainFragment extends Fragment {

    public static final  int REQUEST_INVITE = 1;

    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.iv_edit_profile)
    ImageView ivEditProfile;
    @BindView(R.id.txt_user_contact)
    TextView txtUserContact;
    @BindView(R.id.txt_user_mail)
    TextView txtUserMail;
    @BindView(R.id.iv_event_banner_1)
    ImageView ivEventBanner1;
    @BindView(R.id.iv_event_banner_2)
    ImageView ivEventBanner2;
    @BindView(R.id.rv_apps_games)
    RecyclerView rvAppsGames;
    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    @BindView(R.id.civ_profile)
    CircleImageView civProfile;

    @Inject
    List<INewsModel> iNewsModelList;

    @Inject
    List<IAppGames> iAppGameList;

    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_new, container, false);
        MySymphonyApp.getComponent().inject(this);
        ButterKnife.bind(this, view);

        final FastItemAdapter<INewsModel> fastAdapter = new FastItemAdapter<>();
        fastAdapter.add(iNewsModelList);
        fastAdapter.setHasStableIds(false);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(fastAdapter);
        fastAdapter.withOnClickListener(new FastAdapter.OnClickListener<INewsModel>() {
            @Override
            public boolean onClick(View v, IAdapter<INewsModel> adapter, INewsModel item, int position) {
                Intent intent = new Intent(getActivity(), NewsListActivity.class);
                startActivity(intent);
                return false;
            }
        });

        final FastItemAdapter<IAppGames> fastAdapterApp = new FastItemAdapter<>();
        fastAdapterApp.add(iAppGameList);
        fastAdapterApp.setHasStableIds(false);
        rvAppsGames.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvAppsGames.setAdapter(fastAdapterApp);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
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



    @Override
    public void onStop() {
        super.onStop();
    }

    public void UpdateUI(AppUser appUser) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



    public void fetchRemoteConfig() {
        long cacheExpiration = 3600;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.ll_features, R.id.ll_cc, R.id.ll_contact, R.id.txt_apps_games_all, R.id.ll_facebook, R.id.ll_instagram, R.id.ll_web_browser, R.id.ll_invite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_features:
                Fragment fragment = new FeatureFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).addToBackStack("feature").commit();
                break;
            case R.id.ll_cc:
                break;
            case R.id.ll_contact:
                DialogFragment dialogFragment = new ContactDialogFragment();
                dialogFragment.show(getFragmentManager(), "dialogContact");
                break;
            case R.id.txt_apps_games_all:
                break;
            case R.id.ll_facebook:
                loadFacebook(view);
                break;
            case R.id.ll_instagram:
                loadInstagram(view);
                break;
            case R.id.ll_web_browser:
                loadWeb(view);
                break;
            case R.id.ll_invite:
                loadInvitation(view);
                break;
        }
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainFragment", "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);
        if(requestCode == REQUEST_INVITE){
            if(resultCode == RESULT_OK){
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode,data);
                for(String id : ids){
                    Log.d("MainFragment", "onActivityResult: sent invitation " + id);
                }
            }
            else{
                Toast.makeText(getActivity(),getString(R.string.send_failed),Toast.LENGTH_SHORT).show();
            }
        }

    }

}