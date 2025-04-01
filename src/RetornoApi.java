import com.google.gson.annotations.SerializedName;

// Aqui eu defino o que vai vir no retorno da apiCotacao para que eu possa fazer o tratamento correto nela e consiga trazer comigo
// apenas o bid que seeria o valor atual da moeda selecionada, tbm altero o toString caso eu precise mexer com tais dados.

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
