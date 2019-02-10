Se ha decidido implementar una API con los siguientes frameworks: &nbsp

# API REST Framework:
Para las peticiones de la API se ha decidido utilizar el framework blade. Es open source se puede encontrar el código fuente en la siguiete URL: &nbsp
```javascript
https://github.com/lets-blade/blade
```
Se introduce como dependencia en el documento pom.xml para que al compilarse con maven, se incluya el framework. &nbsp
Se decide utilizar ese framework y realizar una API mediante consultas POST donde tanto las consultas como las respuestas viajan en JSON. &nbsp
De esta manera hacemos el programa mucho más sencillo y ahorramos muchas horas de desarrollo. &nbsp

# JSON Framework
Como se ha decidido utilizar JSON para gestionar la información de las consultas, se utiliza el framework jsoniter para deserializar estos mensajes. &nbsp
Este framework es open source y se puede encontrar tanto la documentación como el código en la siguiente URL:
```javascript
http://jsoniter.com/
```
Se introduce como dependencia en el documento pom.xml para que al compilarse con maven, se incluya el framework. &nbsp
Se elige este framework en concreto porque según los workbench es de los más rápidos y a demás nos permite deserializar un JSON en un objeto de una manera muy cómoda.

# Resto de utilizades
Para el resto de utilidades, como son la gestión de los archivos, se utiliza la librería java.io. &nbsp

# Gestión de información
Los ficheros creados o modificados por las consultas se guardan como ficheros dentro del servidor. &nbsp
El objetivo de esto es evitar la necesidad de gestionar las base de datos y reducir el tiempo de proceso de la información. &nbsp
Para su correcta utilización, es necesario editar el fichero ferret.conf con la ruta donde se esperan estos ficheros. &nbsp

# Diseño de la aplicación
La aplicación sigue un diseño en cascada. Donde las consultas son lineales y cada thread creado por el framework "blade" se encarga de resolver la petición llamando a sub módulos y no creando nunva threads adicionales. &nbsp
El método "main" de la aplicación se encarga de crear una instancia del servidor, utilizando el framework blade. &nbsp
La clase ActionControlles sobre escribe un método post con la ruta "/ferret/. Esta clase sobre escrita se encarga de recibir la petición POST, deserializar su cuerpo (JSON) para crear un objeto Action. Por último, se le pide al objeto Action que realice la función indicada en la consulta. &nbsp
La clase Action se carga de ver qué tipo de petición se está realizando, validar los datos y de instanciar un onjeto FileHandler para que realice la acción deseada. A demás, instancia un objeto Config, el cual se encarga de leer el archivo de configuración, con el objetivo de saber el path donde se encuentran los ficheros. &nbsp
La clase FileHandler contiene una serie de métodos cuyos objetivos es realizar modificaciones sobre ficheros. Cada uno de ellos es llamado desde la clase action dependiendo de la petición que se está realizando y tiene un objetivo concreto. &nbsp

# Mejoras pendientes:
+ Si el archivo de configuracion, el cual se llama ferret.conf no existe, da un error por la consola, pero no lo devuelve la API. Habríaa que extender la excepción.
+ Cada vez que se realiza una petición se lee el fichero de configuración. Esto le da una latencia a cada consulta y lo suyo sería guardar en memoria el path directamente.