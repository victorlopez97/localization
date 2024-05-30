# localization
Repository for search ip localization


Para la ejecucion del repositorio ejecutar el comando 

- mvn clean install: Instalacion de dependencia 

Nota: Recordar tener instalado el maven en la maquina o hacer la ejecucion desde el mismo IDE

- Para consumo de los servicio ejecutar desde postman los siguientes curl, para el correspondiente testeo y/o ejecucion:

1.  Informacion de pais:

    curl --location 'localhost:8080/get/localization/info-country/ES'

2.  Infomacion de Moneda:

    curl --location 'localhost:8080/get/localization/info-moneda/EUR'

3.  Localizacion ip:

    curl --location 'localhost:8080/get/localization/info-ip/83.44.196.93'

4.  Geolocalizacion:

    curl --location 'localhost:8080/get/localization/info-geolocation/83.44.196.93'



Ejecucion de la aplicacion desde docker:
1. Ejecutar el siguiente comando para hacer el empaquetado con mvn: 

   mvn clean package

2. Abrir el archivo dockerfile y ejecutarlo desde alli, teniendo en cuenta que se debe de tener instalado y configurado el docker en el equipo.
   En el docker entrega un nombre de imagen con este nombre se ejecuta lo siguiente:

   docker run -p 8080:8080 {nombre de la imagen} 

3. Si se ejecuta con comandos hacer lo siguiente desde la terminal en la ubicacion del repo: 
    
    - docker build -t localization .
    - docker run -p 8080:8080 localization

De las opciones ateriores dadas y el docker en ejecuion, correr los curl ya suministrados