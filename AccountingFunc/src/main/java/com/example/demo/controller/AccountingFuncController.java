package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserItem;
import com.example.demo.service.AccountingFuncService;


@Controller
public class AccountingFuncController {

	@Autowired
	UserItem userItem;

	@Autowired
	ItemEntity itemEntity;

	@Autowired
	AccountingFuncService accountingFuncService;

	@RequestMapping("/cartAdd")
	protected void doAddCart(Model model, HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{

		String userId = req.getParameter("userId");
		String itemId = req.getParameter("itemId");
		userItem.setItemId(Long.parseLong(userId));
		userItem.setUserId(Long.parseLong(itemId));

		model.addAttribute(userItem);

		return ;//カート内ページへ移動のソース入力 thymeleafでカート内商品を表示

    }

	@RequestMapping("/Purchase")
	protected void doPurchase(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {

		String userId = req.getParameter("userId");
		List<ItemEntity> userPriceInfo = accountingFuncService.purchase(userId);
		int total = 0;
		for(int i = 0; i < userPriceInfo.size(); i++) {
			total = itemEntity.getPrice();
			total += total;
		}
		return;

	}


}
