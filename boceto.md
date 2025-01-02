

# Paso a paso

sudo docker run --name mysqljava -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=testdb -p 3306:3306 -d mysql:latest
sudo docker ps -a 
sudo docker start mysqljava
Si no se puede eliminar PID , ver el puerto ocupado
sudo lsof -i :3306
sudo kill - 9 PID

user creado en tabla users
sudo docker exec  -it mysqljava mysql -u mysqluser -p

En mysql 
CREATE USER 'nuevo_usuario'@'localhost' IDENTIFIED BY 'contraseña_segura';
GRANT ALL PRIVILEGES ON nombre_de_la_base_de_datos.* TO 'nuevo_usuario'@'localhost';
FLUSH PRIVILEGES;


# Temática: Gestión de Turnos para un Lavadero de Autos

## Modelos:

### Turno (Appointment):
id: Identificador único.
date: Fecha y hora del turno.
customer_id: Relación con el cliente.
service_id: Relación con el servicio solicitado.

### Cliente (Customer):
id: Identificador único.
name: Nombre del cliente.
phone: Teléfono de contacto.

### Servicio (Service):
id: Identificador único.
name: Nombre del servicio (e.g., lavado completo, encerado, limpieza interior).
price: Precio del servicio.

## Endpints

### 1. Turnos (/appointments)
GET /appointments: Obtener todos los turnos.
POST /appointments: Crear un nuevo turno.
GET /appointments/:id: Obtener un turno específico.
PUT /appointments/:id: Actualizar un turno.
DELETE /appointments/:id: Eliminar un turno.
### 2. Clientes (/customers)
GET /customers: Obtener todos los clientes.
POST /customers: Registrar un nuevo cliente.
GET /customers/:id: Obtener un cliente específico.
PUT /customers/:id: Actualizar un cliente.
DELETE /customers/:id: Eliminar un cliente.
### 3. Servicios (/services)
GET /services: Obtener todos los servicios.
POST /services: Crear un nuevo servicio.
GET /services/:id: Obtener un servicio específico.
PUT /services/:id: Actualizar un servicio.
DELETE /services/:id: Eliminar un servicio.

____________________________________________________________________________________________________________________________________

Ejemplo de Implementación con Node.js y Express:
Estructura básica de los modelos:
const appointments = [
  { id: 1, date: "2024-12-15T10:00:00Z", customer_id: 1, service_id: 1 },
  { id: 2, date: "2024-12-15T12:00:00Z", customer_id: 2, service_id: 2 },
];

const customers = [
  { id: 1, name: "Carlos Gómez", phone: "1234567890" },
  { id: 2, name: "Ana López", phone: "0987654321" },
];

const services = [
  { id: 1, name: "Lavado Completo", price: 20.0 },
  { id: 2, name: "Limpieza Interior", price: 15.0 },
];




Rutas principales:

javascript
Copiar código
const express = require("express");
const app = express();
app.use(express.json());

// Appointments endpoints
app.get("/appointments", (req, res) => res.json(appointments));
app.post("/appointments", (req, res) => {
  const appointment = { id: appointments.length + 1, ...req.body };
  appointments.push(appointment);
  res.status(201).json(appointment);
});
app.get("/appointments/:id", (req, res) => {
  const appointment = appointments.find(a => a.id === parseInt(req.params.id));
  if (!appointment) return res.status(404).send("Appointment not found");
  res.json(appointment);
});

// Customers endpoints
app.get("/customers", (req, res) => res.json(customers));
app.post("/customers", (req, res) => {
  const customer = { id: customers.length + 1, ...req.body };
  customers.push(customer);
  res.status(201).json(customer);
});

// Services endpoints
app.get("/services", (req, res) => res.json(services));
app.post("/services", (req, res) => {
  const service = { id: services.length + 1, ...req.body };
  services.push(service);
  res.status(201).json(service);
});

// Server setup
const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
Ejemplo de Uso:
Crear un nuevo cliente:

json
Copiar código
POST /customers
{
  "name": "Juan Pérez",
  "phone": "5551234567"
}
Crear un servicio:

json
Copiar código
POST /services
{
  "name": "Lavado y Encerado",
  "price": 25.0
}
Reservar un turno:

json
Copiar código
POST /appointments
{
  "date": "2024-12-16T09:00:00Z",
  "customer_id": 1,
  "service_id": 2
}
