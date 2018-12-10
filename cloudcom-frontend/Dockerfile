FROM nginx:alpine

COPY ./cloudcom-frontend/nginx.conf /etc/nginx/nginx.conf

WORKDIR /usr/share/nginx/html
COPY ./cloudcom-frontend/dist/ .
