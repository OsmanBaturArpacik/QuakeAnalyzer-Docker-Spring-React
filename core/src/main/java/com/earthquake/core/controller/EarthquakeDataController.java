package com.earthquake.core.controller;

import com.earthquake.core.service.ActiveEarthquakeListService;
import com.earthquake.core.model.EarthquakeLocationDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class EarthquakeDataController {

    private ActiveEarthquakeListService activeEarthquakeListService;

    @Autowired
    public EarthquakeDataController(ActiveEarthquakeListService activeEarthquakeListService) {
        this.activeEarthquakeListService = activeEarthquakeListService;
    }

    // FOR script.py
    @PostMapping("/addData")
    @ResponseBody
    public ResponseEntity<String> addData(@RequestBody  Map<String, Object> payload) {
        try {
            Double lat = (Double) payload.get("lat");
            Double lon = (Double) payload.get("lon");
            Double intensity = (Double) payload.get("intensity");

            // her yeni veride new yerine clone'lanabilir
            EarthquakeLocationDataModel dataModel = new EarthquakeLocationDataModel(lat, lon, intensity);

//            System.out.println(dataModel.getLat() + " " + dataModel.getLon() + " " + dataModel.getIntensity() + " " + dataModel.getTimestamp());
            // gelen eleman bos degilse ekle
            if (!isEmpty(dataModel)) {
                activeEarthquakeListService.addElement(dataModel);
                activeEarthquakeListService.updateList();
                return ResponseEntity.status(OK).body("Successfully finished");
            }
            return ResponseEntity.status(BAD_REQUEST).body("Post Request Declined");
        } catch (NumberFormatException | NullPointerException e) {
            return ResponseEntity.status(BAD_REQUEST).body("Invalid or missing data: " + e.getMessage());
        }
    }
    // FOR POST-MAN @RequestParam body posting
    @PostMapping("/addNewData")
    @ResponseBody
    public ResponseEntity<String> addNewData(@RequestParam  Map<String, String> payload) {
        // her yeni veride new yerine clone'lanabilir
        EarthquakeLocationDataModel dataModel = new EarthquakeLocationDataModel(
                Double.parseDouble(payload.get("lat")),
                Double.parseDouble(payload.get("lon")),
                Double.parseDouble(payload.get("intensity"))
        );
        System.out.println(dataModel.getLat()+" "+dataModel.getLon()+" "+dataModel.getIntensity()+" "+dataModel.getTimestamp());

        if(!isEmpty(dataModel)) {
            activeEarthquakeListService.addElement(dataModel);
            activeEarthquakeListService.updateList();
            return ResponseEntity.status(OK).body("Successfully finished");
        }
        return ResponseEntity.status(BAD_REQUEST).body("Post Request Declined");
    }

    @GetMapping("/getList")
    @ResponseBody
    public ResponseEntity<List<EarthquakeLocationDataModel>> getListWithStatus() {
        if(!activeEarthquakeListService.getListInstance().isEmpty()) {
            activeEarthquakeListService.updateList();
            return ResponseEntity.status(OK).body(activeEarthquakeListService.getListInstance());
        }
        else {
            return ResponseEntity.status(OK).body(new ArrayList<>());
        }
    }



    public boolean isEmpty(EarthquakeLocationDataModel dataModel) {
        if (dataModel.getLat() == 0 || dataModel.getLon() == 0 || dataModel.getIntensity() == 0) {
            return true;
        }
        return false;
    }
}


