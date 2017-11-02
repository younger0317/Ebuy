package com.ebuy.text;

import java.util.List;

import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.service.impl.EasybuyProductCategoryServiceImpl;

public class Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EasybuyProductCategoryService epcs=new 	EasybuyProductCategoryServiceImpl();
		EasybuyProductCategory epc = new EasybuyProductCategory(1, "aaa", 0, 1);
		int i = epcs.deleteCategoty(epc);
		System.out.println(i);
	}

}
