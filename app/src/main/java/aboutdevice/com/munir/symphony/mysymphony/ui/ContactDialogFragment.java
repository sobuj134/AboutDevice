package aboutdevice.com.munir.symphony.mysymphony.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.R;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IFeature;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by munirul.hoque on 5/16/2016.
 */
public class ContactDialogFragment extends DialogFragment {

    @BindView(R.id.txtFirst)
    TextView txtFirst ;
    @BindView(R.id.txtSecond)
    TextView txtSecond;
    @BindView(R.id.txtFacebook)
    TextView txtFacebook;
    @BindView(R.id.txtWeb)
    TextView txtWeb;
    @BindView(R.id.btnCancel)
    Button btnCancel;

    public ContactDialogFragment(){
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment_contact, null);
        MySymphonyApp.getComponent().inject(this);
        ButterKnife.bind(this, v);



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        builder.setView(v);

        final AlertDialog alertDialog = builder.create();


        alertDialog.setCanceledOnTouchOutside(false);

        txtFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:16272"));
                startActivity(intent);
            }
        });

        txtSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:09666700666"));
                startActivity(intent);
            }
        });

        txtFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launchFacebook();
                alertDialog.dismiss();
                String url = "https://www.facebook.com/symphonymobile/";
                PackageManager pkm = getContext().getPackageManager();
                Intent i = newFacebookIntent(pkm,url);
                startActivity(i);

            }
        });

        txtWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                String url = "https://www.symphony-mobile.com";
                // Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(url));
                //startActivity(i);
                Intent intent = new Intent(MySymphonyApp.getContext(), NewsWebActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("targetUrl", url);
                intent.putExtra("SYSTRAY","systray");

                MySymphonyApp.getContext().startActivity(intent);


            }
        });



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


        return alertDialog;
    }

    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                // http://stackoverflow.com/a/24547437/1048340
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }

}
