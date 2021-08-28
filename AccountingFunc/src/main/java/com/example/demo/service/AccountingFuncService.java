package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemEntity;
import com.example.demo.entity.UserItem;
import com.example.demo.repository.AccountingFuncRepository;

@Service
public class AccountingFuncService {

	String SQL = " SELECT * FROM UserItem LEFT JOIN( ItemEntity ON UserItem.itemId = ItemEntity.itemId ) WHERE userId = ?";

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserItem userItem;

	@Autowired
	AccountingFuncRepository accountingFuncRepository;

	@SuppressWarnings("unchecked")
	public List<ItemEntity> purchase(String userId) {

		Query sq = entityManager.createNativeQuery(SQL);
		sq.setParameter(1, userId);
		return sq.getResultList();


	}
}
