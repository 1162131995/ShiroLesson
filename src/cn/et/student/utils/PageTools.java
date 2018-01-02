package cn.et.student.utils;

import java.util.List;

public class PageTools {
	/**
	 * 当前页
	 */
	private Integer curPage;
	/**
	 * 分页大小
	 */
	private Integer pageCount = 10;
	/**
	 * 上一页
	 * curPage==1?1:(curPage-1)
	 */
	private Integer prePage;
	/**
	 * 下一页
	 * curPage==totalPage?totalPage:(curPage+1)
	 */
	private Integer nextPage;
	/**
	 * 总页页
	 * totalCount%pageCount == 0?totalCount/pageCount:totalCount/pageCount+1;
	 */
	private Integer totalPage;
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 分页索引
	 * startIndex = (curPage-1)*pageCount+1
	 * endIndex = pageCount*curPage
	 */
	private Integer startIndex;
	private Integer endIndex;
	/**
	 * 分页查询的数据
	 */
	private List rows;
	
	/**
	 * 
	 * @param curPage：当前页
	 * @param pageCount：分页大小
	 * @param totalCount：总记录数
	 */
	public PageTools(Integer curPage, Integer pageCount, Integer total) {
		this.curPage = curPage;
		this.pageCount = pageCount == null?this.pageCount:pageCount;
		this.total = total;
		this.totalPage = total%this.pageCount == 0?total/this.pageCount:total/this.pageCount+1;
		this.prePage = this.curPage==1?1:(curPage-1);
		this.nextPage = this.curPage==totalPage?totalPage:(curPage+1);
		this.startIndex = (curPage-1)*this.pageCount+1;
		this.endIndex = this.pageCount*curPage;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}

