package kakakucom.controller.account;

import kakakucom.model.User;
import kakakucom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ModelAttribute
    AccountForm setUpForm() {
        return new AccountForm();
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    String createForm() {
        return "account/createForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated AccountForm form, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "account/createForm";
        }
        User user = new User(
            0,
            form.getName(),
            form.getPassword(),
            false
        );
        accountService.register();
        attributes.addFlashAttribute(user);
        return "redirect:/account/create?finish";
    }

    @RequestMapping(value = "create", params = "finish", method = RequestMethod.GET)
    String createFinish() {
        return "account/createFinish";
    }
}
