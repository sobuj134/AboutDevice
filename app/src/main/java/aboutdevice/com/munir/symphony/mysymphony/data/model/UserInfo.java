package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class UserInfo extends RealmObject {

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("profile_url")
    @Expose
    private String profileUrl;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                '}';
    }
}
