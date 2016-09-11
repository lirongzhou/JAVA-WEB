package com.java.mantoto.mould;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.java.base.ClassTemplate;
import com.java.base.FieldTemplate;
import com.java.base.IMethodTemplate;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.NameaRule;
import com.java.mantoto.mould.emun.Qualifier;

public class CreateMantotoBean extends MantotoPragramBase {
	
	public CreateMantotoBean(String tableName,String pack,NameaRule nameaRule){
		super(JavaLogicClassType.BEAN,nameaRule);
		super.tableName=tableName;
		super.pack=pack;
		initClass();
	}
	
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		
		List<FieldTemplate> fields=new ArrayList<FieldTemplate>();
		try {
			 Map<String, String> fieldsMap= sourceData.getJavaFields(tableName, importStr);
			 fields= convertFieldMapToFieldTemplate( fieldsMap);
			 
			 this.classTemplate.setFields(fields);
				
			List<IMethodTemplate> methods=new ArrayList<IMethodTemplate>();
			this.classTemplate.setMethods(methods);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			this.classTemplate.setImportStr(importStr.toString());
			this.classTemplate.setComments(" @author  作者 li rong zhou 创建时间:"+format.format(new Date(System.currentTimeMillis())));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.classTemplate;
	}

	private List<FieldTemplate> convertFieldMapToFieldTemplate( Map<String, String> fields){
		List<FieldTemplate> fieldsList=new ArrayList<FieldTemplate>();
		for(Entry<String, String> entry:fields.entrySet()){
			FieldTemplate fieldTemplate=new FieldTemplate();
			fieldTemplate.setFieldType(entry.getValue());
			fieldTemplate.setFieldName(entry.getKey());
			fieldTemplate.setFieldQualifier(Qualifier.PRIVATE);
			fieldsList.add(fieldTemplate);
		}
		return fieldsList;
	}

}
