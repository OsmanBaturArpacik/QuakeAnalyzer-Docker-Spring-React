package com.earthquake.core.service;

import com.earthquake.core.model.EarthquakeLocationDataModel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
@Service
public class ActiveEarthquakeListService {
    private ArrayList<EarthquakeLocationDataModel> listInstance =  new ArrayList<>();;
    public void addElement(EarthquakeLocationDataModel newData) {
        boolean isContain=false;
        if(newData.getIntensity() > 4.5) {
            // liste bos yeni veriyi ekle
            if(listInstance.isEmpty()) {
                listInstance.add(newData);
            }
            // liste bos degil kontrolleri yap
            else {
                // foreach traverse list check for contains area
                synchronized(ActiveEarthquakeListService.class) {
                    for (EarthquakeLocationDataModel oldData : listInstance) {
                        if (Haversine.CalculateDistance(newData.getLat(), newData.getLon(), oldData.getLat(), oldData.getLon()) < 50.0) {
                            //TODO: şiddet kontorlünü buraya al eğer new, old dan büyükse onu listeye ekle old'u listeden kaldır bitti. değilse old timestamp setle newle bir şey yapma devam
                            oldData.setTimestamp(System.currentTimeMillis());
                            // depremin siddeti buyukse eskisininn ustune de yaz
                            if(newData.getIntensity() > oldData.getIntensity()) {
                                oldData.setIntensity(newData.getIntensity());
                            }
                            isContain = true;
                            break;
                        }
                    }
                    if (!isContain) {
                        // if e girmediyse yeni depremi ekle
                        listInstance.add(newData);
//                        System.out.println(listInstance.toString()+"add new element");
                    }
                }
            }
        }
    }
    public void updateList() {
        if(listInstance.isEmpty()) {
            return;
        }

        synchronized(ActiveEarthquakeListService.class) {
            double currentTime = System.currentTimeMillis();
            Iterator<EarthquakeLocationDataModel> iterator = listInstance.iterator();
            while (iterator.hasNext()) {
                EarthquakeLocationDataModel dataModel = iterator.next();
                if (currentTime - dataModel.getTimestamp() > 60000) {
                    // eger 60 saniyeden daha eskiyse listeden kaldir
                    iterator.remove();
                }
            }
        }

    }
}
