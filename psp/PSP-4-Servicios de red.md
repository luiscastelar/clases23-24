#curso23_24 #PSP [estado:: Done] 


Proyecto libre por parejas de un servicio de red. Debe realizarse una presentación del mismo.

Opciones:
+ WWW:
  + Servidor web (debe servir jpg y png) [individual]
+ Capas inferiores (+2 ptos):
  + DNS:
    <details>
    + [Investigando](https://luiscastelar.duckdns.org/2023/assets/PSP/UT4/tcpdump-zine.pdf)
    </details>
  + DHCP
  + SNMP
  <details>
    + Info del protocolo [RFC 1157](https://datatracker-ietf-org.translate.goog/doc/html/rfc1157?_x_tr_sl=auto&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=wapp)
    + [Resumen](https://www.cloudns.net/blog/understanding-the-basics-of-snmp-simple-network-management-protocol/)
    
    En la parte del cliente emularemos el funcionamiento de snmpwalk `snmpwalk -c public -v 2c localhost .1.3.6.1.4.1.2021.4` que nos devuelve informoción relativa a la memoria del sistema encuestado. \
    Podemos ver más infor sobre el MIB en [OIDREF.com](http://oidref.com/1.3.6.1.4.1.2021).
    Dando resultado de: [Mem tot real - 1.3.6.1.4.1.2021.4.5.0](http://oidref.com/1.3.6.1.4.1.2021.4.5.0 "1.3.6.1.4.1.2021.4.5.0 0 ") y [Total RAM free - 1.3.6.1.4.1.2021.4.11.0](http://oidref.com/1.3.6.1.4.1.2021.4.11.0 "1.3.6.1.4.1.2021.4.11.0 0 ").
    
    
  </details>
+ eMail:
  + SMTP
  + POP3
  + IMAP
+ Ficheros:
  + TFTP
  + FTP
  + NFS
  + CIFS (Carpetas compartidas windows)
+ Conexión remota:
  + Telnet


## Tools:
+ [tcpdump](https://luiscastelar.duckdns.org/2023/assets/PSP/UT4/tcpdump-zine.pdf)
