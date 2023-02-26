# План автоматизации
## 1. Перечень автоматизируемых сценариев.

- ***Позитивные сценарии:***

1. Открытие Страницы "Путишествие Дня"
    
    *Ожидаемый результат:* Откроется Страница "Путишествие дня".


2. Переход на форму ввода данных для покупки тура при нажатии кнопки "Купить".

    *Ожидаемый результат:* Открывается форма для ввода данных.


3. Переход на форму ввода данных для покупки тура в кредит при нажатии кнопки "Купить в кредит".

    *Ожидаемый результат:* Открывается форма для ввода данных.


4. Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки "Купить в кредит"ю

    *Ожидаемый результат:* После нажати кнопки "Купить в кредит" откроется форма оплаты тура в кредит

  
5. Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки "купить"ю

    *Ожидаемый результат:* После нажатия кнопки "Купить" откроестя форма оплаты по дебитовой карте


6. Покупка тура при помощи карты № "4444 4444 4444 4441" и вводе валидных данных.* (4 теста)

    *Ожидаемый результат:* Покупка одобрена.


7. Покупка тура в кредит при помощи карты № "4444 4444 4444 4441" и вводе валидных данных.* (4 теста)

    *Ожидаемый результат:* Покупка одобрена.


8. Покупка тура при помощи карты № "4444 4444 4444 4442" и вводе валидных данных.* (4 теста)

    *Ожидаемый результат:* В покупке отказано.


9. Покупка тура в кредит при помощи карты № "4444 4444 4444 4442" и вводе валидных данных.* (4 теста)

    *Ожидаемый результат:* В покупке отказано.


10. Покупка тура при помощи карты с номером отличным от предоставленых и вводом валидных данных.* (4теста)

   *Ожидаемый результат:* В покупке отказано.


11. Покупка тура в кредит при помощи карты с номером отличным от представленных и вводом валидных данных.* (4 теста)

**ИТОГО:** 29 тестов 



- **Негативные сценарии**

1. Отправка пустых форм нажатием кнопки "Продолжить"
   
   *Ожидаемый рузультат:* Появление предупреждения о неправильном заполнение полей. Форма не отправлена


2. Отправка формы заполненой валидными данными кроме одной оставленой пустой (номер карты, месяц, год, владелец, CVC/CVV) нажатием кнопки "Продолжить"

    *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


3. Заполнение поля "Месяц" не валидными данными (00; 13-99; одна цифра)

   *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


4. Заполнение поля "Месяц" меньше текущего при заполнении поля год значением текущего года.

   *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


5. Заполнение поля "Год" не валидными данными (до текущего года; болше текущего года на 6 и более лет; одна цифра)

   *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


6. Заполнение поля "Владелец" не валидными данными (Кириллица; цифры в Имени и/или Фамилии; Спец.символы(кроме дефиса и пробела); Латиница в нижнем регистре; Дрегие языки кроме Латиницы)

    *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


7. Заполнение поля "CVC/CVV" не валидными данными (одна цифра; две цифры)

    *Ожидаемый результат:* Появление предупреждения о неправильном заполнение поля. Форма не отправлена.


    Примечание * : валидными значениями для полей являются:

    -Месяц: число от 01 до 12 (при совпадение поля "Год" с текущим годом, номер месяца не должен быть раньше текущего)
    -Год: две последние цифры текущего и последующих 5 лет 
    -Владелец: латиница в ВЕРХНЕМ РЕГИСТРЕ, дефис и пробел, первый и последний символ должны быть буквами
    -CVC/CVV: число длиной 3 цифры


* Заявлена поддежка двух СУБД. Небходимо проверить как отображается статус карты в БД

1. Проверка статуса карты № "4444 4444 4444 4441" при покупке тура 

    *Ожидаемый результат:* статус APPROVED


2. Проверка статуса карты № "4444 4444 4444 4442" при покупке тура

    *Ожидаемый резльтат:* статус DECLINED


3. Проверка статуса карты № "4444 4444 4444 4441" при покупке тура в кредит

    *Ожидаемый результат* статус APPROVED


4. Проверка статуса карты № "4444 4444 4444 4442" при покупке тура в кредит

   *Ожидаемый резльтат:* статус DECLINED


## 2. перечень используемых инструментов с обоснованием выбора

- ***Intellij IDE** - ведущая среда разработки для Java и Kotlin.*

    Преимущества:
    1. Подсветка кода;
    2. Настраиваемые горячие клавиши;
    3. Настройка шрифтов;
    4. Выбор цветовой схемы редактора кода.


- ***Java** - объектно-ориентированый язык программирования.*

    Преимущества:
  1. Простота;
  2. Безопастность;
  3. Производительность;
  4. Надежность;
  5. ОПП(объектно-ориентированый подход);
  6. Независимость от аппаратной части и ОС.


- ***Gradle** - система автоматической сборки проекта.*

    Преимущества:
  1. Версия нового поколения, основанная на инструменте сборки JVM, который сочетает в себе преимущества Ant и Maven;
  2. Использует основанный на Groovy DSL, который отказывается от XML и является более мощным и выразительным;
  3. Предоставляет набор методов управления зависимостями, которые не только хорошо настраиваются, но и совместимы с Maven и Ivy;
  4. Поддерживает плавную миграцию проектов сборки Ant и Maven.


- ***JUnit5** - библиотека для тестирования программного обеспечения.*
  
  Преимущества:
  1. Использует функционал Java 8 или более поздних релизов;
  2. Добавлено функций для описания, организации и выполнения тестов;
  3. Возможность использовать более одного процесса тестирования за раз, чего нельзя сделать в JUnit4.


- ***Lombok** - библиотека генерации кода.*

  Преимущества:
  1. Просто генерирует код; 
  2. Нет семантики; 
  3. Работает для любой версии начиная с Java 6.


- ***Selenide** - инструмент для тестирования Web-приложений.*

  Преимущества:
  1. Встроенное неявное ожидание; 
  2. Автоматически закрытие браузера после запуска варианта использования;
  3. Код прост и удобен для чтения;
  4. Автоматически делать скриншоты неудачных тестов;
  5. Можно использовать с селеном.


- ***AppVeyor** - веб-сервис непрерывной интеграции, предназначенный для сборки и тестирования.*

  Преимущества:
  1. Поддерживается несколько систем управления версиями:
     * GitHub.com и GitHub Enterprise;
     * Bitbucket.com и сервер Bitbucket;
     * GitLab.com и GitLab Enterprise;
     * Azure DevOps (репозитории Git и TFVC).
  2. Настройка CI проектов через пользовательский интерфейс или в точечном файле appveyor.yml.
  3. Полный sud доступ к виртуальной машине под управлением сборки
  4. SQL Server 2017 для Linux.
  5. Bash и ядро PowerShell для управления потоком сборки.
  6. Параллельная конфигурация как для Windows, так и для Linux-сборок.
  7. Предустановленный сервис Docker.
  8. Встроенный сервер NuGet.
  9. Единый кросс-платформенный Build Worker API как в Windows (сообщения, результаты тестов).


- ***Allure** - инструмент построения отчетов автотестов.*

  Преимущества:
  1. Гибкий легкий многоязычный инструмент отчета о тестировании;
  2. Сокращает общий жизненный цикл дефектов;
  3. Модульность и расширяемость.


- ***Faker** - библиотека генерации данных, с помощью которой, будут созданы данные пользователя (клиента банка).*

  Преимущества:
  1. Faker позволяет с легкостью генерировать данные и организовывать работу через API.


- ***Git** - инструмент, позволяющий реализовать распределённую систему контроля версий.*

  Преимущества:
  1. Откат к определенной точке в разработке;
  2. Логирование изменений в проекте;
  3. Быстрое и удобное обновление файлов на сервере;
  4. Возможность командной разработки.


- ***GitHub** - сервис онлайн-хостинга репозиториев, обладающий всеми функциями распределённого контроля версий и функциональностью управления исходным кодом.*

  Преимущества:
  1. Распределенная VCS, которую можно использовать в автономном режиме.
  2. Git настолько распространен, что большинство других разработчиков знакомы с ним, многие проекты с открытым исходным кодом размещаются на GitHub, поэтому это отличное место, чтобы найти и внести свой вклад в эти проекты.
  3. GitHub также включает сторонние интеграции, чтобы упростить рабочие процессы.

## 3. перечень и описание возможных рисков при автоматизации
* Возможны ошибки при написании автотестов;
* Возможны ошибки в автотестах, связанные с техническим сбоем;
* Возможны ошибки в автотестах, в связи с изменением кода;
* Неоправданная стоимость и затраты на автоматизацию тестирования;
* Возможен некорректный запуск симулятора банковских карт;
* Возможны сложности при настройке двух СУБД ("MySQL" и "PostgreSQL"), и корректном подключении к каждой из них.

## 4. интервальная оценка с учётом рисков в часах

1. Подготовка и настройка проекта: 8 часов;
2. Написание плана тестирования: 8 часов;
3. Написание автотестов: 56 - 72 часов;
4. Создание баг-репортов и отчёта по результатам прогона тестов: 8 часов;
5. Отчетные документы по итогам автоматизации: 8 часов;
6. Дополнительно на устранение последствий наступления рисков +15%-25% времени для реализации проекта ~10-18 часов.

## 5. План сдачи работ

1. Написание плана тестирования -4 дня;
2. Написание автотестов 14 - 18 дней;
3. Написание отчета по автоматизации - 3 дня. 