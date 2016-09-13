package com.java.mantoto.mould;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.java.base.ClassTemplate;
import com.java.base.ClassType;
import com.java.base.IMethodTemplate;
import com.java.base.InterfaceMethodTemplate;
import com.java.base.ParameterTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.MethodNameRule;
import com.java.mantoto.mould.emun.NameaRule;
import com.java.mantoto.mould.emun.Qualifier;

public class CreateMantotoCache extends MantotoPragramBase implements  CreatePragramBase{
	
	private Class beanClass;
	public CreateMantotoCache(String tableName,String pack,Class beanClass,NameaRule nameaRule){
		super(JavaLogicClassType.CACHE, nameaRule);
		super.tableName=tableName;
		super.pack=pack;
		this.beanClass=beanClass;
		initClass();
	}
	public ClassTemplate getFileContent() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(beanClass==null){
			return null;
		}
		this.classTemplate.setImportStr("import"+beanClass.getName()+";");
		classTemplate.setClassType(ClassType.INTERFACE);

		Map<String,String> map=MethodNameRule.getEnumValues(this.methodNameRule, javaLogicClassType, beanClass.getSimpleName());
		List<IMethodTemplate> methods=new ArrayList<IMethodTemplate>();
	    for(Entry<String,String> entry:map.entrySet()){
	    	
	    	InterfaceMethodTemplate methodTemplate=new InterfaceMethodTemplate();
			methodTemplate.setMethodQualifier(Qualifier.PUBLIC);
			
			methodTemplate.setMethodName(entry.getKey()+beanClass.getSimpleName());
			methodTemplate.setReturnType(entry.getValue());
			
			List<ParameterTemplate> parameters=new ArrayList<ParameterTemplate>();
			ParameterTemplate parameterTemplate=new ParameterTemplate();
			
			parameterTemplate.setParameterType(beanClass.getSimpleName());
			char[] chars=beanClass.getSimpleName().toCharArray();

			chars[0]=Character.toLowerCase(chars[0]);
			parameterTemplate.setParameterName(new String(chars));
			
			parameters.add(parameterTemplate);
			methodTemplate.setParameters(parameters);
			methods.add(methodTemplate);
	    }
	    
	    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.classTemplate.setComments(" @author  作者 li rong zhou 创建时间:"+format.format(new Date(System.currentTimeMillis())));
		classTemplate.setMethods(methods);
		return classTemplate;
	}


}
