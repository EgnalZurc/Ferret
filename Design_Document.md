API REST Framework:
https://github.com/lets-blade/blade
File Sistem Framework:

JSON Framework
http://jsoniter.com/

Contar líneas:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":0,\"fileName\":\"test.txt\"}
Obtener línea:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":1,\"fileName\":\"test.txt\",\"line\":2}
Añadir línea:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":2,\"fileName\":\"test.txt\",\"text\":\"test\"}
Modificar línea:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":3,\"fileName\":\"test.txt\",\"line\":2,\"text\":\"test\"}
Obtener texto:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":4,\"fileName\":\"test.txt\"}
Insertar línea:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":5,\"fileName\":\"test.txt\",\"line\":2,\"text\":\"test\"}
Eliminar línea:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":6,\"fileName\":\"test.txt\",\"line\":2}
Crear archivo:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":7,\"fileName\":\"nuevo.txt\"}
Buscar texto contenido en líneas:
curl -X POST http://127.0.0.1:9000/ferret -d request={\"actionID\":8,\"fileName\":\"test.txt\",\"text\":\"test\"}