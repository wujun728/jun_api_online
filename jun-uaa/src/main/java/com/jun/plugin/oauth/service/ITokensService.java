package com.jun.plugin.oauth.service;

import com.jun.plugin.common.model.PageResult;
import com.jun.plugin.oauth.model.TokenVo;

import java.util.Map;

/**
 * @author zlt
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
