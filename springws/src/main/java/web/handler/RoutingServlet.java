package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome ...");
		return "view-welcome";
	}

	@GetMapping("/login")
	public String loginView() {
		System.out.println("login view...");
		return "view-login";
	}

	@PostMapping("/login")
	public RedirectView login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");

		RedirectView redirectView;
		if (LoginService.login(username, password, dob)) {
			redirectView = new RedirectView("/q1", true);
		} else {
			redirectView = new RedirectView("/login", true);
			redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
		}
		return redirectView;
	}

	@GetMapping("/q1")
	public String q1View() {
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		double calculatedResult = MathQuestionService.q1Addition(number1, number2);

		RedirectView redirectView;
		if (!Double.isNaN(calculatedResult) && isCorrect(resultUser, calculatedResult)) {
			redirectView = new RedirectView("/q2", true);
		} else {
			redirectView = new RedirectView("/q1", true);
			redirectAttributes.addFlashAttribute("message", "Wrong answer or invalid input, try again.");
		}
		return redirectView;
	}

	@GetMapping("/q2")
	public String q2View() {
		return "view-q2";
	}

	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);

		RedirectView redirectView;
		if (!Double.isNaN(calculatedResult) && isCorrect(resultUser, calculatedResult)) {
			redirectView = new RedirectView("/q3", true);
		} else {
			redirectView = new RedirectView("/q2", true);
			redirectAttributes.addFlashAttribute("message", "Wrong answer or invalid input, try again.");
		}
		return redirectView;
	}

	@GetMapping("/q3")
	public String q3View() {
		return "view-q3";
	}

	@PostMapping("/q3")
	public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");

		double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);

		RedirectView redirectView;
		if (!Double.isNaN(calculatedResult) && isCorrect(resultUser, calculatedResult)) {
			redirectView = new RedirectView("/success", true);
		} else {
			redirectView = new RedirectView("/q3", true);
			redirectAttributes.addFlashAttribute("message", "Wrong answer or invalid input, try again.");
		}
		return redirectView;
	}

	@GetMapping("/success")
	public String successView() {
		return "view-success";
	}

	private boolean isCorrect(String userInput, double calculatedResult) {
		try {
			return Double.valueOf(userInput) == calculatedResult;
		} catch (Exception e) {
			return false;
		}
	}
}