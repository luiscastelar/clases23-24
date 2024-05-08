#curso23_24 #ED [estado::done] 

## Elementos de un diagrama de clases: 
nombre, atributos, métodos y visibilidades.

## Relaciones entre clases:
nombre, cardinalidad y tipos.

### Tipos de relaciones: 
asociación, agregación, composición, dependencia, herencia.

### Resumen:
![Diagrama introductorio](https://camo.githubusercontent.com/bc44c58440490d367a3065eadabf867059bcb1d91d66b34e0c63150ab1790727/687474703a2f2f6a616d6a323030302e6769746875622e696f2f656e746f726e6f736465736172726f6c6c6f2f352f6173736574732f636c6173732d6469616772616d2d646f6d61696e2d6f766572766965772e706e67)

## Referencias:
+ [DiagramasUml.com](https://diagramasuml.com/diagrama-de-clases/)
+ [José Antonio Muñoz](https://github.com/jamj2000/DAW1-ED-Apuntes/blob/master/5.DIAGRAMAS_CLASES.md)

## Ejercicios


### Castelar shop:
Ejercicio de clases con sus atributos que podrías incluir en un diagrama de clases de una tienda online:

    Usuario:

    idUsuario: Identificador único del usuario.
    nombre: Nombre completo del usuario.
    correoElectronico: Dirección de correo electrónico del usuario.
    contraseña: Contraseña del usuario.
    dirección: Dirección de envío del usuario.
    métodoDePago: Método de pago preferido por el usuario.

    Producto:

    idProducto: Identificador único del producto.
    nombre: Nombre del producto.
    descripción: Descripción detallada del producto.
    precio: Precio del producto.
    stock: Cantidad de unidades disponibles en el inventario.

    Carrito de Compras:

    idCarrito: Identificador único del carrito de compras.
    productos: Lista de productos que el usuario ha añadido al carrito.
    subtotal: Monto total del carrito antes de aplicar impuestos y descuentos.
    impuestos: Monto total de impuestos aplicados al carrito.

    Orden de compra:

    idOrden: Identificador único de la orden de compra.
    productos: Lista de productos comprados en la orden.
    subtotal: Monto total de la orden antes de aplicar impuestos y descuentos.
    impuestos: Monto total de impuestos aplicados a la orden.
    envío: Monto del costo de envío de la orden.
    total: Monto total de la orden incluyendo impuestos, descuentos y costo de envío.

    Categoría:

    idCategoría: Identificador único de la categoría.
    nombre: Nombre de la categoría.

    Comentarios:

    idComentario: Identificador único del comentario.
    producto: Identificador del producto al que se refiere el comentario.
    usuario: Identificador del usuario que escribió el comentario.
    comentario: Contenido del comentario.
    fecha: Fecha de creación del comentario.

#### Resolución por fases:
Primero tendríamos que pensar en que entidades, relaciones, atributos y métodos vamos a encontrarnos en el desarrollo.


Luego pasaríamos a [diagramar por fases](https://luiscastelar.duckdns.org/2023/assets/ED/UT7/tienda.drawio.pdf).

*Aprovechamos para remarcar algunos puntos interesantes*.


### Rent a car:
Se desea diseñar un diagrama de clases sobre la información de las reservas de una empresa dedicada
al alquiler de automóviles, teniendo en cuenta que:
+ Un determinado cliente puede tener en un momento dado hechas varias reservas.
+ De cada cliente se desean almacenar su DNI, nombre, dirección y teléfono. Además dos clientes se diferencian por un código único.
+ Cada cliente puede ser avalado por otro cliente de la empresa.
+ Una reserva la realiza un único cliente pero puede involucrar varios coches.
+ Es importante registrar la fecha de inicio y final de la reserva, el precio del alquiler de cada uno de los coches, los litros de gasolina en el depósito en el momento de realizar la reserva, el precio total de la reserva y un indicador de si el coche o los coches han sido entregados.
+ Todo coche tiene siempre asignado un determinado garaje que no puede cambiar. De cada coche se requiere la matricula, el modelo el color y la marca.
+ Cada reserva se realiza en una determinada agencia.


### Viajes Castelar:
Una cadena de agencias de viajes desea disponer de una Base de Datos que contemple información
relativa al hospedaje y vuelos de los turistas que la contratan.

Los datos a tener en cuenta son:
+ La cadena de agencias está compuesta por un conjunto de sucursales. Cada sucursal viene definida por el código de sucursal, dirección y teléfono.
+ La cadena tiene contratados una serie de hoteles de forma exclusiva. Cada hotel estará definido por el código de hotel, nombre, dirección, ciudad, teléfono y número de plazas disponibles.
+ De igual forma, la cadena tiene contratados una serie de vuelos regulares de forma exclusiva.
+ Cada vuelo viene definido por el número de vuelo, fecha y hora, origen y destino, plazas totales y plazas de clase turista de las que dispone.
+ La información que se desea almacenar por cada turista es el código de turista, nombre y apellidos, dirección y teléfono.
  
Por otra parte, hay que tener en cuenta la siguiente información:
+ A la cadena de agencias le interesa conocer que sucursal ha contratado el turista.
+ A la hora de viajar el turista puede elegir cualquiera de los vuelos que ofrece la cadena, y en que clase (turista o primera) desea viajar.
+ De igual manera, el turista se puede hospedar en cualquiera de los hoteles que ofrece la cadena, y elegir el régimen de hospedaje (media pensión o pensión completa). Siendo significativa la fecha de llegada y de partida.


### Castelar Zoo:
Un zoo necesita una aplicación informática para llevar su organización respecto a las especies que
posee, los empleados (cuidadores y guías), y los distintos itinerarios de visita que ofrece. La
información está estructurada de la siguiente manera:
+ Especies: de las especies interesa saber el nombre en español, el nombre científico y una descripción general. Hay que tener en cuenta que una especie puede vivir en diferentes hábitats naturales y que un hábitat puede ser ocupado por diferentes especies. Las especies se encuentran en distintas zonas del parque de manera que cada especie está en una zona y en una zona hay varias especies.
+ Hábitats: los diferentes hábitats naturales vienen definidos por el nombre, el clima y el tipo de vegetación predominantes, así como el continente o continentes en los que se encuentran.
+ Zonas: las zonas del parque en las que se encuentran las distintas especies vienen definidas por el nombre y la extensión que ocupan.
+ Itinerarios: los itinerarios discurren por distintas zonas del parque. La información de interés para los itinerarios es: código de itinerario, la duración del recorrido, la longitud del itinerario, el máximo número de visitantes autorizado y el número de distintas especies que visita. Hay que tener en cuenta que un itinerario recorre distintas zonas del parque y que una zona puede ser recorrida por diferentes itinerarios.
+ Guías: los guías del parque vienen definidos por el nombre, dirección, teléfono y fecha en la que comenzaron a trabajar en el zoo. Interesa saber qué guías llevan qué itinerarios, teniendo en cuenta que un guía puede llevar varios itinerarios y que un itinerario puede ser asignado a diferentes guías en  diferentes horas, siendo éstas un dato de interés.
+ Cuidadores: los cuidadores vienen definidos por el nombre, dirección, teléfono y fecha de ingreso en el parque. Hay que tener en cuenta que un cuidador puede estar a cargo de varias especies y que una especie puede ser atendida por varios cuidadores, siendo de interés la fecha en la que un cuidador se hace cargo de una especie.

  
## Práctica (voluntaria)
Se desea implementar un sistema de gestión de una liga nacional de canicas. 

Como es bien sabido, la profesionalización del juego de canicas ha llevado a tener 3 divisiones donde se celebran torneos cada semana hasta que todos los equipos se hayan enfrentado al resto de su división en su campo (como local) y en del contrario (como visitante).

Los partidos se realizan mediante equipos de 5 componentes cada uno, obteniendo 1 punto por cada partido ganado del torneo. Desearemos conocer el nombre y puntuación de cada jugador a lo largo de la liga.

De cada equipo desearemos conocer el nombre, ciudad y puntuación actual.

1. Deberás obtener el diagrama de clases para implementar la liga.
2. Deberás implementar la liga en el lenguaje que desees:
   + El profesor debe haberte dado el visto bueno al diagrama en **papel**.
   + No podrás implementar nada que no esté en el diagrama visado por el profesor.

*Nota: piensa en colecciones como primera aproximación.*

# Evaluación
Examen día 27 de febrero de 2024.
