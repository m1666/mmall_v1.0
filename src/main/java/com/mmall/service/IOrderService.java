package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
 * User: mann
 * DateTime: 2018/7/6.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    /**
     * 数据验证
     *
     * @param params
     * @return
     */
    // TODO
    ServerResponse checkAliInfo(Map<String, String> params);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse<String> cancle(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);


    // backend
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    /**
     * 精确查找，可拓展为模糊查询
     *
     * @param orderNo
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);


}
