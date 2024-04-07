import sys
import os
import requests
import random
import time
from dotenv import load_dotenv

def def_script1(arg1, arg2, arg3):
    lat = arg1
    lon = arg2
    intensity = arg3

    payload = {
        "lat": float(lat),
        "lon": float(lon),
        "intensity": float(intensity)
    }

    backend_url = "http://backend:8080/addData"
    try:
        response = requests.post(backend_url, json=payload)
        if response.status_code == 200:
            print(f"Dot created: lat={lat}, lon={lon}, intensity={intensity}")
        else:
            print("Status: " + str(response.status_code) + "\n" + "Text:" + response.text)
    except Exception as e:
        print("Exception: " + str(e))

if __name__ == "__main__":
        load_dotenv()
        latitude = os.getenv("LATITUDE")
        longitude = os.getenv("LONGITUDE")
        intensity = os.getenv("INTENSITY")

        print("Latitude:", latitude)
        print("Longitude:", longitude)
        print("Intensity:", intensity)
        if latitude != "999" and longitude != "999" and intensity != "999":
            time.sleep(4)
            def_script1(latitude, longitude, intensity)
        elif latitude == "999" and longitude == "999" and intensity == "999":
            for i in range(100):
                time.sleep(4)
                def_script1(random.uniform(-90, 90), random.uniform(-180, 180), random.uniform(0, 10))
        else:
            sys.exit(1)

