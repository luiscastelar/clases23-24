  #curso23_24 #SAD [estado:: ToDo] 


# Kubernetes (K8s)
Esta unidad la trabajaremos con orquestación de contenedores para la puesta en marcha de servicios de alta disponibilidad a través del escalado horizontal y la programación declarativa de requisitos.

En primer lugar nos familiarizaremos con el funcionamiento del servicio de orquestación.

![Kubernetes Cheat Sheet: Architecture and Commands Explained](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fplatform9.com%2Fwp-content%2Fuploads%2F2019%2F05%2Fkubernetes-constructs-concepts-architecture.jpg&f=1&nofb=1&ipt=c492a5dc55c2ad92e7ccbbb66ec8a22748bc087aa19e505ec00b9094e35f6f1c&ipo=images)
**Cheetsheet:** [comandos](https://cheatography.com/pablorod/cheat-sheets/kubernetes/)

## 1. Levantando minikube
Opción simple: [oficial](https://minikube.sigs.k8s.io/docs/start/)

Otra opción es realizarlo mediante vagrant + ansible: 
> Para ello vamos a proceder a crear una mv con minikube a través de repositorio de [Q24](https://github.com/Q24/vagrant-box-ubuntu2204-minikube). 
>
> Deberéis tener una cuenta en Vagrant Cloud (gratuita) y crear el archivo `build.env` con los datos indicados en el repositorio de Q24.
>
> Además deberéis tomar el play list de ansible del repo de clase ya que el original tiene algunos errores.

Tutorial: [Pelao Nerd](https://www.youtube.com/watch?v=6e_sXAx7kts)

> Si lo ejecutamos en un nube pública necesitaremos el fichero kubeconfig del cluster de k8s que deberemos importar como variable de entorno (`export KUBECONFIG=~/ruta_al_archivo`) para que nuestro `kubectl` pueda controlar el cluster.

## 2. Primer pod y servicio
Tutorial: [oficial](https://kubernetes.io/docs/tutorials/hello-minikube/)

*Recuerda: Si estás realizando virtualización anidada deberás abrir un proxy socks para realizar el reenvío de puertos.*


## 3. Tutorial Pelao Nerd
Vamos a seguir el [tutorial](https://www.youtube.com/watch?v=DCoBcpOA7W4) de forma que veamos las opciones más comunes que tenemos disponibles.

1. Pod
2. Pod personalizado
3. DaemonSet -> Asegura 1 pod en cada nodo (worker)
4. Deployment -> Asegura un número mínimo de pods **SIEMPRE**.
5. Statefulset -> Añade un volumen- [ejemplo es](https://karabacode.blogspot.com/2020/05/postgresql-como-statefulset-en-minikube.html) o [ejemplo en](https://www.bogotobogo.com/DevOps/Docker/Docker_Kubernetes_StatefulSet.php)


## Multimodo
1. Utilizando un contenedor con [`kind`](https://www.josedomingo.org/pledin/2021/02/kubernetes-con-kind/): `kind create cluster --config config.yaml`
2. De las más reales... creando la instalación multinodo con varias MV [vagrant - Lorenz Vanthillo](https://github.com/lvthillo/vagrant-ansible-kubernetes)

## Fuentes:
+ [Kubernetes 101 - Uni Almería - Torres](https://ualmtorres.github.io/Kubernetes101/)
+ [Seminario - Uni Almería - Torres](https://ualmtorres.github.io/SeminarioKubernetes/)
+ 

## Avisos:
+ Deshabilitar verificación en minikube: **--no-vtx-check**