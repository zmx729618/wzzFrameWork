package org.wzz.test.main;

import org.wangzz.core.orm.hibernate.EntityToDatabase;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
//		EntityToDatabase.exportToDataBase();
		String a = "school";
		
		String[] strs = a.split("\\.");
		for(String s : strs){
			System.out.println(s);
		}
	}

}
