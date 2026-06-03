package ru.productstar.servlets.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.productstar.servlets.model.Transaction;
import ru.productstar.servlets.model.TransactionType;

import java.util.List;

@Controller
public class IncomeController {

    @PostMapping("/incomes/add")
    public String addIncome(HttpServletRequest request) {
        ServletContext context = request.getServletContext();

        String name = request.getParameter("name");
        String sumParam = request.getParameter("sum");

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Income name is empty");
        }

        int sum = Integer.parseInt(sumParam);
        if (sum <= 0) {
            throw new IllegalArgumentException("Income sum must be greater than 0");
        }

        List<Transaction> transactions = (List<Transaction>) context.getAttribute("transactions");
        Integer freeMoney = (Integer) context.getAttribute("freeMoney");

        transactions.add(new Transaction(name, sum, TransactionType.INCOME));
        context.setAttribute("freeMoney", freeMoney + sum);

        context.log("[IncomeController] added income: " + name + ", " + sum);
        return "redirect:/summary";
    }
}