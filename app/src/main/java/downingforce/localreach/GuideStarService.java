package downingforce.localreach;


import android.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
}