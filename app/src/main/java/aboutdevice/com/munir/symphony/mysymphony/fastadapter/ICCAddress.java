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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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

public class ICCAddress extends RealmObject implements IItem<ICCAddress, ICCAddress.ViewHolder> {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("address")
    @Expose
    private String address;

    @Ignore
    private Object tag;// defines if this item is isSelectable
    @Ignore
    private boolean isSelectable = true;
    @Ignore
    private boolean isEnabled = true;
    @Ignore
    private boolean isSelected = false; // defines if the item is selected

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CCAddress{" +
                "name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public ICCAddress withTag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public ICCAddress withEnabled(boolean enabled) {
        this.isEnabled = enabled;
        return this;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public ICCAddress withSetSelected(boolean selected) {
        isSelected = selected;
        return this;
    }


    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public ICCAddress withSelectable(boolean selectable) {
        this.isSelectable = selectable;
        return this;
    }

    @Override
    public int getType() {
        return R.id.rv_news;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.list_item_cc;
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

        holder.txtCCName.setText(name);
        holder.txtCCAddress.setText(address);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.txtCCName.setText(null);
        holder.txtCCAddress.setText(null);
    }

    @Override
    public boolean equals(int code) {
        return false;
    }

    @Override
    public ICCAddress withIdentifier(long identifier) {
        return this;
    }

    @Override
    public long getIdentifier() {
        return id;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected View view;
        @BindView(R.id.itemCard)
        CardView itemCard;
        @BindView(R.id.txtCCName)
        TextView txtCCName;
        @BindView(R.id.txtCCAddress)
        TextView txtCCAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
