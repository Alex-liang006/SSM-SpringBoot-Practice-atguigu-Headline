package com.atguigu.pojo.vo;

import lombok.Data;

/**
 * Classname: PortalVo
 * Package: com.atguigu.pojo.vo
 * Description:
 *
 * @Author Alex Liang
 * @Create 2024/6/7 21:46
 * @Version 1.0
 */
@Data
public class PortalVo {
    private String keyWords;

    private int type = 0;

    private int pageNum = 1;

    private int pageSize = 10;
}
