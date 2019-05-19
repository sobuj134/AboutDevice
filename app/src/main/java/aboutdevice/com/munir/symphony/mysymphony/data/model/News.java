package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class News extends RealmObject {
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
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", topCard='" + topCard + '\'' +
                ", userSegment='" + userSegment + '\'' +
                ", series='" + series + '\'' +
                ", type='" + type + '\'' +
                ", openActivity='" + openActivity + '\'' +
                ", swVersion='" + swVersion + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
