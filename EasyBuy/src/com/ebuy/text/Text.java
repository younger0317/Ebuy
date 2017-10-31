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
		List<EasybuyProductCategory> type1IbAll = epcs.findType1IbAll();
		for (EasybuyProductCategory easybuyProductCategory : type1IbAll) {
			String name = easybuyProductCategory.getName();
			System.out.println(name);
		}
	}

}
