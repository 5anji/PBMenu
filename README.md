# MenuHub

![alt text](./assets/logo.svg "Logo Title")

## Overview

Site to review menus of any restaurant in Republic of Moldova, made by a group of FAF students.

## Dependencies

- `posgresql`
- `openjdk11`
- `nginx`

## Installation and Deployments

1) Install dependencies:
    - E.G. Ubuntu: `sudo apt install postgresql openjdk-11-* build-essential nginx`

2) Configure global shortcuts and binaries:

    ```bash
    sudo mkdir -p /opt/menuhub
    sudo cp ./bin/build/tablo_jar.jar /opt/menuhub/
    sudo cp ./bin/run-server /usr/bin/
    sudo ufw allow "Nginx Full"
    sudo ufw allow "OpenSSH"
    sudo ufw status
    sudo ufw enable
    systemctl status nginx
    ```

3) Configure PostgreSQL:

    - access dbms:

    ```bash
    sudo -u postgres psql
    ```

    - and inside psql:

    ```sql
    ALTER USER postgres PASSWORD 'postgres';
    CREATE DATABASE tablo;
    \q
    ```

    - run the API for data migration:

    ```bash
    run-server
    ```

    - optionally you can check if tables were created in the database

4) Move dist files for NGinx deploying:

    ```bash
    unzip ./bin/build/dist.zip
    sudo mv ./dist/* /var/www/html/
    ```

5) Access the web page by IP(ipv4):

    - IP: `hostname -i`

    - open browser and access the link: http://xxx.xxx.xxx.xxx/
