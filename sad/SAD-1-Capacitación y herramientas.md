#curso23_24 #SAD [estado:: Done] 
{[Page: New]} {[Editor: Toggle Dark Mode]} {[Editor: Toggle Vim Mode]}

# Capacitación
El módulo se basará fundamentalmente en código, por lo que realizaremos uso intensivo de control de versiones ([GIT]([https://git-scm.com](https://git-scm.com/))) y virtualización en distintos formatos.


# Control de versiones (GIT)

> Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente.

+ FC: [TodoCode - Git](https://www.youtube.com/watch?v=mCVQgSyjCkI&list=PLQxX2eiEaqby-qh4raiKfYyb4T7WyHsfW) -> [1,25h]
+ FC: [Fazt Code - Markdown](https://www.youtube.com/watch?v=oxaH9CFpeEE) -> [0,5h]
+ Clase: Crear un repo con README.md conectado con GitHub. Añadir colaborador (profe `@luiscastelar`). Postear cambios de captura (`tee`) de un clone -> [2h]
  + El `README.md` contendrá vuestro nombre y email coorporativo.
+ [GitFiend](https://gitfiend.com/) o [GitG](https://wiki.gnome.org/Apps/Gitg) como apoyo visual a *git bash*
+ .gitignore *.env y otros archivos binarios*. \
  Crearemos en la raíz del repo un archivo denominado `.gitignore` con el contenido:
  ```
  *.env
  ```

+ *Referencias*:
  + Documentación OFICIAL -> [Git reference manual](https://git-scm.com/docs)
  + Vídeos aclarativos -> [PildorasInformáticas 1-5, 10-11](https://www.youtube.com/watch?v=ANF1X42_ae4&list=PLU8oAlHdN5BlyaPFiNQcV0xDqy0eR35aU)
     
  

# Herramientas de laboratorio

## Virtualización ASISTIDA


### VAGRANT
> **Vagrant** es un software de código abierto que nos permite crear y mantener entornos de desarrollo portables, puede trabajar con VMware, VirtualBox, Hyper-V, KVM, AWS e incluso también con contenedores de Docker, por tanto, es ideal para simplificar la configuración de estos software de virtualización.

En otras palabras, nos permite gestionar máquinas virtuales desde código... [vamos a ello](https://app.vagrantup.com/techchad2022/boxes/ubuntu2204).

#### Ejercicio:
1. Añadir una segunda interfaz de red
2. Ponerla en modo `bridge`
3. Añadir 2 mv en un sólo fichero
4. Conectar esas 2 mv en una red interna
5. Limitar el uso de ram a 512MB
6. Limitar el uso de cores a 1
7. Instalar el paquete `git` en una de las mv



#### Referencias: 
+ [Get Started - Vagrant](https://developer.hashicorp.com/vagrant/tutorials/getting-started)
+ [Vagrant Boxes](https://app.vagrantup.com/boxes/search?provider=virtualbox)



## Virtualización LIGERA:

### LXC
![portada](https://luiscastelar.duckdns.org/2023/assets/vm-vs-lxc.png)

### Docker
![otra](https://luiscastelar.duckdns.org/2023/assets/hypervisor1-vs-lxc-vs-docker.png)

#### Kubernetes (K8s, K3s, miniKube)
Es un orquestador de contenedores.
> Kubernetes es una plataforma portable y extensible de código abierto para administrar cargas de trabajo y servicios. Kubernetes facilita la automatización y la configuración declarativa. Tiene un ecosistema grande y en rápido crecimiento. El soporte, las herramientas y los servicios para Kubernetes están ampliamente disponibles.

> Puedes pensar en Kubernetes como:
>*   una plataforma de contenedores
>*   una plataforma de microservicios
>*   una plataforma portable de nube
>...y mucho más.

> Kubernetes ofrece un entorno de administración **centrado en contenedores**. Kubernetes orquesta la infraestructura de cómputo, redes y almacenamiento para que las cargas de trabajo de los usuarios no tengan que hacerlo. Esto ofrece la simplicidad de las Plataformas como Servicio (PaaS) con la flexibilidad de la Infraestructura como Servicio (IaaS) y permite la portabilidad entre proveedores de infraestructura.

![otra](https://luiscastelar.duckdns.org/2023/assets/SAD/Mono2kub.png)
![otra](https://luiscastelar.duckdns.org/2023/assets/SAD/Docker-Kubernetes-togethert-min.png)