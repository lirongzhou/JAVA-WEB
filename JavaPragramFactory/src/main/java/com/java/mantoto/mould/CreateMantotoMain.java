package com.java.mantoto.mould;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.java.base.ClassTemplate;
import com.java.createpragram.base.CreatePragramBase;
import com.java.mantoto.mould.base.MantotoPragramBase;
import com.java.mantoto.mould.emun.JavaLogicClassType;
import com.java.mantoto.mould.emun.MethodNameRule;
import com.java.mantoto.mould.emun.NameaRule;
import com.mantoto.util.CompilerJavaToClass;
import com.mantoto.util.FindClasses;
import com.mytools.file.CrateJavaFile;

/**
	* @author  作者 li rong zhou 
	* @date 创建时间：2016年9月12日 上午8:38:15 
	* 
	*  
	*/
public class CreateMantotoMain {

	public CreateMantotoMain(){
		nameaRule=NameaRule.INITIALUPPER;
	}
	private String beanPack="";
	
	private String daoPack="";
	private String daoImplPack="";
	
	private String servicePack="";
	private String serviceImplPack;
	
	private String serviceOpenPack="";
	private String serviceOpenImplPack="";
	
	private String cachePack="";
	private String cacheImplPack="";
	
	private String contorllerPack="";
	private String contorllerImplPack="";
	private List<String> tableNames;
	private NameaRule nameaRule;
	private   MantotoPragramBase pragram;
	private MethodNameRule methodNameRule=MethodNameRule.ONE;
	

	public void createBean(String pack){
		   beanPack=pack;
		
			if(isNull(tableNames)){
				 tableNames=getTeableNames();
			}
			
			for(String tableName:tableNames){
				pragram=new CreateMantotoBean(tableName,pack,nameaRule);
				
				ClassTemplate classTemplate=	pragram.getFileContent();
				pragram.setMethodNameRule(methodNameRule);
				CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
			    CompilerJavaToClass.compilerMaven(CreateMantotoMain.class, pack, classTemplate.getJavaName());  
			}
	}
	
//	生成接口
	public void createDao(String pack){
		daoPack=pack;
		if(isNull(beanPack)){
		System.out.println("请配置实体类的包名！");	
		return ;
		}
		Map<String,Class<?>> beanClasses=getMapClasses(beanPack,JavaLogicClassType.BEAN);
		
		if(isNull(tableNames)){
			 tableNames=getTeableNames();
		}
		for(String tableName:tableNames){
			pragram=new CreateMantotoDao(tableName, pack, beanClasses.get(tableName), nameaRule);
			pragram.setMethodNameRule(methodNameRule);
			ClassTemplate classTemplate=pragram.getFileContent();
			if(null==classTemplate){
				return;
			}
			CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
		    CompilerJavaToClass.compilerMaven(CreateMantotoMain.class, pack, classTemplate.getJavaName());  
		}
	}
	public void createService(String pack){
		servicePack=pack;
		if(isNull(beanPack)){
			System.out.println("请配置实体类的包名！");	
			return ;
			}
			Map<String,Class<?>> beanClasses=getMapClasses(beanPack,JavaLogicClassType.BEAN);
			
			if(isNull(tableNames)){
				 tableNames=getTeableNames();
			}
			for(String tableName:tableNames){
				pragram=new CreateMantotoService(tableName, pack, beanClasses.get(tableName), nameaRule);
				pragram.setMethodNameRule(methodNameRule);
				ClassTemplate classTemplate=pragram.getFileContent();
				if(null==classTemplate){
					return;
				}
				CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
			    CompilerJavaToClass.compilerMaven(CreateMantotoMain.class, pack, classTemplate.getJavaName());  
			}
	}

	public void createOpenService(String pack){
		serviceOpenPack=pack;
		if(isNull(beanPack)){
			System.out.println("请配置实体类的包名！");	
			return ;
			}
			Map<String,Class<?>> beanClasses=getMapClasses(beanPack,JavaLogicClassType.BEAN);
			
			if(isNull(tableNames)){
				 tableNames=getTeableNames();
			}
			for(String tableName:tableNames){
				pragram=new CreateMantotoOpenService(tableName, pack, beanClasses.get(tableName), nameaRule);
				pragram.setMethodNameRule(methodNameRule);
				ClassTemplate classTemplate=pragram.getFileContent();
				if(null==classTemplate){
					return;
				}
				CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
			    CompilerJavaToClass.compilerMaven(CreateMantotoMain.class, pack, classTemplate.getJavaName());  
			}
		
	}
   
    public void createCache(String pack){
    	cachePack=pack;
    	if(isNull(beanPack)){
			System.out.println("请配置实体类的包名！");	
			return ;
			}
			Map<String,Class<?>> beanClasses=getMapClasses(beanPack,JavaLogicClassType.BEAN);
			
			if(isNull(tableNames)){
				 tableNames=getTeableNames();
			}
			for(String tableName:tableNames){
				pragram=new CreateMantotoCache(tableName, pack, beanClasses.get(tableName), nameaRule);
				pragram.setMethodNameRule(methodNameRule);
				ClassTemplate classTemplate=pragram.getFileContent();
				if(null==classTemplate){
					return;
				}
				CrateJavaFile.CreateJavaMaven(classTemplate.getJavaName(), classTemplate.getPagckage(), classTemplate.getTemplateStr(), "java");
			    CompilerJavaToClass.compilerMaven(CreateMantotoMain.class, pack, classTemplate.getJavaName());  
			}
		
    }
    public void createContorller(String pack){
		contorllerPack=pack;
	}
// 生成接口完成
	
	public void createDaoImpl(String pack){
		daoImplPack=pack;
	}
	public void createCacheImpl(String pack){
		 cacheImplPack=pack;
	}
	public void createServiceImpl(String pack){
		serviceImplPack=pack;
	}
	
	public void createContorllerImpl(String pack){
		contorllerImplPack=pack;
	}
	
	public String getBeanPack() {
		return beanPack;
	}

	public void setBeanPack(String beanPack) {
		this.beanPack = beanPack;
	}

	public String getDaoPack() {
		return daoPack;
	}

	public void setDaoPack(String daoPack) {
		this.daoPack = daoPack;
	}

	public String getDaoImplPack() {
		return daoImplPack;
	}

	public void setDaoImplPack(String daoImplPack) {
		this.daoImplPack = daoImplPack;
	}

	public String getServicePack() {
		return servicePack;
	}

	public void setServicePack(String servicePack) {
		this.servicePack = servicePack;
	}

	public String getServiceImplPack() {
		return serviceImplPack;
	}

	public void setServiceImplPack(String serviceImplPack) {
		this.serviceImplPack = serviceImplPack;
	}

	public String getContorllerPack() {
		return contorllerPack;
	}

	public void setContorllerPack(String contorllerPack) {
		this.contorllerPack = contorllerPack;
	}

	public String getContorllerImplPack() {
		return contorllerImplPack;
	}

	public void setContorllerImplPack(String contorllerImplPack) {
		this.contorllerImplPack = contorllerImplPack;
	}

	public NameaRule getNameaRule() {
		return nameaRule;
	}

	public void setNameaRule(NameaRule nameaRule) {
		this.nameaRule = nameaRule;
	}
	
	private  List<String> getTeableNames(){
		try {
			return MantotoPragramBase.sourceData.getTableNames();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private Map<String,Class<?>> getMapClasses(String pack,JavaLogicClassType javaLogicClassType){
		Map<String,Class<?>> mapClasses=new HashMap<String, Class<?>>();
		
			Set<Class<?>> setClasses=FindClasses.getClasses(pack, false);
		
			if(isNull(tableNames)){
				 tableNames=getTeableNames();
			}
			for(String tableName:tableNames){
				Iterator<Class<?>> iterator=	setClasses.iterator();
				while(iterator.hasNext()){
					Class<?> clas=iterator.next();
					if(nameaRule.createClassName(javaLogicClassType.createClassName(tableName))
							.equals(clas.getSimpleName())){
						mapClasses.put(tableName, clas);
						iterator.remove();
					}
					
				}
			}
		return mapClasses;
	}
	
	public boolean isNull(Object o) {
		return null == o || "" == o || "".equals(o) ? true : false;
	}
}
