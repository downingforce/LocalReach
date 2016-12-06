package downingforce.localreach;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GuideStarService {

    public static void findCharities (String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = Constants.GuideStar_URL + Constants.GuideStar_LOCATION_QUERY_PARAMETER + ":" + location;
        Log.d("url", url);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("authorization", "Basic " + Constants.GuideStar_SearchApi_Key)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Charity> processResults(Response response) {
        ArrayList<Charity> charities = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject guideStarJSON = new JSONObject(jsonData);
                JSONArray charitiesJSON = guideStarJSON.getJSONArray("hits");
                for (int i = 0; i < charitiesJSON.length(); i++) {
                    JSONObject charityJSON = charitiesJSON.getJSONObject(i);
                    String ein = charityJSON.getString("ein");
                    String name = charityJSON.getString("organization_name");
                    String mission = charityJSON.getString("mission");
                    String city = charityJSON.getString("city");
                    String state = charityJSON.getString("state");
                    String zip = charityJSON.getString("zip");
                    String report = charityJSON.getString("public_report");
                    String website = charityJSON.getString("website");
                    String logo = charityJSON.getString("logo_url");
                    String nteecode = charityJSON.getString("nteecode");
                    if (logo.equals("null")) {
                        logo = "https://unsplash.it/200/300/?random";
                    }
                    Charity charity = new Charity(ein, name, mission, city, state, zip, report, website, logo, nteecode);
                    charities.add(charity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return charities;
    }

}