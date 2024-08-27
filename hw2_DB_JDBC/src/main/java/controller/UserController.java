package controller;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    // В конструкторе или методе init() инициализируйте userService
    // например, с помощью DI-фреймворка или созданием объекта userService
    public UserController() {
        // Инициализируйте userService
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Обработка GET-запросов

        String action = request.getParameter("action");

        if ("login".equals(action)) {
            // Обработка логина
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Проверка ввода
            if (username != null && password != null) {
               User user = userService.login(username, password);
                if (user != null) {
                    // Авторизация успешна
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("index.jsp"); // Или перенаправление на другую страницу
                } else {
                    // Неверный логин или пароль
                    request.setAttribute("error", "Неверный логин или пароль");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // Отсутствуют данные логина или пароля
                request.setAttribute("error", "Введите логин и пароль");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else if ("register".equals(action)) {
            // Обработка регистрации
            // ...
        } else {
            // Обработка других GET-запросов
            // ...
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Обработка POST-запросов

        String action = request.getParameter("action");

        if ("register".equals(action)) {
            // Обработка регистрации
            // ...
        } else {
            // Обработка других POST-запросов
            // ...
        }
    }

}

