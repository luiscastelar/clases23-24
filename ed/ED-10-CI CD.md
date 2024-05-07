#curso23_24 #ED [estado:: Working] 


# Integración y desarrollo continuo
[Pruebas de integración](https://qalified.com/es/blog/pruebas-de-integracion-que-son/)



## Workflow completo
![](https://raul-profesor.github.io/Despliegue/img/deployment-pipeline.png)

0. MVN y tomcat
1. Validación del código (linter): [plugins](https://blog.stackademic.com/7-best-plugins-to-improve-code-quality-in-java-0c96168203ab) para mvn. Nosotros usaremos [checkstyle](https://github.com/checkstyle/checkstyle) (mvn checkstyle:checkstyle)
2. Compilación (mvn compile)
3. Test unitarios (mvn test)
4. Empaquetado (mvn package / mvn war:war)
5. Documentación ([mvn site](https://maven.apache.org/plugins/maven-javadoc-plugin/usage.html) / mvn javadoc:javadoc)
7. Instalación/[Despliegue](https://raul-profesor.github.io/Despliegue/P3.1-Tomcat/) (mvn ...)


### MVN




### Fuentes:
+ [Github Actions](https://resources.github.com/learn/pathways/automation/essentials/automated-application-deployment-with-github-actions-and-pages/?ref=reactivisima.com)
+ [Compilación con GH Actions](https://docs.github.com/es/actions/automating-builds-and-tests/building-and-testing-java-with-maven)

+ [Base - Profesor Raúl /JENKINS/](https://raul-profesor.github.io/DEAW/cicd/)
+ [Paso a paso /JENKINS/](https://codingpotions.com/jenkins-integracion-continua/)

+ [HOOKS de Git](https://hardfloat.es/blog/2021/03/23/desplegar-aplicaciones-con-git.html)
+ [Proceso completo con Jenkins + K8s](https://medium.com/@ghazanfaralidevops/continuous-delivery-for-docker-containers-14f09c0d3e2d)
+ [Tutorial completo JENKINS - @CulturaDevOps](https://www.youtube.com/playlist?app=desktop&list=PLdOotbFwzDIiU4Hs8ySZr-phOeGMBY_3D&cbrd=1)
