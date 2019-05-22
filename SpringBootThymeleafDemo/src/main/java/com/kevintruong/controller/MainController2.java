package com.kevintruong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kevintruong.dao.BankAccountDAO;
import com.kevintruong.exception.BankTransactionException;
import com.kevintruong.form.SendMoneyForm;
import com.kevintruong.model.BankAccountInfo;

@Controller
public class MainController2 {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showBankAccounts(Model model) {
		List<BankAccountInfo> list = bankAccountDAO.listBankAccountInfo();

		model.addAttribute("accountInfos", list);

		return "accountsPage";
	}

	@RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
	public String viewSendMoneyPage(Model model) {

		SendMoneyForm form = new SendMoneyForm(1L, 2L, 700d);

		model.addAttribute("sendMoneyForm", form);

		return "sendMoneyPage";
	}

	@RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
	public String processSendMoney(Model model, SendMoneyForm sendMoneyForm) {

		System.out.println("Send Money::" + sendMoneyForm.getAmount());

		try {
			bankAccountDAO.sendMoney(sendMoneyForm.getFromAccountId(), //
					sendMoneyForm.getToAccountId(), //
					sendMoneyForm.getAmount());
		} catch (BankTransactionException e) {
			model.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "/sendMoneyPage";
		}
		return "redirect:/";
	}
}
