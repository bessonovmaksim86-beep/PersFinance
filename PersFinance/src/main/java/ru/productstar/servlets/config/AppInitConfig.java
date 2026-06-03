package ru.productstar.servlets.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import ru.productstar.servlets.model.Transaction;
import ru.productstar.servlets.model.TransactionType;

import java.util.ArrayList;
import java.util.List;

@Configuration
@WebListener
public class AppInitConfig implements ServletContextListener {

    @Value("${app.salary}")
    private int salary;

    @Value("${app.rent}")
    private int rent;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("rent", rent, TransactionType.EXPENSE));

        context.setAttribute("transactions", transactions);
        context.setAttribute("freeMoney", salary - rent);

        context.log("[AppInitConfig] initialized: salary=" + salary + ", rent=" + rent);
    }
}