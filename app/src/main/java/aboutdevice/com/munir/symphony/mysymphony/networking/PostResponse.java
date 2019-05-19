package aboutdevice.com.munir.symphony.mysymphony.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by monir.sobuj on 7/18/2017.
 */

public class PostResponse {

    @SerializedName("status")
    String status;
    @SerializedName("code")
    private int code;

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
        return "PostResponse{" +
                ", status='" + status + '\'' +
                ", code=" + code +
                '}';
    }
}
