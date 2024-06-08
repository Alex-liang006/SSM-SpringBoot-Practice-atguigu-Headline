package com.atguigu.service;

import com.atguigu.pojo.Headline;
import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Alex
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-05-24 21:18:13
*/
public interface HeadlineService extends IService<Headline> {
    /**
     * 首页数据查询
     * @param portalVo
     * @return
     */
    Result findNewsPage(PortalVo portalVo);

    /**
     * 根据id查询头条详情
     * @param hid
     * @return
     */
    Result showHeadlineDetail(Integer hid);

    /**
     * 头条新闻发布
     * @return
     */
    Result publish(Headline headline, String token);

    /**
     * 修改头条数据
     * @param headline
     * @return
     */
    Result updateData(Headline headline);
}
