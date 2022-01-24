package com.mobile.polux.models;

import java.util.List;

/**
 * Created by laptoplenovo on 1/8/2018.
 */

public class PromotionBodyResponse {

    private Integer response_detail_id;
    private List<PromotionRuleResponse> response_rule;

    public Integer getResponse_detail_id() {
        return response_detail_id;
    }

    public void setResponse_detail_id(Integer response_detail_id) {
        this.response_detail_id = response_detail_id;
    }

    public List<PromotionRuleResponse> getResponse_rule() {
        return response_rule;
    }

    public void setResponse_rule(List<PromotionRuleResponse> response_rule) {
        this.response_rule = response_rule;
    }
}
