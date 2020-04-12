FROM node:12.16.2-alpine

WORKDIR /usr/src/app

CMD npm install && npm run build

