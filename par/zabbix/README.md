#curso23_24 #PAR [estado::ToDo]

# Monitorización con Zabbix

Esto es un breve manual de como levantar un servicio de monitorización de red (SNMP) mediante la aplicación Zabbix.

>
> **IMPORTANTE**:
> El servicio se levantará mediante contenedores docker únicamente. **NO** debemos instalar Zabbix en local **NI** tocar **NINGUNA** base de datos.
>

Para ello vamos a utilizar la “receta” [`compose.yml`](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/zabbix/compose.yml) junto con el archivo de credenciales [`.env`](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/zabbix/.env)

Tras tener instalado el [servicio docker en el sistema](https://github.com/luiscastelar/clases23-24/blob/main/docker.md) procederemos a levantar el contenedor que correrá Zabbix.

1. Crearemos un nuevo directorio donde queramos. Pero **NUEVO**.
2. En él ubicaremos los archivos `compose.yml` y `.env` proporcionados.
3. Abriremos una terminal y nos desplazaremos a dicho directorio.
4. Ejecutaremos:
```bash
# Levantar contenedor:
docker compose up -d

# Verificar funcionamiento:
docker compose ps

# Ver logs del contenedor (por si algo falla)
docker compose logs

# Destruir contenedor:
docker compose down
```

5. En una máquina virtual (puede ser la misma) levantaremos el AGENTE SNMP según [manual visto en clase](https://tecnocratica.net/wikicratica/books/monitorizacion-y-snmp)
6. Dentro de la interfaz web de Zabbix añadiremos el seguimiento de dicho agente.



>
> **IMPORTANTE**:
> El servicio se levantará mediante contenedores docker únicamente. **NO** debemos instalar Zabbix en local **NI** tocar **NINGUNA** base de datos.
>
