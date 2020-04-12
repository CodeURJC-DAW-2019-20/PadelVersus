FROM node:12.16.2-alpine

WORKDIR /usr/src/app
# Acordarse de antes de copiar package.json y package-lock.json a la carpeta docker
COPY ../Docker ./

RUN npm install
RUN npm install -g @angular/cli@9.0.7

CMD ls -la .

