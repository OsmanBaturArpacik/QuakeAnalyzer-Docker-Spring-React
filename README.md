># KARTACA USG GOREV - DEPREM VERILERI ISLEME

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

>## Install
>
>[Docker Desktop](https://www.docker.com/products/docker-desktop/)

>## Usage
>1. Clone this repo
>  ```sh
>    //open cmd
>    
>    cd /d C:\
>    
>    mkdir repo_project
>    
>    cd repo_project
>    
>    git clone https://github.com/OsmanBaturArpacik/KARTACA_GOREV.git
>  ```
>Eğer private olduğundan problem olursa [buradan](https://drive.google.com/drive/folders/1re9dihwhik6ai3ERZk2ArbxtplA7WRN5?usp=drive_link)
>indirebilirisiniz
>
>Önceden build yapılmış proje dosyalarına [buradan](https://drive.google.com/drive/folders/1-QY0lkwEpwIuJ-WKIJhp89ZVRa6TNn_l?usp=drive_link) erişebilirisiniz
>
>
>2. Build & Install
>  ```sh
>    cd client/client
>    
>    npm run build
>    
>    cd ../..
>    
>    cd core
>    
>    ./gradlew build
>  ```
>
>3. Docker Setup
>  ```sh
>    // open docker desktop
>    docker-compose build
>    
>    docker-compose up
>  ```
>4. docker-compose up'tan sonra 3000 portlu http://localhost:3000/ girebilirsiniz [Website URL](http://localhost:3000/)
>
>Script1
>  ```sh
>    // .env icindeki verileri degistirerek script degistirebilirsiniz.
>    // "deger" yerine istediginiz noktayı koyabilirisiniz. 
>    LATITUDE="deger"
>    LONGITUDE="deger"
>    INTENSITY="deger"
>    // setledikten sonra docker-compose up ile yeniden başlatabilirsiniz.
>  ```
>Script2
>  ```sh
>    // .env icindeki verileri degistirerek script degistirebilirsiniz.
>    // .env eğer üçü de "999" ise rastgele durdurulana kadar rastgele nokta oluşturur.(script2)
>    LATITUDE="999"
>    LONGITUDE="999"
>    INTENSITY="999"
>    // setledikten sonra docker-compose up ile yeniden başlatabilirsiniz.
>  ```

>## Contact
>[![Static Badge](https://img.shields.io/badge/Osman%20Batur%20Arpac%C4%B1k---?style=social&logo=linkedin&labelColor=white&color=lightblue)](https://www.linkedin.com/in/osman-batur-arpacik/)
>&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/OsmanBaturArpacik---?style=social&logo=github&labelColor=white&color=lightblue)](https://github.com/OsmanBaturArpacik)
>&nbsp; &nbsp; &nbsp; [![Static Badge](https://img.shields.io/badge/osmanbatur%40outlook.com---?style=social&logo=microsoftoutlook&labelColor=white&color=lightblue)](mailto:osmanbatur@outlook.com)


