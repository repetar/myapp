FROM node:13.12.0-alpine

WORKDIR /app

COPY package*.json ./
RUN npm install
RUN apk update && apk add bash
RUN apk add --update \
    curl \
    && rm -rf /var/cache/apk/*

COPY . .

EXPOSE 3000
EXPOSE 8080
EXPOSE 9229

CMD ["npm", "run", "dev"]

