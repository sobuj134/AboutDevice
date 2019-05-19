package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class GameApps extends RealmObject {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "GameApps{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", shortDes='" + shortDes + '\'' +
                ", longDes='" + longDes + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
