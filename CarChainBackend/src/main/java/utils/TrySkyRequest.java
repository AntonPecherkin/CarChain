package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.CarClass;
import entities.Example;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;

import static controllers.SkyScannerRedirectController.*;

public class TrySkyRequest {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet();
        String uri = SCYCSANNER_HOST + GET_CARS + "?" + APIKEY +
                "&" + USERIP;
        request.setURI(new URI(uri));
        request.addHeader("content-type",
                "application/x-www-form-urlencoded");
        request.addHeader("accept", "application/json");
        HttpResponse response;
        String result = null;
        InputStream instream = null;
        response = client.execute(request);
        HttpEntity entity = response.getEntity();
        instream = entity.getContent();
        String json = IOUtils.toString(instream);
        Reader reader = new InputStreamReader(instream);
        Gson gson = new GsonBuilder().create();
        Example cars = gson.fromJson(json, Example.class);
        reader.close();
        instream.close();
        System.out.println(cars);
    }
}
