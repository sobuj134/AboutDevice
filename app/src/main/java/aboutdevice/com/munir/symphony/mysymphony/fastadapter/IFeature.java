package aboutdevice.com.munir.symphony.mysymphony.fastadapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikepenz.fastadapter.IItem;

import java.util.Collections;
import java.util.List;

import aboutdevice.com.munir.symphony.mysymphony.R;
import aboutdevice.com.munir.symphony.mysymphony.utils.Temp;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by monir.sobuj on 6/8/17.
 */

public class IFeature implements IItem<IFeature, IFeature.ViewHolder> {


    private int [] allIcons = {R.mipmap.processor, R.mipmap.camera, R.mipmap.display, R.mipmap.memory, R.mipmap.os,
            R.mipmap.data_connection, R.mipmap.connectivity,R.mipmap.battery,
            R.mipmap.sim, R.mipmap.sensor,R.mipmap.others};

    private int featureType;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFeatureType() {
        return featureType;
    }

    public void setFeatureType(int featureType) {
        this.featureType = featureType;
    }

    @Ignore
    private Object tag;// defines if this item is isSelectable
    @Ignore
    private boolean isSelectable = true;
    @Ignore
    private boolean isEnabled = true;
    @Ignore
    private boolean isSelected = false; // defines if the item is selected

    @Override
    public String toString() {
        return "GameApps{" +
                "name='" + name + '\'' +
                ", type='" + featureType + '\'' +
                '}';
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public IFeature withTag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public IFeature withEnabled(boolean enabled) {
        this.isEnabled = enabled;
        return this;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public IFeature withSetSelected(boolean selected) {
        isSelected = selected;
        return this;
    }


    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public IFeature withSelectable(boolean selectable) {
        this.isSelectable = selectable;
        return this;
    }

    @Override
    public int getType() {
        return R.id.rv_news;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.feature_list;
    }

    @Override
    public View generateView(Context ctx) {
        ViewHolder viewHolder                           = getViewHolder(LayoutInflater.from(ctx).inflate(getLayoutRes(), null, false));
        bindView(viewHolder, Collections.EMPTY_LIST);
        return viewHolder.itemView;
    }

    @Override
    public View generateView(Context ctx, ViewGroup parent) {
        ViewHolder viewHolder                           = getViewHolder(LayoutInflater.from(ctx).inflate(getLayoutRes(), parent, false));
        bindView(viewHolder, Collections.EMPTY_LIST);
        return viewHolder.itemView;
    }

    private ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder getViewHolder(ViewGroup parent) {
        return getViewHolder(LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false));
    }

    @Override
    public void bindView(ViewHolder holder, List<Object> payloads) {

        Context ctx = holder.itemView.getContext();
        holder.featureText.setText(name);
        Glide.with(ctx).load(allIcons[featureType]).into(holder.featureIcon);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.featureIcon.setImageDrawable(null);
        holder.featureText.setText(null);
    }

    @Override
    public boolean equals(int code) {
        return false;
    }

    @Override
    public IFeature withIdentifier(long identifier) {
        return this;
    }

    @Override
    public long getIdentifier() {
        return featureType;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected View view;
        @BindView(R.id.feature_icon)
        ImageView featureIcon;
        @BindView(R.id.feature_text)
        TextView featureText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
