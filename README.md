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
    sudo mkdir -p /opt/menuhub/assets
    sudo cp ./bin/build/tablo_jar.jar /opt/menuhub/
    sudo cp -r ./assets/web/* /opt/menuhub/assets/
    sudo cp ./bin/run-server /usr/bin/
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
    sudo mkdir -p /var/www/menuhub.md
    sudo mkdir -p /var/www/menuhub.md/html
    sudo chown -R $USER:$USER /var/www/menuhub.md/html
    sudo chmod -R 755 /var/www/menuhub.md
    sudo unlink /etc/nginx/sites-enabled/default
    sudo cp ./bin/menuhub.md /etc/nginx/sites-available/
    sudo ln -s /etc/nginx/sites-available/menuhub.md /etc/nginx/sites-enabled/
    unzip ./bin/build/dist.zip
    sudo rm /var/www/menuhub.md/html/*
    sudo mv ./dist/* /var/www/menuhub.md/html/
    ```

5) Access the web page by IP(ipv4):

    - IP: `ip addr | grep -E ': enp|: wlan' -A 2`

    - open browser and access the link: http://xxx.xxx.xxx.xxx/
