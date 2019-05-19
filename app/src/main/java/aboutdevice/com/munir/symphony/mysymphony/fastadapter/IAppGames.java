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
import com.squareup.picasso.Picasso;

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

public class IAppGames extends RealmObject implements IItem<IAppGames, IAppGames.ViewHolder> {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String appType;

    @SerializedName("short_description")
    @Expose
    private String shortDes;

    @SerializedName("long_description")
    @Expose
    private String longDes;

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("priority")
    @Expose
    private String priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getLongDes() {
        return longDes;
    }

    public void setLongDes(String longDes) {
        this.longDes = longDes;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                ", type='" + appType + '\'' +
                ", shortDes='" + shortDes + '\'' +
                ", longDes='" + longDes + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    @Override
    public Object getTag() {
        return tag;
    }

    @Override
    public IAppGames withTag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public IAppGames withEnabled(boolean enabled) {
        this.isEnabled = enabled;
        return this;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public IAppGames withSetSelected(boolean selected) {
        isSelected = selected;
        return this;
    }


    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public IAppGames withSelectable(boolean selectable) {
        this.isSelectable = selectable;
        return this;
    }

    @Override
    public int getType() {
        return R.id.rv_news;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_apps_games;
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
        holder.txtAppName.setText(name);
        Picasso.get().load(imageUrl).into(holder.ivAppIcon);
        //Glide.with(ctx).load(iconUrl).into(holder.ivAppIcon);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.ivAppIcon.setImageDrawable(null);
    }

    @Override
    public boolean equals(int code) {
        return false;
    }

    @Override
    public IAppGames withIdentifier(long identifier) {
        return this;
    }

    @Override
    public long getIdentifier() {
        return id;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected View view;
        @BindView(R.id.ivAppIcon)
        ImageView ivAppIcon;
        @BindView(R.id.txtAppName)
        TextView txtAppName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
