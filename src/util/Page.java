package util;

public class Page {
	private int currentPage;
	private int pageSize;
	private int count;
	private int pageCount;
	private int prevPage;
	private int nextPage;
	private int startRecord;
	public Page(int currentPage, int pageSize, int count) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.pageCount=count%pageSize==0?count/pageSize:count/pageSize+1;
		this.prevPage=currentPage==1?1:currentPage-1;
		this.nextPage=currentPage==pageCount?pageCount:currentPage+1;
		this.startRecord=(currentPage-1)*pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public int getPrevPage() {
		return prevPage;
	}
	
	public int getNextPage() {
		return nextPage;
	}
	
	public int getStartRecord() {
		return startRecord;
	}
	
	
	

}
