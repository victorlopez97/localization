# localization
Repository for search ip localization


Para la ejecucion del repositorio ejecutar el comando 

- mvn clean install: Instalacion de dependencia 

Nota: Recordar tener instalado el maven en la maquina o hacer la ejecucion desde el mismo IDE

- Para consumo de los servicio ejecutar desde postman los siguientes curl, para el correspondiente testeo y/o ejecucion:

1 Informacion de pais:

    curl --location 'localhost:8080/get/localization/info-country/ES'

2 Infomacion de Moneda:

    curl --location 'localhost:8080/get/localization/info-moneda/EUR'

3 Localizacion ip:

    curl --location 'localhost:8080/get/localization/info-ip/83.44.196.93'

4 Geolocalizacion:

    curl --location 'localhost:8080/get/localization/info-geolocation/83.44.196.93'
