# Платформа автоматизированных продаж дилерских автомобилей
Клиент-серверное веб-приложение
[Репозиторий с клиентской частью](https://github.com/knmskln/car-dealership-app)
База данных PostgreSQL, работа с базой данных осуществляется с помощью библиотеки hibernate.

## MVP:

### Меню администратора:

- добавление автомобилей в базу
- удаление автомобилей из базы
- редактирование автомобилей
- просмотр всех пользователей
- информация по всем заявкам (просмотр всех заявок, их статусы)
- смена статусов заявки (одобрить/отклонить)
- просмотр рейтинга автомобилей

### Меню клиента:

- при регистрации на почту высылается письмо об успешной регистрации
- редактирование личных данных (смена пароля)
- просмотр автомобилей
- отправление заявки на тест-драйв автомобиля
- просмотр своих заявок
- оценить автомобиль

## Nice to have:

### Меню администратора:

-

### По программе:

- при смене статуса заявки на «Одобрено» или «Отклонено» будет выслано соответствующее письмо на почту. 
- у пользователя будет возможность восстановить пароль с помощью электронной почты (пароль сгенерируется и отправится на указанную почту).
