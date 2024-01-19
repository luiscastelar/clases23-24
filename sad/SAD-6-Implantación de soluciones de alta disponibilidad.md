  #curso23_24 #SAD [estado:: ToDo] 


# Kubernetes (K8s)
Esta unidad la trabajaremos con orquestación de contenedores para la puesta en marcha de servicios de alta disponibilidad a través del escalado horizontal y la programación declarativa de requisitos.

En primer lugar nos familiarizaremos con el funcionamiento de 

## 1. Levantando minikube
Opción simple: [oficial](https://minikube.sigs.k8s.io/docs/start/)

Otra opción es realizarlo mediante vagrant + ansible: 
> Para ello vamos a proceder a crear una mv con minikube a través de repositorio de [Q24](https://github.com/Q24/vagrant-box-ubuntu2204-minikube). 
>
> Deberéis tener una cuenta en Vagrant Cloud (gratuita) y crear el archivo `build.env` con los datos indicados en el repositorio de Q24.
>
> Además deberéis tomar el play list de ansible del repo de clase ya que el original tiene algunos errores.

Tutorial: [Pelao Nerd](https://www.youtube.com/watch?v=6e_sXAx7kts)

## 2. Primer pod y servicio

Tutorial: [oficial](https://kubernetes.io/docs/tutorials/hello-minikube/)

## Multinodo
Intalación multinodo [vagrant - Lorenz Vanthillo](https://github.com/lvthillo/vagrant-ansible-kubernetes)

## Fuentes:
+ [Kubernetes 101 - Uni Almería - Torres](https://ualmtorres.github.io/Kubernetes101/)
+ [Seminario - Uni Almería - Torres](https://ualmtorres.github.io/SeminarioKubernetes/)
+ 
