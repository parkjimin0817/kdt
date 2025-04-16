package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Form;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface FormMapper {
    int insertForm(Form form);
    ArrayList<Form> selectFormList();
}
