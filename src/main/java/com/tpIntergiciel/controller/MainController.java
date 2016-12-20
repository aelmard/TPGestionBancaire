package com.tpIntergiciel.controller;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.CustomUserDetails;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.service.AccountService;
import com.tpIntergiciel.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by abdel on 18/12/2016.
 */
@Controller
public class MainController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OperationService operationService;

    public User getUserConnected() {
        User user = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            user = ((User) principal);
        }
        return user;
    }

    @RequestMapping(value = {"/", "index"})
    public String accessToLoginPage(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String accessToIndex(Model model) {
        return "login";
    }

    @RequestMapping("/placeOperation")
    public String placeOperation(int idAccount,double montantOperation, String typeOperation){
        System.out.println(idAccount + ";" + montantOperation + ";" + typeOperation);
        if(typeOperation.equals("credit")){
            System.out.println("Début opération de crédit");
            operationService.credit(idAccount,montantOperation,getUserConnected());
        }
        return "redirect:/account";
    }

    @RequestMapping("/account")
    public String accessToAccount(Model model) {
        List<Compte> listAccounts = accountService.getAccountsByUser(getUserConnected());
        model.addAttribute("listAccounts", listAccounts);
        return "account";
    }
}
