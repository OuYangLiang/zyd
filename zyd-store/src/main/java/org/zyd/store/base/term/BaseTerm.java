package org.zyd.store.base.term;

/**
 * 
 * @author GeJianKui
 */
public abstract class BaseTerm {
    private int pageSize;
    private int page;
    private String sortField;
    private String sortDir;

    public int getStart() {
        return (page - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

}
