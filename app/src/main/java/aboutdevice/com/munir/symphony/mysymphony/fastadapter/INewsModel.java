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

public class INewsModel extends RealmObject implements IItem<INewsModel, INewsModel.ViewHolder> {

    /***id	3
     title	"Title"
     description	"description"
     top_card	"1"
     user_segment	"user_segment"
     series	"All"
     type	"promotion"
     open_activity	"News Activity"
     sw_version	"sw_version"
     image_url	"image_url"
     video_url	"video_url"
     link	"link"
     created_at	"2018-12-29 07:38:13"
     updated_at	"2018-12-29 07:38:13"*/

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("top_card")
    @Expose
    private String topCard;

    @SerializedName("user_segment")
    @Expose
    private String userSegment;

    @SerializedName("series")
    @Expose
    private String series;

    @SerializedName("type")
    @Expose
    private String newsType;

    @SerializedName("open_activity")
    @Expose
    private String openActivity;

    @SerializedName("sw_version")
    @Expose
    private String swVersion;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("video_url")
    @Expose
    private String videoUrl;

    @SerializedName("link")
    @Expose
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopCard() {
        return topCard;
    }

    public void setTopCard(String topCard) {
        this.topCard = topCard;
    }

    public String getUserSegment() {
        return userSegment;
    }

    public void setUserSegment(String userSegment) {
        this.userSegment = userSegment;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getOpenActivity() {
        return openActivity;
    }

    public void setOpenActivity(String openActivity) {
        this.openActivity = openActivity;
    }

    public String getSwVersion() {
        return swVersion;
    }

    public void setSwVersion(String swVersion) {
        this.swVersion = swVersion;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", topCard='" + topCard + '\'' +
                ", userSegment='" + userSegment + '\'' +
                ", series='" + series + '\'' +
                ", type='" + newsType + '\'' +
                ", openActivity='" + openActivity + '\'' +
                ", swVersion='" + swVersion + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", link='" + link + '\'' +
                '}';
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
    public Object getTag() {
        return tag;
    }

    @Override
    public INewsModel withTag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public INewsModel withEnabled(boolean enabled) {
        this.isEnabled = enabled;
        return this;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public INewsModel withSetSelected(boolean selected) {
        isSelected = selected;
        return this;
    }


    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public INewsModel withSelectable(boolean selectable) {
        this.isSelectable = selectable;
        return this;
    }

    @Override
    public int getType() {
        return R.id.rv_news;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_news;
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
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Temp.itemWidth.x, ViewGroup.LayoutParams.MATCH_PARENT);
        holder.itemCard.setLayoutParams(params);
        holder.txtNewsTitle.setText(title);
        Picasso.get().load(imageUrl).into(holder.ivNews);
        //Glide.with(ctx).load(imageUrl).into(holder.ivNews);
    }

    @Override
    public void unbindView(ViewHolder holder) {
        holder.ivNews.setImageDrawable(null);
    }

    @Override
    public boolean equals(int code) {
        return false;
    }

    @Override
    public INewsModel withIdentifier(long identifier) {
        return this;
    }

    @Override
    public long getIdentifier() {
        return id;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected View view;
        @BindView(R.id.ivNews)
        ImageView ivNews;
        @BindView(R.id.itemCard)
        CardView itemCard;
        @BindView(R.id.txtNewsTitle)
        TextView txtNewsTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }
    }
}
