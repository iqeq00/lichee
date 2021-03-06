package org.lichee.core.model.vo;

import java.util.List;

/**
 * 分页vo 客户端分页
 * 
 * @author lynch
 */
public class Pagination<T> {
	
	private List<T> list;     		  	// 在所在页面要显示的内容

	private int allRow; 			// 内容的总条数
	private int pageSize; 			// 一个页面要显示的内容条数
	private int totalPage; 			// 总页数
	private int currentPage; 		// 当前页
	private int first; 				// 当前页数据的第一条数据，在数据库所在的位置
	
	/**
	 * 构造方法 
	 */
	public Pagination() {
		
	}
	
	/**
	 * 构造方法 
	 */
	public Pagination(List<T> list, int allRow, int pageSize, int totalPage,
			int currentPage, int first) {
		
		this.list = list;
		this.allRow = allRow;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.first = first;
	}
	
	/**
	 * 操作方法 
	 */
	public boolean isFirstPage(){
		return currentPage==1 ;
	}
	public boolean hasBackPage(){
		return currentPage!=1 ;
	}
	public boolean hasNextPage(){
		return currentPage!=totalPage ;
	}
	public boolean isLastPage(){
		return totalPage==currentPage ;
	}
	
	/**计算总页数*/
	public int countTotalPage(int pageSize,int allRow){
		
		totalPage = allRow%pageSize==0?allRow/pageSize:allRow/pageSize+1 ;
		return totalPage ;
	} 
	/**计算first记录*/
	public int countFirst(int pageSize,int page){
		
		first = pageSize*(page-1) ;
		return first ;	
	}
	/**计算当前页数*/
	public int countCurrentPage(int page){
		
		int curPage = page<=0?1:page>=totalPage?totalPage:page ;
		return curPage ;
	}
	
    /**
     * set、get方法 
     */
	
	public int getAllRow() {
		return allRow;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	

}
