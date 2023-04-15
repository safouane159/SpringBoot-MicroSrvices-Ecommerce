# spring-boot-safouane159

**Cette application est développé par  **

| **Nom / mail**                               |  **Qualité / rôle**        |
|----------------------------------------------|----------------------------|
| OUAZRI Safouane / safouane1ouazri@gmail.com  | Développeur                |


## 1. Prise en main 

Cloner le repositorie git: 

```shell
 $ git https://github.com/Master-2-MIAGE-MBDS/spring-boot-safouane159.git

```

il exist 2 branche : 

        - master
        - externalConf
  
  
switcher vers la brache "externalConf" : 

```shell
 $ git checkout <existing_branch>

```

## 2. executer les microservices dans votre IDE

Il faut executer en premier le service "ConfigServer", il s'agit de. server du configuration

 - le server est disponible sous: sur http://localhost:8899/ 
 - example d'utilisation :  http://localhost:8899/orders/default
 
 
aprés vous executez le reste des services dans n'import quelle ordre, les ervice sont les suivant :

- ms-cart :     disponible sous: sur http://localhost:8092/ 
- ms-product :  disponible sous: sur http://localhost:8091/ 
- client :      disponible sous: sur http://localhost:8090/ 
- orders :      disponible sous: sur http://localhost:8094/

vous pouvez constater que toute les modules contient un bootstrap.yml qui contient le lien vers le server de configuration.

bootstrap.yml ( dans toute les modules

```shell

spring:
  cloud:
    config:
      uri: http://localhost:8899 
  application:
    name: <application-name>
    
```
 
