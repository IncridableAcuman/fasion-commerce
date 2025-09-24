FROM node:lts-alpine AS build

WORKDIR /app

COPY package*.json .

RUN npm install

COPY . .

RUN npm run build

FROM nginx:alpine

COPY /app/dist /usr/share/nginx/html

EXPOSE 5001

CMD [ "nginx", "-g", "daemon off;" ]