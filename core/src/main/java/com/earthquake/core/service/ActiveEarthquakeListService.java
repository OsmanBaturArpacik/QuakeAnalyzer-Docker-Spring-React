package com.earthquake.core.service;

import com.earthquake.core.Haversine;
import com.earthquake.core.model.EarthquakeLocationDataModel;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Service
public class ActiveEarthquakeListService {
    private ArrayList<EarthquakeLocationDataModel> listInstance =  new ArrayList<>();;
    public void addElement(EarthquakeLocationDataModel newData) {
        boolean isContain=false;
        // eger bu kosulu gecerse listeye eklenecek kadar onemli bir depremdir o zaman haritada pinlenecek obur turlu bir sey yapmayacak
        if(newData.getIntensity() > 4.0) {
            // liste bos yeni veriyi ekle
            if(listInstance.isEmpty()) {
                listInstance.add(newData);
                System.out.println(listInstance.toString() + "liste bostu bende elemani ekledim");
                return;
            }
            // liste bos degil kontrolleri yap
            else {
                // foreach traverse list check for contains area
                synchronized(ActiveEarthquakeListService.class) {
                    for (EarthquakeLocationDataModel oldData : listInstance) {
                        System.out.println("old data"+oldData.getLat()+" "+oldData.getLon()+" "+oldData.getIntensity()+" "+oldData.getTimestamp());
                        System.out.println("distance:"+(int) Haversine.CalculateDistance(newData.getLat(), newData.getLon(), oldData.getLat(), oldData.getLon()));
                        // foreach ile listedeki elemanlari alip hepsini yeni veriye gore karsilastir
                        if (Haversine.CalculateDistance(newData.getLat(), newData.getLon(), oldData.getLat(), oldData.getLon()) < 50.0) {
                            // ayni noktada sayilacagindan yeni olusan depremi ustune eklemek yerine oncekinin timestampini guncelliyoruz
                            oldData.setTimestamp(System.currentTimeMillis());
                            // yeni listeyi frontende gonder
                            isContain = true;
                            break;
                        }
                    }
                    if(!isContain) {
                        // if e girmediyse yeni depremi ekle
                        listInstance.add(newData);
                        System.out.println(listInstance.toString()+"add new element ife girmedim");
                    }
                }
            }
        } else {
            // dbye de yazilabilir olan depremler
        }

    }
    public void updateList() {
        if(listInstance.isEmpty()) {
                return;
            } else {
            synchronized(ActiveEarthquakeListService.class) {
                double currentTime = System.currentTimeMillis();
                Iterator<EarthquakeLocationDataModel> iterator = listInstance.iterator();
                while (iterator.hasNext()) {
                    EarthquakeLocationDataModel dataModel = iterator.next();
                    if (currentTime - dataModel.getTimestamp() > 60000) {
                        // Eger 60 saniyeden daha eskiyse listeden kaldir
                        iterator.remove();
                    }
                }
//                // Gercek listeyi guncelle
//                listInstance = listCopy;
            }
        }
    }

}
