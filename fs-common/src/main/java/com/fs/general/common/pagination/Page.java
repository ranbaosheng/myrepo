package com.fs.general.common.pagination;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Page<T> {
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    /**
     * 当前页数
     */
    public int pageNo = 1;
    /**
     * 每页显示多少条记录
     */
    public int pageSize = 10;
    public String orderBy = null;
    public String order = null;
    public boolean autoCount = true;
    public List<T> result = Collections.emptyList();
    /**
     * 总记录数
     */
    public long totalCount = 0L;
    /**
     * 总页数
     */
    public long totalPages = 1;
    /**
     * 起始记录
     */
    public int startIndex;
    /**
     * 结束记录
     */
    public int endIndex;

    public Page() {
        this.startIndex = pageNo > 0 ? (pageNo - 1) * pageSize : 0;
        this.endIndex = pageNo * pageSize;
    }

    public Page(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.startIndex = pageNo > 0 ? (pageNo - 1) * pageSize : 0;
        this.endIndex = pageNo * pageSize;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1)
            this.pageNo = 1;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public Page<T> pageNo(int thePageNo) {
        setPageNo(thePageNo);
        return this;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;

        if (pageSize < 1)
            this.pageSize = 1;
    }

    public Page<T> pageSize(int thePageSize) {
        setPageSize(thePageSize);
        return this;
    }

    public int getFirst() {
        return ((this.pageNo - 1) * this.pageSize + 1);
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Page<T> orderBy(String theOrderBy) {
        setOrderBy(theOrderBy);
        return this;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        if (order == null)
            return;
        String[] orders = StringUtils.split(StringUtils.lowerCase(order), ',');
        for (String orderStr : orders) {
            if ((!(StringUtils.equals("desc", orderStr))) && (!(StringUtils.equals("asc", orderStr))))
                throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");

        }

        this.order = StringUtils.lowerCase(order);
    }

    public Page<T> order(String theOrder) {
        setOrder(theOrder);
        return this;
    }

    public boolean isOrderBySetted() {
        return ((StringUtils.isNotBlank(this.orderBy)) && (StringUtils.isNotBlank(this.order)));
    }

    public boolean isAutoCount() {
        return this.autoCount;
    }

    public void setAutoCount(boolean autoCount) {
        this.autoCount = autoCount;
    }

    public Page<T> autoCount(boolean theAutoCount) {
        setAutoCount(theAutoCount);
        return this;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPages() {
        if (this.totalCount < 1L) {
            return 0L;
        }

        long count = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize > 0L)
            count += 1L;

        return count;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = this.getTotalPages();
    }

    public boolean isHasNext() {
        return (this.pageNo + 1 <= getTotalPages());
    }

    public int getNextPage() {
        if (isHasNext())
            return (this.pageNo + 1);

        return this.pageNo;
    }

    public boolean isHasPre() {
        return (this.pageNo - 1 >= 1);
    }

    public int getPrePage() {
        if (isHasPre())
            return (this.pageNo - 1);

        return this.pageNo;
    }

    /**
     * @return the endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * @param endIndex the endIndex to set
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

}


