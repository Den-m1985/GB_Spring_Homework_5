скрипт для создания базы данных в консоле:
docker run --name mynewdb -e POSTGRES_DB=mynewdb -e POSTGRES_USER=myuser -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres

заходим внутрь через консоль
docker exec -it mynewdb psql -U myuser mynewdb

проверяем таблицы
\dt
выводим всех:
select * from notes;



собираем проект:
docker build -t example_2_seminar_5-image .

запускаем проект:
docker run -p 5432:5432 -t example_2_seminar_5-image

проверяем все запущенные контейнеры:
docker ps
проверяем все запущенные и остановленные контейнеры:
docker ps -a

останавливаем контейнер:
docker stop example_2_seminar_5-image

удаляем котейнер:
docker rm example_2_seminar_5-image


-------------------------------------------------------
https://www.baeldung.com/spring-boot-postgresql-docker
docker-compose up
docker exec -it db psql -U myuser
docker-compose down