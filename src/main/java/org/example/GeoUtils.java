package org.example;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.Point;

import java.util.HashMap;
import java.util.Map;

public class GeoUtils {

    private SpatialContext geoContext = SpatialContext.GEO;

    public HashMap<String, Point> getLatLon() {
        return latLon;
    }

    public void setLatLon(HashMap<String, Point> latLon) {
        this.latLon = latLon;
    }

    public SpatialContext getGeoContext() {
        return geoContext;
    }

    public void setGeoContext(SpatialContext geoContext) {
        this.geoContext = geoContext;
    }

    //Listagem de latitude e longitude de capitais
    protected HashMap<String, Point> latLon = new HashMap<>(Map.ofEntries(
            Map.entry("AC", geoContext.makePoint(-68.1193, -9.97499)),   // Rio Branco
            Map.entry("AL", geoContext.makePoint(-35.7370, -9.66599)),   // Maceió
            Map.entry("AP", geoContext.makePoint(-51.0664, 0.03493)),    // Macapá
            Map.entry("AM", geoContext.makePoint(-60.0258, -3.11866)),   // Manaus
            Map.entry("BA", geoContext.makePoint(-38.5014, -12.9718)),   // Salvador
            Map.entry("CE", geoContext.makePoint(-38.5247, -3.71722)),   // Fortaleza
            Map.entry("DF", geoContext.makePoint(-47.9292, -15.7801)),   // Brasília
            Map.entry("ES", geoContext.makePoint(-40.3378, -20.3155)),   // Vitória
            Map.entry("GO", geoContext.makePoint(-49.2643, -16.6864)),   // Goiânia
            Map.entry("MA", geoContext.makePoint(-44.2971, -2.53073)),   // São Luís
            Map.entry("MT", geoContext.makePoint(-56.0967, -15.6010)),   // Cuiabá
            Map.entry("MS", geoContext.makePoint(-54.6464, -20.4697)),   // Campo Grande
            Map.entry("MG", geoContext.makePoint(-43.9345, -19.9167)),   // Belo Horizonte
            Map.entry("PA", geoContext.makePoint(-48.4902, -1.4554)),    // Belém
            Map.entry("PB", geoContext.makePoint(-34.8631, -7.11509)),   // João Pessoa
            Map.entry("PR", geoContext.makePoint(-49.2731, -25.4284)),   // Curitiba
            Map.entry("PE", geoContext.makePoint(-34.8813, -8.0476)),    // Recife
            Map.entry("PI", geoContext.makePoint(-42.8009, -5.0892)),    // Teresina
            Map.entry("RJ", geoContext.makePoint(-43.1729, -22.9068)),   // Rio de Janeiro
            Map.entry("RN", geoContext.makePoint(-35.2094, -5.79448)),   // Natal
            Map.entry("RS", geoContext.makePoint(-51.2293, -30.0346)),   // Porto Alegre
            Map.entry("RO", geoContext.makePoint(-63.9039, -8.76116)),   // Porto Velho
            Map.entry("RR", geoContext.makePoint(-60.6733, 2.82384)),    // Boa Vista
            Map.entry("SC", geoContext.makePoint(-48.5480, -27.5954)),   // Florianópolis
            Map.entry("SP", geoContext.makePoint(-46.6396, -23.5558)),   // São Paulo
            Map.entry("SE", geoContext.makePoint(-37.0731, -10.9472)),   // Aracaju
            Map.entry("TO", geoContext.makePoint(-48.3558, -10.2500))    // Palmas
    ));
}
