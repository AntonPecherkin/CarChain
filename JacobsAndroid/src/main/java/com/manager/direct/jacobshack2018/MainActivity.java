package com.manager.direct.jacobshack2018;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.here.android.mpa.common.GeoBoundingBox;
import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.common.ViewObject;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapGesture;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;
import com.here.android.mpa.mapping.MapRoute;
import com.here.android.mpa.mapping.MapScreenMarker;
import com.here.android.mpa.routing.CoreRouter;
import com.here.android.mpa.routing.RouteOptions;
import com.here.android.mpa.routing.RoutePlan;
import com.here.android.mpa.routing.RouteResult;
import com.here.android.mpa.routing.RouteWaypoint;
import com.here.android.mpa.routing.Router;
import com.here.android.mpa.routing.RoutingError;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Map map = null;
    private MapMarker m_map_marker;
    private String tx;
    public static int count = 0;
    private MapRoute m_mapRoute;
    private EditText date;
    private GeoCoordinate startPoint;
    private ProgressBar progressBar;
    private GeoCoordinate endPoint;
    private static Image m_marker_image;
    // map fragment embedded in this activity
    private MapFragment mapFragment = null;
    private MapScreenMarker m_tap_marker;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        date= findViewById(R.id.editplay);
        button = findViewById(R.id.butSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RentList.class);
                if(startPoint != null)
                    intent.putExtra("description", startPoint.getLatitude());
                else
                    intent.putExtra("description",0.0);
                intent.putExtra("date", date.getText().toString());
                startActivity(intent);



            }
        });
        initialize();
    }


    private MapFragment getMapFragment() {
        return (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
    }


    private void initialize() {


        // Search for the map fragment to finish setup by calling init().
        mapFragment = getMapFragment();

        // Set up disk cache path for the map service for this application
        boolean success = com.here.android.mpa.common.MapSettings.setIsolatedDiskCacheRootPath(
                getApplicationContext().getExternalFilesDir(null) + File.separator + ".here-maps",
                "com.here.android.tutorial.MapService");

        if (!success) {
            Toast.makeText(getApplicationContext(), "Unable to set isolated disk cache path.", Toast.LENGTH_LONG);
        } else {
            mapFragment.init(new OnEngineInitListener() {
                @Override
                public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {
                    if (error == OnEngineInitListener.Error.NONE) {
                        // retrieve a reference of the map from the map fragment
                        map = mapFragment.getMap();
                        // Set the map center to the Vancouver region (no animation)
                        map.setCenter(new GeoCoordinate(53.1687766,8.6609449, 0.0),
                                Map.Animation.NONE);
                        // Set the zoom level to the average between min and max
                        map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) / 2);
                        //createRoute(new GeoCoordinate(55.751244, 37.618523, 0.0),new GeoCoordinate(55.7624, 37.6223, 0.0));
                        //createMapMarker(map.getCenter());
                    } else {
                        System.out.println("ERROR: Cannot initialize Map Fragment");
                    }

                    m_marker_image = new Image();

                    try {
                        m_marker_image.setImageResource(R.drawable.iot);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mapFragment.getMapGesture()
                            .addOnGestureListener( new
                                                           MapGesture.OnGestureListener() {
                                                               @Override
                                                               public void onPanStart() {

                                                               }

                                                               @Override
                                                               public void onPanEnd() {

                                                               }

                                                               @Override
                                                               public void onMultiFingerManipulationStart() {

                                                               }

                                                               @Override
                                                               public void onMultiFingerManipulationEnd() {

                                                               }

                                                               @Override
                                                               public boolean onMapObjectsSelected(List<ViewObject> list) {

                                                                   for (ViewObject viewObject : list) {
                                                                       if (viewObject.getBaseType() == ViewObject.Type.USER_OBJECT) {
                                                                           MapObject mapObject = (MapObject) viewObject;

                                                                           if (mapObject.getType() == MapObject.Type.MARKER) {

                                                                               MapMarker window_marker = ((MapMarker)mapObject);
                                                                               Log.d("danish","danish");
                                                                               System.out.println("Title is................."+window_marker.getInfoBubbleHashCode());
                                                                               Toast.makeText(getApplicationContext(),"Hello"+window_marker.getCoordinate(),Toast.LENGTH_LONG).show();
//                                                                               Intent intent = new Intent();
//                                                                               intent.setClass(getApplicationContext(), BluetoothActivity.class);
//                                                                               intent.putExtra("description", window_marker.getDescription());
//                                                                               startActivity(intent);
//                                                                               finish();
                                                                               return false;
                                                                           }
                                                                       }
                                                                   }
                                                                   return false;
                                                               }

                                                               @Override
                                                               public boolean onTapEvent(PointF pointF) {

                                                                       createMapMarker(map.pixelToGeo(pointF));
                                                                       count++;
                                                                       if(count == 1) {
                                                                           startPoint = map.pixelToGeo(pointF);
                                                                       }
                                                                   else if(count == 2) {
                                                                       endPoint = map.pixelToGeo(pointF);
                                                                       createRoute(startPoint, endPoint);
                                                                   } else {
                                                                           count = 0;
                                                                   }

                                                                   return false;
                                                               }

                                                               @Override
                                                               public boolean onDoubleTapEvent(PointF pointF) {
                                                                   return false;
                                                               }

                                                               @Override
                                                               public void onPinchLocked() {

                                                               }

                                                               @Override
                                                               public boolean onPinchZoomEvent(float v, PointF pointF) {
                                                                   return false;
                                                               }

                                                               @Override
                                                               public void onRotateLocked() {

                                                               }

                                                               @Override
                                                               public boolean onRotateEvent(float v) {
                                                                   return false;
                                                               }

                                                               @Override
                                                               public boolean onTiltEvent(float v) {
                                                                   return false;
                                                               }

                                                               @Override
                                                               public boolean onLongPressEvent(PointF pointF) {
                                                                   return false;
                                                               }

                                                               @Override
                                                               public void onLongPressRelease() {

                                                               }

                                                               @Override
                                                               public boolean onTwoFingerTapEvent(PointF pointF) {
                                                                   return false;
                                                               }
                                                           }, 0, false);

                }
            });


        }
    }

    private void createMapMarker(GeoCoordinate geoCoordinate) {
        // create an image from cafe.png.
        Image marker_img = new Image();
        try {

            marker_img.setImageResource(R.drawable.iot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // create a MapMarker centered at current location with png image.
        m_map_marker = new MapMarker(geoCoordinate, marker_img);
       // add a MapMarker to current active map.
        map.addMapObject(m_map_marker);

    }

    private void createRoute(GeoCoordinate geoCoordinate1, GeoCoordinate geoCoordinate2) {
        /* Initialize a CoreRouter */
        CoreRouter coreRouter = new CoreRouter();

        /* Initialize a RoutePlan */
        RoutePlan routePlan = new RoutePlan();

        /*
         * Initialize a RouteOption.HERE SDK allow users to define their own parameters for the
         * route calculation,including transport modes,route types and route restrictions etc.Please
         * refer to API doc for full list of APIs
         */
        RouteOptions routeOptions = new RouteOptions();
        /* Other transport modes are also available e.g Pedestrian */
        routeOptions.setTransportMode(RouteOptions.TransportMode.CAR);
        /* Disable highway in this route. */
        routeOptions.setHighwaysAllowed(false);
        /* Calculate the shortest route available. */
        routeOptions.setRouteType(RouteOptions.Type.SHORTEST);
        /* Calculate 1 route. */
        routeOptions.setRouteCount(1);
        /* Finally set the route option */
        routePlan.setRouteOptions(routeOptions);

        /* Define waypoints for the route */
        /* START: 4350 Still Creek Dr */
        RouteWaypoint startPoint = new RouteWaypoint(geoCoordinate1);
        /* END: Langley BC */
        RouteWaypoint destination = new RouteWaypoint(geoCoordinate2);

        /* Add both waypoints to the route plan */
        routePlan.addWaypoint(startPoint);
        routePlan.addWaypoint(destination);

        /* Trigger the route calculation,results will be called back via the listener */
        coreRouter.calculateRoute(routePlan,
                new Router.Listener<List<RouteResult>, RoutingError>() {
                    @Override
                    public void onProgress(int i) {
                        /* The calculation progress can be retrieved in this callback. */
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(i);

                    }

                    @Override
                    public void onCalculateRouteFinished(List<RouteResult> routeResults,
                            RoutingError routingError) {
                        /* Calculation is done.Let's handle the result */
                        if (routingError == RoutingError.NONE) {
                            if (routeResults.get(0).getRoute() != null) {
                                /* Create a MapRoute so that it can be placed on the map */
                                m_mapRoute = new MapRoute(routeResults.get(0).getRoute());

                                /* Show the maneuver number on top of the route */
                                m_mapRoute.setManeuverNumberVisible(true);

                                /* Add the MapRoute to the map */
                                map.addMapObject(m_mapRoute);

                                /*
                                 * We may also want to make sure the map view is orientated properly
                                 * so the entire route can be easily seen.
                                 */
                                GeoBoundingBox gbb = routeResults.get(0).getRoute()
                                        .getBoundingBox();
                                map.zoomTo(gbb, Map.Animation.NONE,
                                        Map.MOVE_PRESERVE_ORIENTATION);
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Error:route results returned is not valid",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Error:route calculation returned error code: " + routingError,
                                    Toast.LENGTH_LONG).show();
                        }

                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

    private class Async extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            progressBar.setVisibility(View.VISIBLE);
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.GONE);
            super.onPostExecute(aVoid);
        }
    }

}
