import com.google.gson.annotations.SerializedName;

public class RetornoApi {
    public String code;
    public String codein;
    public String name;
    public String high;
    public String low;
    public String varBid;
    public String pctChange;
    public double bid;
    public String ask;
    public String timestamp;

    @SerializedName("create_date")
    public String createDate;

    @Override
    public String toString() {
        return "RetornoApi{" +
                "code='" + code + '\'' +
                ", codein='" + codein + '\'' +
                ", name='" + name + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", varBid='" + varBid + '\'' +
                ", pctChange='" + pctChange + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
