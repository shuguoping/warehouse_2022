package com.example.mybatisdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {

    private Integer userId; //用户编号
    private String userName; //用户名称
    private String userPassword; //用户密码
    private Integer userRoleId; /*用户职责ID：1、系统管理员：管理用户、权限、角色、数据字典
                                            2、销售主管：管理销售机会和客户开发计划、管理客户服务、查看统计报表
                                            3、客户经理：管理销售机会和客户开发计划、管理客户基本信息、管理将流失客户、管理客户服务、查看产品、库存、订单数据
                                            4、高管：查看统计报表 */
    private Integer userFlag; //用户标识(留用)

}
