# KARTACA USG GOREV - DEPREM VERILERI ISLEME

>![Static Badge](https://img.shields.io/badge/Java-21.0.1-red?style=flat&logoColor=green)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/node-v20.12.0-red?style=flat&logo=nodedotjs&logoColor=green)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/npm-v10.5.1-red?style=flat&logo=npm)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/Gradle-8.6-red?style=flat&logo=gradle)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/docker-25.0.3-red?style=flat&logo=docker)

>#### [GÖREV](https://kartaca.com/cekirdekten-yetisenler-programi/usg-gorev-2024/)
>Basit bir panel içerisinde, dünya haritası üzerinde anormal depremleri gösterebilecek bir web uygulaması istenmektedir.
<br>50km çevresi içerisinde olan değerler aynı bölge sayılarak, anormal olan depremler harita üzerinde bir süre kalacak şekilde pinlenmelidir.
<br>Projeye veri beslemek için 2 adet script olmalı ve bu scriptler projenin veri toplayan servisleri ile konuşmalıdır. <br>Veri toplayan servisler (tercihe göre REST, SOAP veya RPC) verileri kuyruklayarak işlemelidir.
>- 1.Script input olarak lat,lon ve şiddet versini almalı ve girilen bu değeri sisteme dahil etmelidir.
>- 2.Script durdurulana kadar rastgele olarak lat,lon ve şiddet değerleri ile sisteme veri dahil etmelidir.
>- Sistemde Apache Flink kullanılmalıdır.
>- Arka uç Java, Go veya PHP dillerinden herhangi biri ile, tercihe göre micro service veya monolithic mimaride geliştirilmelidir. Ön yüz ise React veya Vue JS çatılarından biri ile geliştirilmelidir.
>-   Proje docker-compose üzerinden tek bir komut ile çalışacak şekilde servis edilmeli ve nasıl çalışır hale getirileceği detaylı ve güzel bir şekilde README olarak yazılmış olmalıdır (hem proje hem de script kullanımları).Veritabanı gibi bağımlılıklar da docker-compose içerisinde içerisinde yer almalıdır.
>-   Proje kodu GitHub’da özel bir kod deposuna gönderilerek, Kartaca Github profiline erişim izni verilmelidir. E-posta ile bağlantı adresi candidate@kartaca.com‘a iletilmelidir. Kod deposu üzerinden paylaşım sağlanamıyorsa, indirilebilir dosyalara ulaşmamız için bir dosya/bağlantı iletilmelidir.
>#### <ins>NOTLAR<ins/>
>- Tasarım ve ek özellikler için hayal gücünüzü işin içine dahil edebilirsiniz.
>- Proje bağımlılıkları (Veritabanı, kuyruklama sistemi, vb.) tamamen açık kaynak projelerden oluşmalıdır.

>## Kullanılan Teknolojiler
>[![Static Badge](https://img.shields.io/badge/Java%20Spring---?style=for-the-badge&logo=spring&labelColor=white)](https://spring.io/)
&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/react---?style=for-the-badge&logo=react&labelColor=white&color=lightblue)](https://react.dev/)
&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/docker---?style=for-the-badge&logo=docker&labelColor=white&color=blue)](https://www.docker.com/)

## Install

[Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Usage

[//]: # (Quick way to start a web map application with MapLibre GL JS using Create React App.)

[//]: # ()
[//]: # (A simple fullscreen map application as an example on how to use MapTiler maps together with React and MapLibre GL JS for your own React app.)

[//]: # ()
[//]: # (1. Clone this repo)

[//]: # ()
[//]: # (  ```sh)

[//]: # (    git clone https://github.com/OsmanBaturArpacik/KARTACA_GOREV.git)

[//]: # (  ```)

[//]: # ()
[//]: # (2. Navigate to the newly created project folder **...\kartaca\core**)

[//]: # (  ```sh)

[//]: # (    cd cd \kartaca\core)

[//]: # (  ```)

[//]: # ()
[//]: # (3. Build, Install dependencies)

[//]: # (  ```sh)

[//]: # (    npm install)

[//]: # (  ```)

[//]: # ()
[//]: # (4. :warning: Open the App.js file and replace **YOUR_MAPTILER_API_KEY_HERE** with your actual [MapTiler API key]&#40;https://cloud.maptiler.com/account/keys/&#41;.)

[//]: # ()
[//]: # (:information_source: If you don't have an API KEY you can create it for **FREE** at https://www.maptiler.com/cloud/)

[//]: # ()
[//]: # (5. Start your local environment)

[//]: # (  ```sh)

[//]: # (    npm start)

[//]: # (  ```)

[//]: # ()
[//]: # (6. You will find your app on address http://localhost:3000/. Now you should see the map in your browser.)

1. open cmd
  ```sh
    cd /d C:\

    mkdir repo_project
    
    cd repo_project
    
    git clone
    
    cd kartac/client/client
    
    npm run build
    
    cd ../..
    
    cd core
    
    ./gradlew build
    
    docker-compose build
    
    docker-compose up
  ```
## Learn More
You can learn more at [How to display MapLibre GL JS map using React JS](https://docs.maptiler.com/react/maplibre-gl-js/how-to-use-maplibre-gl-js/?utm_medium=referral&utm_source=github&utm_campaign=2022-05%20%7C%20js%20frameworks%20%7C%20react).

>## Contact
>[![Static Badge](https://img.shields.io/badge/Osman%20Batur%20Arpac%C4%B1k---?style=social&logo=linkedin&labelColor=white&color=lightblue)](https://www.linkedin.com/in/osman-batur-arpacik/)
>&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/OsmanBaturArpacik---?style=social&logo=github&labelColor=white&color=lightblue)](https://github.com/OsmanBaturArpacik)
>&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/osmanbatur%40outlook.com---?style=social&logo=microsoftoutlook&labelColor=white&color=lightblue)](mailto:osmanbatur@outlook.com)


