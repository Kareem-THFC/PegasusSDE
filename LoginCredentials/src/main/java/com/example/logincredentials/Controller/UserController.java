    package com.example.logincredentials.Controller;


    import com.example.logincredentials.Model.UsersModel;
    import com.example.logincredentials.Service.UsersService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class UserController {

        private final UsersService usersService;

        public UserController(UsersService usersService) {
            this.usersService = usersService;
        }

        @GetMapping("/login")
        public String getLoginPage(Model model) {
            model.addAttribute("loginRequest", new UsersModel());
            return "login_page";
        }

        @PostMapping("/login")
        public String login(@ModelAttribute UsersModel usersModel, Model model) {
            System.out.println("login request" + usersModel);

            String predefinedLogin = "ram";
            String predefinedPassword = "ram";

            if (predefinedLogin.equals(usersModel.getLogin()) && predefinedPassword.equals(usersModel.getPassword())) {
                model.addAttribute("userLogin", predefinedLogin);
                return "personal_page";
            } else {
                return "error_page";
            }
        }
    }

