package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Offer extends RealmObject {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("style")
    @Expose
    private String style;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("video_url")
    @Expose
    private String videoUrl;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("visible")
    @Expose
    private String visible;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "title='" + title + '\'' +
                ", style='" + style + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", link='" + link + '\'' +
                ", visible='" + visible + '\'' +
                '}';
    }
}
