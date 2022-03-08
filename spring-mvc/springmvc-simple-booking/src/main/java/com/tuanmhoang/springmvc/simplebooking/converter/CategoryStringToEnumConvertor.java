package com.tuanmhoang.springmvc.simplebooking.converter;

import com.tuanmhoang.springmvc.simplebooking.model.enums.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryStringToEnumConvertor implements Converter<String, Category> {
    @Override
    public Category convert(String strCategory) {
        if(strCategory.equals("Bar")){
            return Category.BAR;
        }
        else if(strCategory.equals("Premium")){
            return Category.PREMIUM;
        }
        else{
            return Category.STANDARD;
        }
    }
}
