package com.earthquake.core.controller;

import com.earthquake.core.service.ActiveEarthquakeListService;
import com.earthquake.core.model.EarthquakeLocationDataModel;
import com.earthquake.core.service.EarthquakeDataIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class EarthquakeDataController {

    private EarthquakeDataIntegrationService dataIntegrationService;
    private ActiveEarthquakeListService activeEarthquakeListService;


    @Autowired
    public EarthquakeDataController(EarthquakeDataIntegrationService dataIntegrationService,ActiveEarthquakeListService activeEarthquakeListService) {
        this.dataIntegrationService = dataIntegrationService;
        this.activeEarthquakeListService = activeEarthquakeListService;
    }

//    @PostMapping("/DataManipulation")
//    @ResponseBody
//    public ResponseEntity<String> test(@RequestBody Map<String, String> payload) {
//        dataModel.setLat(Double.parseDouble(payload.get("lat")));
//        dataModel.setLon(Double.parseDouble(payload.get("lon")));
//        dataModel.setIntensity(Double.parseDouble(payload.get("intensity")));
//
//        if (dataModel.getLat() == 0 || dataModel.getLon() == 0 || dataModel.getIntensity() == 0) {
//            return ResponseEntity.status(BAD_REQUEST).body("missing params - Usage: \"lat\": \"value\" \"lon\": \"value\" \"intensity\": \"value\" ");
//        }
//
//
//        return ResponseEntity.status(OK).body("Data received successfully");
//    }
    @PostMapping("/addNewData")
    @ResponseBody
    public ResponseEntity<String> flink(@RequestParam Map<String, String> payload) {
        // her yeri veride new yerine clone'lanabilir
        EarthquakeLocationDataModel dataModel = new EarthquakeLocationDataModel(
                Double.parseDouble(payload.get("lat")),
                Double.parseDouble(payload.get("lon")),
                Double.parseDouble(payload.get("intensity"))
        );
//        System.out.println(dataModel.getLat()+" "+dataModel.getLon()+" "+dataModel.getIntensity()+" "+dataModel.getTimestamp());

        if(!dataIntegrationService.isEmpty(dataModel)) {
            activeEarthquakeListService.addElement(dataModel);
            activeEarthquakeListService.updateList();
            return ResponseEntity.status(OK).body("Successfully finished");
        }
        return ResponseEntity.status(BAD_REQUEST).body("Post Request Declined");
    }
    @GetMapping("/getList")
    @ResponseBody
    public ResponseEntity<List<EarthquakeLocationDataModel>> getListWithStatus() {
        // bos degilse timestampleri kontrol et yeni listeyi gonder

//        ArrayList<EarthquakeLocationDataModel> xd =  new ArrayList<>();;
//        xd.add(new EarthquakeLocationDataModel(20,34,10));
//        xd.add(new EarthquakeLocationDataModel(21,12,6.4));
//        xd.add(new EarthquakeLocationDataModel(23,42,2.4));
//        xd.add(new EarthquakeLocationDataModel(40,34,3));
//        xd.add(new EarthquakeLocationDataModel(21,30,10));
//        xd.add(new EarthquakeLocationDataModel(31,20,4));

        if(!activeEarthquakeListService.getListInstance().isEmpty()) {
            activeEarthquakeListService.updateList();
            return ResponseEntity.status(OK).body(activeEarthquakeListService.getListInstance());
        }
        return ResponseEntity.status(BAD_REQUEST).body(null);
    }
}


