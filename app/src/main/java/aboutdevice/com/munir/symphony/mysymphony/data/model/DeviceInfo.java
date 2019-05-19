package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class DeviceInfo extends RealmObject {

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("imei")
    @Expose
    private String imei;

    @SerializedName("mac")
    @Expose
    private String mac;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", imei='" + imei + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
