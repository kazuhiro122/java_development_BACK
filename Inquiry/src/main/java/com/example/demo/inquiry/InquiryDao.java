package com.example.demo.inquiry;

import java.util.List;

public interface InquiryDao {

	void create(Inquiry inquiry);

	List<Inquiry> getAll();

	Inquiry findById(int id);

	void delete(int id);

	void update(Inquiry inquiry);


}
