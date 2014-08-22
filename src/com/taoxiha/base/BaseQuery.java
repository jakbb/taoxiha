package com.taoxiha.base;

import com.taoxiha.common.page.PageRequest;

public class BaseQuery extends PageRequest implements java.io.Serializable {
	private static final long serialVersionUID = -360860474471966681L;
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final String[] SHOW_PAGE_SIZE={"10","50","100"};

	
	private int start = 0;
	private int end = 0;

	private String orderDirection;
	
	
	
	static {
        System.out.println("BaseQuery.DEFAULT_PAGE_SIZE="+DEFAULT_PAGE_SIZE);
    }
    
	public BaseQuery() {
		setPageSize(DEFAULT_PAGE_SIZE);
	}
	private int activePage =0;
	
	public int getActivePage() {
		return activePage;
	}
	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int activePage) {
		this.start = (activePage)*getPageSize()+1;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int totalCount) {
		this.end = (start+getPageSize()-1) > totalCount ? totalCount : start+getPageSize()-1;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getSort(){
		if(null==getSortColumns()||getSortColumns().isEmpty()){
			return null;
		}
		return getSortColumns().concat(" ").concat(this.orderDirection);
	}
		  
}
