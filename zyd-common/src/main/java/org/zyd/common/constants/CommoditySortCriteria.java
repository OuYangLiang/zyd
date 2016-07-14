package org.zyd.common.constants;

public enum CommoditySortCriteria {
    default_sort("num_sales", "desc"),
    
    price_asc("current_price", "asc"), 
    price_desc("current_price", "desc"),

    sales_asc("num_sales", "asc"), 
    sales_desc("num_sales", "desc"),

    evaluated_asc("num_evaluated", "asc"),
    evaluated_desc("num_evaluated", "desc");

    private String field;
    private String dir;

    public String getField() {
        return this.field;
    }

    public String getDir() {
        return this.dir;
    }

    private CommoditySortCriteria(String field, String dir) {
        this.field = field;
        this.dir = dir;
    }

}
