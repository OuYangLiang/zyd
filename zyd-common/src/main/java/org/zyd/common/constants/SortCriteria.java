package org.zyd.common.constants;

public enum SortCriteria {
    /**
     * 会员联系信息
     */
    party_cntct_info_cntct_seq_asc("cntct_seq", "asc"),
    /**
     * 会员积分明细
     */
    point_event_event_ts_desc("event_ts", "desc"),
    /**
     * 购物订单
     */
    purchase_order_submit_time_desc("submit_time", "desc"),
    /**
     * 订单事件
     */
    order_event_event_ts_desc("event_ts", "desc"),
    /**
     * 退换货订单
     */
    return_order_submit_time_desc("submit_time", "desc"),
    /**
     * 退换货订单事件
     */
    return_order_event_event_ts_desc("event_ts", "desc"),
    /**
     * 退换货订单退款信息
     */
    return_order_refund_info_submit_time_desc("event_ts", "desc"),
    /**
     * 收藏商品
     */
    collected_list_collected_time_desc("collected_time", "desc"),
    /**
     * 商品-销售单价
     */
    commodity_current_price_asc("current_price", "asc"), 
    commodity_current_price_desc("current_price", "desc"),
    /**
     * 商品-销量
     */
    commodity_num_sales_asc("num_sales", "asc"), 
    commodity_num_sales_desc("num_sales", "desc"),
    /**
     * 商品-评论数
     */
    commodity_num_evaluated_asc("num_evaluated", "asc"),
    commodity_num_evaluated_desc("num_evaluated", "desc"),
    /**
     * 商品图片
     */
    commodity_image_image_seq_asc("image_seq", "asc"),
    /**
     * 商品咨询
     */
    commodity_enquiring_event_ts_desc("event_ts", "desc"),
    /**
     * 商品评价
     */
    commodity_evaluation_event_ts_desc("event_ts", "desc"),
    /**
     * 评价图片
     */
    evaluation_image_image_seq_asc("image_seq", "asc"),
    /**
     * 追评
     */
    added_evaluation_event_ts_asc("event_ts", "asc"),
    /**
     * 评价标签
     */
    evaluation_label_hit_times_desc("hit_times", "desc"),
    /**
     * 商品属性
     */
    commodity_property_seq_asc("seq", "asc"),
    /**
     * 商品属性
     */
    order_log_event_ts_desc("event_ts", "desc");

    private String field;
    private String dir;

    public String getField() {
        return this.field;
    }

    public String getDir() {
        return this.dir;
    }

    private SortCriteria(String field, String dir) {
        this.field = field;
        this.dir = dir;
    }

}
