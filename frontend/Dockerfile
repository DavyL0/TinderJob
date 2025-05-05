# front-end/Dockerfile
FROM node:18 as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=build /app/dist/tinderjobs /usr/share/nginx/html
EXPOSE 80
