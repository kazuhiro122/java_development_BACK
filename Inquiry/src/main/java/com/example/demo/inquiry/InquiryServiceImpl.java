package com.example.demo.inquiry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {

	private InquiryDao dao;

	@Autowired
	public InquiryServiceImpl(InquiryDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Inquiry inquiry) {
		dao.create(inquiry);
	}

	@Override
	public List<Inquiry> getAll() {
		return dao.getAll();
	}

	@Override
	public Inquiry findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void update(Inquiry inquiry) {
		dao.update(inquiry);
	}

}
