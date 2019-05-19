package aboutdevice.com.munir.symphony.mysymphony.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;

import aboutdevice.com.munir.symphony.mysymphony.BaseActivity;
import aboutdevice.com.munir.symphony.mysymphony.MainActivity;
import aboutdevice.com.munir.symphony.mysymphony.MySymphonyApp;
import aboutdevice.com.munir.symphony.mysymphony.R;
import aboutdevice.com.munir.symphony.mysymphony.adapter.FeatureAdapter;
import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.IFeature;
import aboutdevice.com.munir.symphony.mysymphony.fastadapter.INewsModel;
import aboutdevice.com.munir.symphony.mysymphony.utils.FetchJson;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by munirul.hoque on 5/16/2016.
 */
public class FeatureFragment extends Fragment{
    public String modelName;

    @BindView(R.id.txtmodelname)
    TextView txtModelName ;
    @BindView(R.id.feature_recycler)
    RecyclerView recyclerView;

    private View view;

    @Inject
    Feature feature;

    public FeatureFragment (){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_feature,container,false);

        MySymphonyApp.getComponent().inject(this);
        ButterKnife.bind(this, view);
        modelName = getSystemProperty("ro.product.device");

        final FastItemAdapter<IFeature> fastAdapter = new FastItemAdapter<>();
        fastAdapter.add(getFeature());
        fastAdapter.setHasStableIds(false);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(fastAdapter);
        txtModelName.setText(modelName);
        return view;
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

    List<IFeature> getFeature(){
        List<IFeature> iFeatureList = new ArrayList<>();

        IFeature iProcessor = new IFeature();
        IFeature iCamera = new IFeature();
        IFeature iDisplay = new IFeature();
        IFeature iMemory = new IFeature();
        IFeature iOs = new IFeature();
        IFeature iDataConnection = new IFeature();
        IFeature iConnectivity = new IFeature();
        IFeature iBattery = new IFeature();
        IFeature iSim = new IFeature();
        IFeature iSensor = new IFeature();
        IFeature iOthers = new IFeature();


        iProcessor.setFeatureType(0);
        iCamera.setFeatureType(1);
        iDisplay.setFeatureType(2);
        iMemory.setFeatureType(3);
        iOs.setFeatureType(4);
        iDataConnection.setFeatureType(5);
        iConnectivity.setFeatureType(6);
        iBattery.setFeatureType(7);
        iSim.setFeatureType(8);
        iSensor.setFeatureType(9);
        iOthers.setFeatureType(10);

        if(feature != null) {
            iProcessor.setName(feature.getProcessor());
            iCamera.setName(feature.getCamera());
            iDisplay.setName(feature.getDisplay());
            iMemory.setName(feature.getMemory());
            iOs.setName(feature.getOs());
            iDataConnection.setName(feature.getDataConnection());
            iConnectivity.setName(feature.getConnectivity());
            iBattery.setName(feature.getBattery());
            iSim.setName(feature.getSim());
            iSensor.setName(feature.getSensor());
        } else {
            iProcessor.setName("Processor");
            iCamera.setName("Camera");
            iDisplay.setName("Display");
            iMemory.setName("Memory");
            iOs.setName("OS");
            iDataConnection.setName("Data Connection");
            iConnectivity.setName("Connectivity");
            iBattery.setName("Battery");
            iSim.setName("SIM");
            iSensor.setName("Sensor");
        }


        iFeatureList.add(iProcessor);
        iFeatureList.add(iCamera);
        iFeatureList.add(iDisplay);
        iFeatureList.add(iMemory);
        iFeatureList.add(iOs);
        iFeatureList.add(iDataConnection);
        iFeatureList.add(iConnectivity);
        iFeatureList.add(iBattery);
        iFeatureList.add(iSim);
        iFeatureList.add(iSensor);

        if(feature != null && feature.getOthers() != null){

            iOthers.setName(feature.getOthers());
            iFeatureList.add(iOthers);
        }
        return iFeatureList;
    }
}
