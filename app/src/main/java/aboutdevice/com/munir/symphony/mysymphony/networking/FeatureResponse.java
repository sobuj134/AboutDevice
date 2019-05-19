package aboutdevice.com.munir.symphony.mysymphony.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aboutdevice.com.munir.symphony.mysymphony.data.model.Feature;

/**
 * Created by monir.sobuj on 7/18/2017.
 */

public class FeatureResponse<T> {

    @SerializedName("data")
    Feature data;
    @SerializedName("status")
    String status;
    @SerializedName("code")
    private int code;
    public Feature getData() {
        return data;
    }
    public void setData(Feature data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "data=" + data +
                ", status='" + status + '\'' +
                ", code=" + code +
                '}';
    }
}
