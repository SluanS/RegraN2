package org.example.Service;
import org.example.Models.Transaction;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.Point;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;


public class GeoValidatorService {

    //Metodos para validação de tempo entre transações


    //Distancia entre dois pontos
    public static Double calcDistance(Transaction newTransaction, HashMap<String, Point> latLon, ArrayList<Transaction> transacations) {

        SpatialContext geoContext = SpatialContext.GEO;

        final double EARTH_RADIUS_KM = 6371.0088;


        Point currentLatLon = latLon.get(newTransaction.getState());

        Point lastLatLon = latLon.get(transacations.getLast().getState());

        Double distanceDegree = geoContext.getDistCalc().distance(currentLatLon, lastLatLon);


        //Conversão da distancia para radianos para calculo da distancia em km de acordo com o raio da terra


        Double distanceKm = Math.toRadians(distanceDegree) * EARTH_RADIUS_KM;

        return distanceKm;
    }
    //Calculo de hora minima em transações interestaduais
    public static Duration minimumTIme (Double distanceInKm){

        Double avarageSpeed = 800.0; //Velocidade tipica de avões comerciais

        Double timeToTravel = distanceInKm / avarageSpeed; //Tempo minimo em horas

        Long inMinutes = (long) (timeToTravel * 60);

        return Duration.ofMinutes(inMinutes);

    }


}
