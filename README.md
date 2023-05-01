# Платформа автоматизированных продаж дилерских автомобилей
Клиент-серверное веб-приложение & Dealership Automated Sales Platform

[Репозиторий с клиентской частью & Repository with client side](https://github.com/knmskln/car-dealership-app)

База данных PostgreSQL, работа с базой данных осуществляется с помощью библиотеки hibernate.

PostgreSQL database, work with the database is carried out using the hibernate library.

## MVP:

### Меню администратора & Admin menu:

- добавление автомобилей в базу/add cars to database
- удаление автомобилей из базы/delete cars from database
- редактирование автомобилей/edit cars
- просмотр всех пользователей/view all users
- информация по всем заявкам (просмотр всех заявок, их статусы)/orders info
- смена статусов заявки (одобрить/отклонить)/change application status (approve/reject)
- просмотр рейтинга автомобилей/view cars rate

### Меню клиента & User menu:

- редактирование личных данных (смена пароля)/edit personal data
- просмотр автомобилей/view all cars
- отправление заявки на тест-драйв автомобиля/sending a request for a test drive
- просмотр своих заявок/view orders
- оценить тест-драйв/evaluate the car

## Nice to have:

### Меню администратора:

-

### По программе:

- при смене статуса заявки на «Одобрено» или «Отклонено» будет выслано соответствующее письмо на почту. 
- у пользователя будет возможность восстановить пароль с помощью электронной почты (пароль сгенерируется и отправится на указанную почту).
