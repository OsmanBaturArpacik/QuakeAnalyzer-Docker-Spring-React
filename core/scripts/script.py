import sys
import os
import requests
import random
import time

def def_script1(arg1, arg2, arg3):
    lat = arg1
    lon = arg2
    intensity = arg3

    payload = {
        "lat": str(lat),
        "lon": str(lon),
        "intensity": str(intensity)
    }

    backend_url = "http://backend:8080/routerName"
    try:
        response = requests.post(backend_url, json=payload)
        if response.status_code == 200:
            print(f"Dot created: lat={lat}, lon={lon}, intensity={intensity}")
        else:
            print("Status: " + str(response.status_code) + "\n" + "Text:" + response.text)
    except Exception as e:
        print("Exception: " + str(e))


def def_script2():
    while True:
        lat = random.uniform(-90, 90)
        lon = random.uniform(-180, 180)
        intensity = random.uniform(0, 10)

        payload = {
            "lat": str(lat),
            "lon": str(lon),
            "intensity": str(intensity)
        }

        backend_url = "http://backend:8080/routerName"
        try:
            response = requests.post(backend_url, json=payload)
            if response.status_code == 200:
                print(f"Dot created: lat={lat}, lon={lon}, intensity={intensity}")
            else:
                print("Status: " + str(response.status_code) + "\n" + "Text:" + response.text)
        except Exception as e:
            print("Exception: " + str(e))
        time.sleep(10)

def main():
    print("TESSSSSSSSSSSSST")
    latitude = os.getenv("LATITUDE")
    longitude = os.getenv("LONGITUDE")
    intensity = os.getenv("INTENSITY")
    print(latitude + longitude + intensity)

    if latitude and longitude and intensity:
        def_script1(latitude, longitude, intensity)
    elif latitude is not None and longitude is not None and intensity is not None:
        def_script2()
    else:
        print("Usage: script1 <space> lat <space> lon <space> intensity:")
        sys.exit(1)

if __name__ == "__main__":
    main()
