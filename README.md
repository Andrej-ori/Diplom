# Дипломый проект профессии "Тестировщик"

## Запуск SUT, автотестов и генераия репорта:

Для запуска приложения на машине должно быть установленно следующее ПО:
* Docker Desktop - Приложение для скачивания и установки контейнеров (в нашем случае понадобится для установки 
и использования БД(MySQL и PostgeSQL) и эмулятора банковского сервиса написанного на NodeJS).
* IntelliJ IDEA - Среда разработки и запуска програм написанных на различных языках.
* Git - Cистема управления версиями с распределенной архитектурой. Нужна для отслеживания и ведения истории 
и изменения файлов в проекте.

### Предварительные условия:

1. Скачать репозиторий на компьютерер. (https://github.com/Andrej-ori/Diplom.git).
2. Запустить Docker Decktop.
3. Запустить IntelliJ IDEA.
4. Открыть проект в IntelliJ IDEA.

### Подключение SUT к БД MySQL, запуск тестов и создание репорта:

1. Открыть окно терминала и в командной строке набрать команду:
    `docker-compose up -d` 
    (запустится установка и запуск контейнеров с БД и эмулятором банковского сервиса, флаг -d позволит дальше работать с консолью)
2. Проверить запущенные контейнеры командой :
    `docker-compose ps`
3. Открыть второй терминал и запустить проект командой:
   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`**`
   (ключ **--spring.datasource.url=jdbc:mysql://localhost:3306/app** позволяет подключится к БД **MySQL** на порту **3306** с именем базы **"app"**)
4. Открыть тетий терминал и запустить тесты командой:  
   `.\gradlew clean test -DdbUrl=jdbc:mysql://localhost:3306/app`                               
   (ключ **-DdbUrl=jdbc:mysql://localhost:3306/app** позволяет подключится к БД **MySQL** на порту **3306** с именем базы **"app"**)
5. После завершения всех тестов, для генерации репорта в кмандной строке ввести команду:
   `.\gradlew allureServe`
   (Сформируется и запустится в браузере отчет о пройденных тестах)
6. Для завершения генерации репорта в командной строке нажать сочетание клавиш:
   **Ctrl + C** -> *y* -> *Enter*
7. Для закрытия приложения в котсоли в командной строке нажать сочетание клавиш:
   **Ctrl + C**
8. Для остановки контейнеров в котсоли в командной строке ввести команду:
   `docker-compose down`


### Подключение SUT к БД PostgreSQL, запуск тестов и создание репорта:

1. Открыть окно терминала и в командной строке набрать команду:
    `docker-compose up -d`
    (запустится установка и запуск контейнеров с БД и эмулятором банковского сервиса, флаг -d позволит дальше работать с консолью)
2. Проверить запущенные контейнеры командой :
    `docker-compose ps`
3. Открыть второй терминал и запустить проект командой:
   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`
   (ключ **--spring.datasource.url=jdbc:postgresql://localhost:5432/app** позволяет подключится к БД **MySQL** на порту **5432** с именем базы **"app"**)
4. Открыть тетий терминал и запустить тесты командой:  
   `.\gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app`                               
   (ключ **-DdbUrl=jdbc:postgresql://localhost:5432/app** позволяет подключится к БД **MySQL** на порту **5432** с именем базы **"app"**)
5. После завершения всех тестов, для генерации репорта в кмандной строке ввести команду:
   `.\gradlew allureServe`
   (Сформируется и запустится в браузере отчет о пройденных тестах)
6. Для завершения генерации репорта в командной строке нажать сочетание клавиш:
   **Ctrl + C** -> *y* -> *Enter*
7. Для закрытия приложения в котсоли в командной строке нажать сочетание клавиш:
   **Ctrl + C**
8. Для остановки контейнеров в котсоли в командной строке ввести команду:
   `docker-compose down`
