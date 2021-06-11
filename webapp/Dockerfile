FROM node:16-alpine3.11 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . ./
ARG configuration=production
RUN npm run build -- --outputPath=./dist/out --configuration $configuration

FROM nginx:1.20.1-alpine
COPY --from=build /app/dist/out/ /usr/share/nginx/html
COPY /nginx.config /etc/nginx/conf.d/default.conf
EXPOSE 80