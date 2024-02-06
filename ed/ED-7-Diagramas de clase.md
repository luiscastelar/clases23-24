#curso23_24 #ED [estado:: Working] 

## Elementos de un diagrama de clases: 
nombre, atributos, métodos y visibilidades.

## Relaciones entre clases:
nombre, cardinalidad y tipos.

### Tipos de relaciones: 
asociación, agregación, composición, dependencia, herencia.

## Ejercicios

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


## Práctica
Se desea implementar un sistema de gestión de una liga nacional de canicas. 

Como es bien sabido, la profesionalización del juego de canicas ha llevado a tener 3 divisiones donde se celebran torneos cada semana hasta que todos los equipos se hayan enfrentado al resto de su división en su campo (como local) y en del contrario (como visitante).

Los partidos se realizan mediante equipos de 5 componentes cada uno, obteniendo 1 punto por cada partido ganado del torneo. Desearemos conocer el nombre y puntuación de cada jugador a lo largo de la liga.

De cada equipo desearemos conocer el nombre, ciudad y puntuación actual.

1. Deberás obtener el diagrama de clases para implementar la liga.
2. Deberás implementar la liga en el lenguaje que desees:
   + El profesor debe haberte dado el visto bueno al diagrama en **papel**.
   + No podrás implementar nada que no esté en el diagrama visado por el profesor.

*Nota: piensa en colecciones como primera aproximación.*