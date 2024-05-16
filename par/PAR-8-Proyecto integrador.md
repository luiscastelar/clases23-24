#curso23_24 #PAR [estado::ToDo]

# Proyecto integrador
Los alumnos deberán realizar la conectividad solicitada en la topología que le corresponde.

## Topología Castelar:
![](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/u8-mapa-instituto.png)
1. Router ISP debe hacer NAT (IP publica 10.99.0.2)  
2. ROUTERs deben establecer comunicación:  
   + Por rutas estáticas
   + Por OSPF  
3. Los Sw deben tener una VLAN por aula, más una para el profesorado (PCs en f0/0 de cada sw)  
4. Se debe permitir que:
   + los alumnos salgan al exterior
   + los alumnos vean a sus compañeros de clase
   + los profesores se vean entre ellos
   + los profesores vean a los alumnos de SU clase
5. Añade redundancia en las capa de core (dos fibras) y distribución.
6. Cualquier profesor debe poder gestionar la red mediante usuario “root” y el password “toor”.

   
## Topología Internet:
![](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/topo-internet.png)
1. Verifica la conectividad de las redes
2. Apaga R3 y repite el punto 1.
3. Apaga R4 y repite el punto 1.
4. Todas las VLANs se ven con las siguientes excepciones:
   + VLAN 9 no puede comunicar con la 22, ni con la 8.
   + VLAN 7 no puede comunicar con R-BB3.
   + VLAN 146 sólo puede acceder a R-BB2, y todos los caminos intermedios que le permita llegar.
5. Todas las redes deberán comenzar por 10.X, donde X es vuestro número de puesto actual.
6. Cualquier trabajador debe poder gestionar la red mediante usuario “root” y el password “toor” de **SU** sistema autónomo.

Conectividades externas con BGP e internas con OSPF.


## Topología Internet 3:
![topo-3](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/topo-internet-3.png)

1. Verifica la conectividad de las redes
2. Apaga R0(5) y repite el punto 1.
3. Apaga R0(9) y repite el punto 1.
4. Todas las VLANs se ven con las siguientes excepciones:
   + El AS50 no puede acceder al AS10 (como dirección final).
   + El AS30 no puede acceder al AS20 (como dirección final).
5. Todas las redes deberán comenzar por 80.AS.X, donde X es vuestro número de puesto actual.
6. Cualquier trabajador debe poder gestionar la red mediante usuario “root” y el password “toor” de **SU** sistema autónomo.

Conectividades externas con BGP e internas con OSPF.