package entities;

public class CarSearchRequest {

    private MapPoint startHire;
    private MapPoint stopHire;

    public class MapPoint {
        private double lon;
        private double lat;
    }
}
