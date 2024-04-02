package com.earthquake.core.service;

import com.earthquake.core.Haversine;
import com.earthquake.core.model.EarthquakeLocationDataModel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ActiveEarthquakeListService {
    @Getter
    private static List<EarthquakeLocationDataModel> listInstance =  new ArrayList<>();;
    public void addElement(EarthquakeLocationDataModel dataModel) {
        // eger bu kosulu gecerse listeye eklenecek kadar onemli bir depremdir o zaman haritada pinlenecek obur turlu bir sey yapmayacak
        if(dataModel.getIntensity() > 4.0) {
            // liste bos yeni veriyi ekle
            if(ActiveEarthquakeListService.listInstance.isEmpty()) {
                listInstance.add(dataModel);
            }
            else {
                isContain(dataModel);
            }
        } else {
            // dbye de yazilabilir olan depremler
            return;
        }

    }
    private void isContain(EarthquakeLocationDataModel newData) {
        // foreach traverse list check for contains area
        synchronized(ActiveEarthquakeListService.class) {
            for (EarthquakeLocationDataModel dataModel : ActiveEarthquakeListService.listInstance) {
                if ((int) Haversine.CalculateDistance(newData.getLat(), newData.getLon(), dataModel.getLat(), dataModel.getLon()) < 50) {
                    // ayni noktada sayilacagindan yeni olusan depremi ustune eklemek yerine oncekinin timestampini guncelliyoruz
                    dataModel.setTimestamp(System.currentTimeMillis());
                    // yeni listeyi frontende gonder
                } else {
                    listInstance.add(newData);
                    return;
                    // yeni listeyi frontende gonder
                }
            }
        }
    }

    public void updateList() {
            if(ActiveEarthquakeListService.listInstance.isEmpty()) {
                return;
            } else {
            synchronized(ActiveEarthquakeListService.class) {
                double currentTime = System.currentTimeMillis();
                List<EarthquakeLocationDataModel> listCopy = new ArrayList<>(ActiveEarthquakeListService.listInstance);
                Iterator<EarthquakeLocationDataModel> iterator = listCopy.iterator();
                while (iterator.hasNext()) {
                    EarthquakeLocationDataModel dataModel = iterator.next();
                    if (currentTime - dataModel.getTimestamp() > 60000) {
                        // Eger 60 saniyeden daha eskiyse listeden kaldir
                        iterator.remove();
                    }
                }
                // Gercek listeyi guncelle
                ActiveEarthquakeListService.listInstance = listCopy;
            }
        }
    }

}
