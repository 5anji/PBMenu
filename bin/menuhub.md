server {
        listen 80 default_server;
        listen [::]:80 default_server;

        root /var/www/menuhub.md/html;
        index index.html index.htm index.nginx-debian.html;

        server_name menuhub.md www.menuhub.md;
        # server_name _;

        try_files $uri $uri/ @proxy;

        location @proxy {
                proxy_pass http://localhost:8080;
        }
}
