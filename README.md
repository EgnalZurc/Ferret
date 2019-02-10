# Ferret
Ferret es una API de edición de texto.

# Como ejecutar
```javascript
java -jar .\build\ferret-1.0.jar
```

# Como compilar - instalar
```javascript
mvn install package
```

# Como recompilar - instalar
```javascript
mvn clean install package
```

# Lista de argumentos útiles
## Puesto donde se levanta el servicio
Si no se introduce ningún agumento, por defecto se levanta en el puerto 9000.
Si se introduce en siguiente argumento, se levanta en el puerto seleccionado:
```javascript
--server.port=9001
```

# Lista de comandos posibles
La api funciona mediante peticiones POST, las cuales deben tener en el cuerpo del mensaje la variable request igual a un JSON.
Ese JSON debe contener lossiguientes campos:
[OBLIGATORIO] actionID: campo numérico que determina qué petición se está realizando.
[OBLIGATORIO] filename: campo String que determina sobre qué fichero se está realizando la petición.
[OPCIONAL] line: campo numérico que determina sobre qué línea se está realizando la petición.
[OPCIONAL] text: campo String que qué texto se quiere añadir a la petición.
## Contar líneas:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":0,\"fileName\":\"test.txt\"}
```
## Obtener línea:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":1,\"fileName\":\"test.txt\",\"line\":2}
```
## Añadir línea:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":2,\"fileName\":\"test.txt\",\"text\":\"test\"}
```
## Modificar línea:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":3,\"fileName\":\"test.txt\",\"line\":2,\"text\":\"test\"}
```
## Obtener texto:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":4,\"fileName\":\"test.txt\"}
```
## Insertar línea:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":5,\"fileName\":\"test.txt\",\"line\":2,\"text\":\"test\"}
```
## Eliminar línea:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":6,\"fileName\":\"test.txt\",\"line\":2}
```
## Crear archivo:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":7,\"fileName\":\"nuevo.txt\"}
```
## Buscar texto contenido en líneas:
```javascript
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":8,\"fileName\":\"test.txt\",\"text\":\"test\"}
```

# Lista de respuestas posibles
La API responde con un mensaje JSON, el cual contiene la siguiente información.
payload: String informativo en caso de que la petición haya resultado exitosa.
succes: bool que indica si la petición ha sido exitosa.
msg: String informativo en caso de que la petición haya resultado erronea.
code: número informativo en caso de que la petición haya resultado erronea (no se rellena).
timestamp: timestamp que indica la hora en la que se produce la respuesta de la petición.
## Petición OK
```javascript
{"payload":"prueba","success":true,"msg":null,"code":0,"timestamp":1549810560}
```
## Petición fail
```javascript
{"payload":null,"success":false,"msg":"java.lang.Exception: Incorrect action selected","code":0,"timestamp":1549811248}
```
