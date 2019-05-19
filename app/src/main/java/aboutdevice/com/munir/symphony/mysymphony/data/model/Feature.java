package aboutdevice.com.munir.symphony.mysymphony.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Feature extends RealmObject {

    /*"id": 9,
        "model_name": "V135",
        "processor": "Quad Core Processor 1.3GHz Cortex-A7",
        "camera": "5MP + 5MP Camera Dual Flash",
        "display": "5.34'' FWVGA+ TN Display 18:9 Wide Screen Full Vision Mali-400 GPU",
        "memory": "8GB ROM + 1GB RAM",
        "os": "Android GO 8.1.0",
        "data_connection": "3G HSPA+,EDGE",
        "connectivity": "Wi-Fi, BT, GPS",
        "battery": "2150mAH Li-ion Battery",
        "sim": "Dual Micro SIM",
        "sensor": "G-Sensor,Proximity,Light",
        "others": null,
        "created_at": "2019-02-18 11:10:11",
        "updated_at": "2019-02-18 11:10:11"*/
    @SerializedName("model_name")
    @Expose
    private String modelName;

    @SerializedName("processor")
    @Expose
    private String processor;

    @SerializedName("camera")
    @Expose
    private String camera;

    @SerializedName("display")
    @Expose
    private String display;

    @SerializedName("memory")
    @Expose
    private String memory;

    @SerializedName("os")
    @Expose
    private String os;

    @SerializedName("data_connection")
    @Expose
    private String dataConnection;

    @SerializedName("connectivity")
    @Expose
    private String connectivity;

    @SerializedName("battery")
    @Expose
    private String battery;

    @SerializedName("sim")
    @Expose
    private String sim;

    @SerializedName("sensor")
    @Expose
    private String sensor;

    @SerializedName("others")
    @Expose
    private String others;


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDataConnection() {
        return dataConnection;
    }

    public void setDataConnection(String dataConnection) {
        this.dataConnection = dataConnection;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "modelName='" + modelName + '\'' +
                ", processor='" + processor + '\'' +
                ", camera='" + camera + '\'' +
                ", display='" + display + '\'' +
                ", memory='" + memory + '\'' +
                ", os='" + os + '\'' +
                ", dataConnection='" + dataConnection + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", battery='" + battery + '\'' +
                ", sim='" + sim + '\'' +
                ", sensor='" + sensor + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}
