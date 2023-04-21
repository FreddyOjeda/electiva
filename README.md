API en Spring para clientes y facturas
Esta es una API desarrollada en Spring que permite la gestión de clientes y facturas. La API utiliza el puerto 8080 y todo se almacena en la nube en una base de datos con postgresql como motor alojada en supabase.

Endpoints
La API cuenta con los siguientes endpoints:

/customers
GET /: Obtiene todos los clientes.
GET /{id}: Obtiene el cliente con el id especificado.
POST /: Crea un nuevo cliente.
PUT /{id}: Actualiza el cliente con el id especificado.
DELETE /{id}: Elimina el cliente con el id especificado.
/bills
GET /: Obtiene todas las facturas.
GET /{id}: Obtiene la factura con el id especificado.
GET /customer/{id}: Obtiene las facturas del cliente con el id especificado.
GET /pay/{id}: Obtiene las facturas con el tipo de pago especificado.
GET /date/{start}/{end}: Obtiene las facturas dentro del rango de fechas especificado.
POST /{id}: Crea una nueva factura para el cliente con el id especificado.
PUT /{id}: Actualiza la factura con el id especificado.
DELETE /{id}: Elimina la factura con el id especificado.
Ejecución
Para ejecutar la API, asegúrate de tener instalado Java y Maven en tu equipo. Luego, desde la línea de comandos, accede al directorio raíz del proyecto y ejecuta el siguiente comando:

arduino
Copy code
mvn spring-boot:run
Una vez que la API se haya iniciado correctamente, podrás realizar peticiones a los endpoints mencionados anteriormente a través de tu navegador o herramienta para hacer peticiones HTTP (como Postman).
