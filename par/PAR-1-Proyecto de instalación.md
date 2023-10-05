#curso23_24 #PAR #ED [estado::Done]

# LA INSTALACIÓN FÍSICA DE UNA RED

En el laboratorio vamos a simular el diseño, presupuesto y ejecución de una instalación completa de un nuevo aula con 30 equipos para alumnos, el del profesor, así como el rack de aula y la interconexión al *cuarto de telecomunicaciones*, que en nuestro caso también será un rack.

En la actualidad el edificio no tiene ninguna conexión de datos por lo que deberá presupuestarse completamente la instalación de datos, así como la electrificación de los 30 y 1 puestos a partir del cuadro eléctrico disponible en el aula.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/structured_cabling.png)
Algunas de estas tareas se pueden superponer en el tiempo y habrá que tener esto en cuenta al confeccionar el calendario de instalación. 

A continuación describimos algunas de estas tareas:

- [ ] **Calendario de diseño/ejecución**. El mismo debe incluir 1 hora diaria de clase para la ejecución + la estimación de trabajo de diseño en casa.
+ [ ] **Diseño del cableado estructurado**. Plasmar en papel el diseño que queremos implementar posteriormente de forma física. Debemos realizar los siguientes planos:
    * Aula en planta:
      * [ ] datos: un punto de red por equipo de alumno y 2 para el docente.
      * [ ] electricidad: 3 tomas eléctricas para cada alumno y 6 para el docente.
      * [ ] conjunta (datos y electricidad).
    * [ ] Rack de aula.
    * [ ] Rack de “edificio”.
  
- [ ] **Presupuestar**. Una vez que tenemos el diseño podemos realizar el presupuesto de materiales y mano de obra. Deberéis consultar el coste hora **actual** de un Técnico Superior en Administración de Sistemas Informáticos en Red.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/flujo_de_trabajo.png)

- [x] **Instalación de las tomas de corriente**. Esta tarea suele realizarla un electricista, pero desde el punto de vista del proyecto debemos asegurarnos de que hay suficientes tomas de corriente para alimentar todos los equipos de comunicaciones.
- [ ] **Instalación de rosetas y jacks**. Es la instalación de los puntos de red finales desde los que se conectarán los equipos de comunicaciones sirviéndose de latiguillos. La mayor parte de estas
    conexiones residirán en canaletas o en armarios de cableado.
- [ ] **Tendido de los cables**. Se trata de medir la distancia que debe recorrer cada cable y añadirle una longitud prudente que nos permita trabajar cómodamente con él antes de cortarlo.    
- [ ] **Conectorización de los cables** en los patch panels y en las rosetas utilizando las herramientas de crimpado apropiadas. 
- [ ] **Probado de los cables instalados**. Cada cable construido y conectorizado debe ser inmediatamente probado para asegurarse de que cumplirá correctamente su función. \
      Se debe documentar cada prueba mediante cuestionario (check-list). 
- [ ] **Etiquetado y documentación del cable y conectores**. Todo cable debe ser etiquetado en ambos extremos, así como los conectores de patch panels y rosetas, de modo que queden identificados unívocamente. \
      En este punto, dado que no tenemos las herramientas necesarias, deberás solamente documentar el procedimiento para realizarlo en tu proyecto de instalación.
- [ ] **Instalación de los adaptadores de red**. Gran parte de los equipos informáticos vienen ya con la tarjeta de red instalada, pero esto no es así necesariamente. \
      En la actualidad, no suele requerirse. Su estudio se realizará en el RA1 del módulo formativo *Fundamentos de Hardware*.
- [ ] **Instalación de los dispositivos de red**. Se trata de instalar los concentradores, conmutadores, puentes y encaminadores. \
      Algunos de estos dispositivos deben ser configurados antes de prestar sus servicios. Esta operación la realizaremos en la UT2.
- [ ] **Configuración del software** de red en clientes y servidores de la red. Esta operación la realizaremos en la UT7.

***Recuerda**: que el técnico supervisor del cliente (profesor) realizará un muestreo de la instalación y la validará o no de forma completa. Deberás asegurarte que pasa la certificación antes de solicitar la validación de la instalación.* 