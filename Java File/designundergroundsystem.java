import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Store ongoing check-ins: id -> CheckInInfo
    private Map<Integer, CheckInInfo> checkInMap;
    // Store route statistics: "startStation->endStation" -> RouteInfo
    private Map<String, RouteInfo> routeMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.checkInTime;

        RouteInfo routeInfo = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        routeInfo.totalTime += travelTime;
        routeInfo.tripCount++;
        
        routeMap.put(routeKey, routeInfo);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo routeInfo = routeMap.get(routeKey);
        return routeInfo.totalTime / routeInfo.tripCount;
    }
}