package ru.productstar.servlets.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.productstar.servlets.model.Transaction;

import java.util.List;

@Controller
public class SummaryController {

    @GetMapping("/")
    public String home() {
        return "redirect:/summary";
    }

    @GetMapping("/summary")
    public ModelAndView summary(HttpServletRequest request) {
        ServletContext context = request.getServletContext();

        List<Transaction> transactions = (List<Transaction>) context.getAttribute("transactions");
        Integer freeMoney = (Integer) context.getAttribute("freeMoney");

        ModelAndView modelAndView = new ModelAndView("summary");
        modelAndView.addObject("transactions", transactions);
        modelAndView.addObject("freeMoney", freeMoney);

        return modelAndView;
    }
}