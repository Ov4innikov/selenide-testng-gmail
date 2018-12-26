Для запуска автотестов сначала необходимо настроить selenide, шаги:
1. Генерируем конфигурацию: docker run --rm -v /var/run/docker.sock:/var/run/docker.sock aerokube/cm:1.0.0 selenoid --last-versions 2 --tmpfs 128 --pull > /etc/selenoid/browsers.json
2. Создаём файл docker-compose.yml:
version: '3'
services:
    selenoid:
        image: "aerokube/selenoid"
        network_mode: bridge
        ports:
            - "4444:4444"
        volumes:
            - "c:/selenoid/:/etc/selenoid/"
            - "/var/run/docker.sock:/var/run/docker.sock"
    selenoid-ui:
        image: "aerokube/selenoid-ui"
        network_mode: bridge
        links:
            - selenoid
        ports:
            - "8080:8080"
        command: ["--selenoid-uri","http://selenoid:4444"]
        
3. Запускаем: docker-compose up --build -d (Для остановка используем: docker-compose down)
4. В итоге ui доступен по адресу: localhost:8080/. Selenoid по адресу: http://localhost:4444/wd/hub/

Документация:
https://aerokube.com/selenoid/latest/
https://aerokube.com/selenoid-ui/latest/