#curso23_24 #ED [estado:: Working] 

# Docker

## Dockerfile
### El previo:
Instalar *Docker Desktop* en aquellos equipos que lo permitan.

Para los que no, o para los que quieran control total de su sistema docker (incluida la red):
+ Vagrantfile:
```ruby
Vagrant.configure("2") do |config|
  config.vm.box = "generic/debian12"
   config.vm.network "public_network"
   config.vm.synced_folder "./", "/vagrant"
   config.vm.provision "shell", path: "provision.sh"
  # config.vm.network "forwarded_port", guest: 80, host: 8080
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"
  # config.vm.provider "virtualbox" do |vb|
  #   vb.memory = "1024"
  # end
end
```
+ provision.sh:
```bash
apt-get update && apt-get install -y curl

sudo -u vagrant docker --version
if [[ ! $? -eq 0 ]]; then
	sudo -u vagrant curl -fsSL https://get.docker.com -o install-docker.sh
	sh install-docker.sh

	groupadd docker
	usermod -aG docker vagrant
fi
sudo -u vagrant docker --version

ip a | grep "inet "

cd /vagrant
sudo -u vagrant docker build -t luistest:version001 .
```

### [Lo básico](https://luisiblogdeinformatica.com/crear-dockerfile/)
+ Dockerfile 1:
```Dockerfile
FROM debian:latest
RUN apt-get update && apt-get upgrade -y && apt-get install -y git

CMD ping google.es > /test.txt

ENV minombre Luis

COPY archivo.txt /home/$minombre/archiv.txt

ENTRYPOINT echo "Hola $minombre"
```

Luego la instanciamos y corremos con `docker run --rm luistest` (*Deberemos añadir el tag a la imagen que corresponda*).

Para hacer las cosas algo más cómodas podemos crear un alias del tag a *latest*:
`sudo -u vagrant docker tag luistest:version001 luistest:latest`

¿Pero y si queremos mostrar el contenido de archiv.txt? ` docker run --rm luistest cat /home/luis/archiv.txt`

### [Siendo más fino -> cmd vs entrypoint](https://programacionymas.com/blog/docker-diferencia-entrypoint-cmd)
Sustituiremos por tanto el *ENTRYPOINT* por:
```Dockerfile
...
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["echo $minombre"]
```

Y ahora ejecutaremos ` docker run --rm luistest cat /home/luis/archiv.txt`

### [Creando mi primera imagen](https://www.freecodecamp.org/espanol/news/guia-de-docker-para-principiantes-como-crear-tu-primera-aplicacion-docker/)

### [Subiéndola a docker hub]()

