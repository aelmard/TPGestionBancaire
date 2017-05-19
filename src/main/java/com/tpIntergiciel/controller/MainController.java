package com.tpIntergiciel.controller;

import com.tpIntergiciel.model.Compte;
import com.tpIntergiciel.model.CustomUserDetails;
import com.tpIntergiciel.model.User;
import com.tpIntergiciel.service.AccountService;
import com.tpIntergiciel.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Set;

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
    public String accessToAccessPage(Model model) {
        Set<String> roles = AuthorityUtils
                .authorityListToSet(SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            return "admin";
        }
        return "index";
    }

    @RequestMapping("/login")
    public String accessToIndex(Model model) {
        return "login";
    }

    @RequestMapping("/inscription")
    public String createUser(String usernameC, String passwordC, String nom, String prenom) {
        if (accountService.ifUserExists(usernameC)) {
            return "redirect:/index?exists";
        } else {
            accountService.createUser(usernameC, passwordC, nom, prenom);
        }
        return "login";
    }

    @RequestMapping("/createAccount")
    public String createAccount(Model model) {
        return "createAccount";
    }

    @RequestMapping("/createAnAccount")
    public String createAnAccount(WebRequest request) {
        String typeCompte = request.getParameter("typeCompte");
        double solde = Double.parseDouble(request.getParameter("solde"));
        if (request.getParameter("decouvert") != null) {
            double decouvert = Double.parseDouble(request.getParameter("decouvert"));
            accountService.createAccount(typeCompte, solde, decouvert, getUserConnected());
        } else {
            accountService.createAccount(typeCompte, solde, -1, getUserConnected());
        }
        return "redirect:/account";
    }

    @RequestMapping("/placeOperation")
    public String placeOperation(WebRequest request, Model model) {
        long idAccount = Long.parseLong(request.getParameter("idAccount"));
        double montantOperation = Double.parseDouble(request.getParameter("montantOperation"));
        String typeOperation = request.getParameter("typeOperation");
        System.out.println(idAccount + ";" + montantOperation + ";" + typeOperation);
        if (typeOperation.equals("credit")) {
            System.out.println("Début opération de crédit");
            operationService.credit(idAccount, montantOperation);
            return "redirect:/history";
        } else if (typeOperation.equals("pret")) {
            System.out.println("Début opération de pret");
            try {
                operationService.pret(idAccount, montantOperation);
                return "redirect:/history";
            } catch (NumberFormatException e) {
                System.out.println(e);
                model.addAttribute("status", e.toString());
                return accessToAccount(model);
            }
        } else if (typeOperation.equals("debit")) {
            System.out.println("Début opération de debit");
            try {
                operationService.debit(idAccount, montantOperation);
                return "redirect:/history";
            } catch (NumberFormatException e) {
                System.out.println(e);
                model.addAttribute("status", e.toString());
                return accessToAccount(model);
            }
        }
        return "redirect:/history";
    }

    @RequestMapping("/account")
    public String accessToAccount(Model model) {
        List<Compte> listAccounts = accountService.getAccountsByUser(getUserConnected());
        model.addAttribute("listAccounts", listAccounts);
        return "account";
    }

    @RequestMapping("/accounts")
    public String accessToAccounts(Model model) {
        List<Compte> listAccounts = accountService.getAllAccounts();
        model.addAttribute("listAccounts", listAccounts);
        return "accounts";
    }

    @RequestMapping("/history")
    public String accessToHistory(Model model) {
        List<Compte> listAccounts = accountService.getAccountsByUser(getUserConnected());
        model.addAttribute("listAccounts", listAccounts);
        return "history";
    }

    @RequestMapping("/users")
    public String accessToUsers(Model model) {
        List<User> listUsers = accountService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
}
