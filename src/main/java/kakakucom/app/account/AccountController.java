package kakakucom.app.account;

import kakakucom.model.User;
import kakakucom.service.account.AccountService;
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

    @RequestMapping(value = "create")
    String createForm() {
        return "account/createForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated AccountForm form, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "account/createForm";
        }

        User user = User.builder()
            .name(form.getName())
            .email(form.getEmail())
            .build();
        accountService.create(user, form.getPassword());
        attributes.addFlashAttribute(user);
        return "redirect:/account/create?complete";
    }

    @RequestMapping(value = "create", params = "complete", method = RequestMethod.GET)
    String createFinish() {
        return "account/createComplete";
    }
}
