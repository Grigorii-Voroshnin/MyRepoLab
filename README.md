# RepoLab  
Репозиторий предназначен для хранения лабораторных и курсовых работ.  
## Часть 1. ChangeMAC  
Проект ChangeMAC получает на вход данные (Имя файла, MAC-адрес, кол-во повторяющихся адресов).
Задача - прочитать из поданного на вход файла данные, в которых могут встречаться переносы строк. 
Найти МАС-адрес, поданный на входе, в тексте файла и заменить на рандомный юникастный. МАС-адрес
может встречаться не раз. Последний аргумент указывает какое количество адресов подряд необходимо
заменить на один и тот же.
Практическое применение - формирование набора пакетов для DoS и DDoS атак.
Файлы проекта находятся в Lab1.
## Часть 2. База данных VK.
В данной работе была создана база данных, имитирующая базу данных социальной сети vkontakte. 
База данных создавалась через СУБД MySQL. Также для создания дампа базы данных использовался
инструмент mysqldump. Также для заполениня базы данных информацией был использован сторонний
сайт. Отчет и созданная БД хранятся в Lab2.
## Часть 3. Docker-compose project.
Проект состоит из 3 контейнеров:
 - База данных mongo
```
Предназначена для хранения данных, получаемых из сервиса иницилизации. Находится во внутренней
bridge сети 192.168.1.0/24 и работает на порту 27017.
```
 - Контейнер инициализации
```
Предназначен для чтения и изменения базы данных mongo
находится во внутренней bridge сети 192.168.1.0/24
```
 - Сервер времени на flask
```
Предназначен для отображения даты и московского времени в веб-интерфесе. Порт сервера flask
пробрасывается на хост, поэтому для обращения к нему необходимо в браузере обратиться к
loclhost:8080.
```
Все файлы хранятся в Lab3
## Часть 4. Swarm Behaviour Classifier.
Проект представляет собой jupyter файл. Файл содержит решение следующей задачи 
https://www.kaggle.com/deepcontractor/swarm-behaviour-classification с её подробным описанием.
Исходные данные для проведения самостоятельного анализа можно скачать по той же ссылке.
В комментариях присутствуют цифры, которые могут не сходиться с полученными программными 
рассчетами. Это связано с тем, что при перезапуске файла данные для классификации были 
разделены на train и test заново.