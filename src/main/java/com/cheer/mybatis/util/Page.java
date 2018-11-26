package com.cheer.mybatis.util;

public class Page {
    // 总页数
    private int totalPage;

    // 总条数
    private int count;

    // 每日条数
    private int pageSize;

    // 页码
    private int pageNum;

    // 起始行（偏移量）
    private int offset;

    public Page(int count, int pageSize, int pageNum) {
        this.count = count;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.setTotalPage(count, pageSize);
        this.setOffset(pageSize, pageNum);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int count, int pageSize) {
        this.totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int pageSize, int pageNum) {
        this.offset = (pageNum - 1) * pageSize;
    }
}
