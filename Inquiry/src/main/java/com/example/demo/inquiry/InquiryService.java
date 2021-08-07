package com.example.demo.inquiry;

import java.util.List;

public interface InquiryService {

	void save(Inquiry inquiry);

	void delete(int id);

	Inquiry findById(int id);

	List<Inquiry> getAll();

	void update(Inquiry inquiry);

}
