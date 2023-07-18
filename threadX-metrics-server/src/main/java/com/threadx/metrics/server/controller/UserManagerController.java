package com.threadx.metrics.server.controller;

import com.threadx.metrics.server.common.annotations.GlobalResultPackage;
import com.threadx.metrics.server.common.annotations.Log;
import com.threadx.metrics.server.common.annotations.Login;
import com.threadx.metrics.server.common.annotations.UserPermission;
import com.threadx.metrics.server.conditions.UserPageConditions;
import com.threadx.metrics.server.dto.UserInfoDto;
import com.threadx.metrics.server.enums.LogEnum;
import com.threadx.metrics.server.enums.PermissionValue;
import com.threadx.metrics.server.service.UserManagerService;
import com.threadx.metrics.server.vo.ThreadxPage;
import com.threadx.metrics.server.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * *************************************************<br/>
 * 用户管理操作<br/>
 * ************************************************<br/>
 *
 * @author huangfu
 * @date 2023/6/3 13:56
 */
@RestController
@GlobalResultPackage
@Api(tags = "用户管理操作")
@RequestMapping("/manager/user")
public class UserManagerController {

    private final UserManagerService userManagerService;

    public UserManagerController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }


    @Login
    @Log(LogEnum.ADD_USER)
    @UserPermission(PermissionValue.USER_ADD)
    @ApiOperation(value = "添加用户")
    @PostMapping("addUser")
    public void addUser(@RequestBody UserInfoDto userInfoDto){
        userManagerService.saveUser(userInfoDto);
    }

    @Login
    @Log(LogEnum.MANAGER_UPDATE_USER)
    @UserPermission(PermissionValue.USER_UPDATE)
    @ApiOperation(value = "修改用户信息")
    @PostMapping("updateUser")
    public void updateUser(@RequestBody UserInfoDto userInfoDto){
        userManagerService.updateUser(userInfoDto);
    }

    @Login
    @Log(LogEnum.MANAGER_UPDATE_USER)
    @UserPermission(PermissionValue.USER_UPDATE)
    @ApiOperation(value = "查询所有的用户信息")
    @PostMapping("getAllUser")
    public ThreadxPage<UserVo> findAllUser(@RequestBody UserPageConditions userPageConditions){
        return userManagerService.findAllUser(userPageConditions);
    }
}
