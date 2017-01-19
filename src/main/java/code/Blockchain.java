package code;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Blockchain {

    String username = "multichainrpc";
    String password = "GzWZYiSBmBFDYa4rA94d28AAC4t16abqCFbzGRiK98WR";
    String address = "127.0.0.1";
    String port = "5786";
    public Blockchain() {
    }

    public String getNewAddress(String method) {
        String result = null;
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://"+ username + ":" + password + "@" + address + ":" + port + "/")
                    .header("content-type", "text/plain")
                    .header("cache-control", "no-cache")
                    .body("\n{\"id\":\"curltest\", \"method\": \"" + method + "\" }")
                    .asJson();
            JSONObject obj = response.getBody().getObject();
            result = obj.getString("result");
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return result;
    }
}
