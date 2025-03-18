Для чего
======
Тесты написаны для учебного проекта по тестированию сайта Skillfactory

Окружение
===========
Десктоп браузер Chrome версии 125. 
Стек: Java, Selenium

Запуск теста
===========
1. Открыть проект в IntellijIdea
2. Запустить класс TestSuite или Каждый тест по отдельности

Описание тестов
===========
Этот класс содержит следующие тесты:

1. checkMainPageLinksProforientaciya

Проверяет наличие ссылки на страницу профориентации на главной странице.

Переходит на страницу профориентации и проверяет корректность загрузки.

2. checkProforientaciyaEmailValidation

Параметризованный тест (использует @ParameterizedTest и @MethodSource).

Проверяет валидацию поля email на странице профориентации.

Вводит различные значения email и проверяет корректность обработки.

3. enrollInQAJavaCourseNegative

Проверяет негативный сценарий записи на курс "Java QA".

Переходит к курсу и пытается записаться с некорректными данными.

4. freeTestProgrammingLanguage

Проверяет возможность прохождения бесплатного теста по языкам программирования.

5. checkMainPageLinksTopMenuAllCourses

Проверяет работоспособность ссылки "Все курсы" в верхнем меню.

6. checkMainPageLinksTopMenuDataScienceCourses

Проверяет ссылку на страницу курсов по Data Science.

7. checkMainPageLinksTopMenuCareerCenter

Проверяет работоспособность ссылки на Центр карьеры.

8. checkMainPageLinksTopMenuContacts

Проверяет корректность ссылки на страницу "Контакты".

9. checkMainPageLinksTopMenuMedia

Проверяет работоспособность ссылки на страницу "Медиа".

10. checkMainPageLinksTopMenuCorporateEducation

Проверяет переход на страницу корпоративного обучения.

11. checkMainPageLinksDataScience

Проверяет доступность страницы Data Science.

12. checkMainPageLinksTesting

Проверяет корректность ссылки на страницу тестирования.

13. checkMainPageLinksHigherEducation

Проверяет корректность отображения страницы Высшего образования.

14. checkMainPageLinksDesign

Проверяет доступность страницы курсов по дизайну.

15. checkMainPageLinksAllCourses

Проверяет корректность ссылки на страницу "Все курсы".

16. checkMainPageLinksDataAnalyst

Проверяет доступность информации по курсу "Аналитик данных".

17. checkMainPageLinksPython

Проверяет корректность отображения страницы курса Python.

18. checkMainPageLinksGraphicDesigner

Проверяет доступность информации по курсу "Графический дизайнер".

19. checkMainPageLinksUXUIDesigner

Проверяет страницу курса UX/UI-дизайна.

20. checkMainPageLinksWhiteHacker

Проверяет страницу курса "Этичный хакинг".
