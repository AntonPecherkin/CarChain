package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entities.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/*")
public class SkyScannerRedirectController {

    @Autowired
    private ObjectMapper objectMapper;

    public static final String SCYCSANNER_HOST = "http://partners.api.skyscanner.net";
    public static final String GET_CARS = "/apiservices/carhire/liveprices/v2/UK/GBP/en-GB/EDI/EDI/2019-07-01T10:00/";
    public static final String APIKEY = "apikey=ah016404381349804974592181457198";
    public static final String USERIP = "userip=10.90.23.72";

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private List<CarModified> carsWeProcess = new ArrayList<>();

    /*private CarsRepository carsRepository;

    SkyScannerRedirectController(CarsRepository carsRepository){
        this.carsRepository = carsRepository;
    }*/


    @RequestMapping("/getCars")
    public List<CarModified> getCars(
            @RequestParam(value = "startlon", defaultValue = "55") String startlon,
            @RequestParam(value = "startlat", defaultValue = "38") String startlat,
            @RequestParam(value = "finlon", defaultValue = "56") String finlon,
            @RequestParam(value = "start", defaultValue = "40") String finlat,
            @RequestParam(value = "startTime", defaultValue = "2019-07-01T10:00") String startTime
    ) throws IOException, URISyntaxException {

        Example recievedList = requestToSkyScanner(startlon, startlat, finlon, finlat, startTime);
        List<Car> cars = recievedList != null ? recievedList.getCars() : new ArrayList<>();
        cars = cars != null ? cars.subList(0, cars.size() < 5 ? cars.size() : 4) : new ArrayList<>();
        List<CarModified> modifyCars = createCarModified(cars, recievedList.getImages());
        modifyCars.addAll(searchInOursCars(startlat, startlon, finlat, finlon, startTime));
        return modifyCars;
        /*return new CarClass(counter.incrementAndGet(),
                String.format(template, name));*/
    }

    @RequestMapping(value = "/postCar")
    public CarModified newCar(@RequestBody CarModified carModified) {
        /*return carsRepository.save(carModified);*/
        carsWeProcess.add(carModified);
        return carModified;
    }


    private Example requestToSkyScanner(String... params) throws URISyntaxException, IOException {

        //TODO enter the reques params in URI
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet();
        String uri = SCYCSANNER_HOST + GET_CARS + params[4] + "/35" + "?" + APIKEY +
                "&" + USERIP;
        request.setURI(new URI(uri));
        request.addHeader("content-type",
                "application/x-www-form-urlencoded");
        request.addHeader("accept", "application/json");
        HttpResponse response;
        String result = null;
        InputStream instream = null;
        Reader reader;
        try {
            response = client.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // A Simple JSON Response Read
                instream = entity.getContent();
                //String json = IOUtils.toString(response.getEntity().getContent());
                System.out.println("RESPONSE: " + result);
                reader = new InputStreamReader(instream);
                Gson gson = new GsonBuilder().create();
                Example exps = gson.fromJson(reader, Example.class);
                System.out.println(exps);
                return exps;
                /*if (response.getStatusLine().getStatusCode() == 200) {
                    netState.setLogginDone(true);
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (instream != null) {
                instream.close();
            }
        }
        return null;
    }

    /*private List<CarModified> modifyCar(List<Car> cars) {
        List<CarModified> carsModified = new ArrayList<>();
        Iterator<Car> itr = cars.iterator();
        for (Car car : cars) {
            carsModified.add(new CarModified(car, false));
        }
        return carsModified;
    }*/

    private List<CarModified> searchInOursCars(String... params) {
        //TODO implement the real search
        return carsWeProcess;
    }

    private List<CarModified> createCarModified(List<Car> cars, List<Image> images){
        List<CarModified> carsModified = new ArrayList<>();
        for(Car car : cars){
            for(Image image : images)
                if(car.getImageId().equals(image.getId())){
                   carsModified.add(new CarModified(car, false, image.getUrl())) ;
                   break;
                }
            carsModified.add(new CarModified(car, false, null));
        }
        return carsModified;
    }
}


