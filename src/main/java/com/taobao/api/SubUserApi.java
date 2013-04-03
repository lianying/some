package com.taobao.api;

import com.taobao.api.domain.Permission;
import com.taobao.api.domain.Role;
import com.taobao.api.domain.SubUserInfo;
import com.taobao.api.domain.SubUserPermission;
import com.taobao.api.request.*;
import com.taobao.api.response.*;

import java.util.List;

/**
 * 子账号管理api
 * http://open.taobao.com/doc/api_cat_detail.htm?cat_id=10123&category_id=102
 *
 * @author Michael Leung
 */
public class SubUserApi {
    private ImprovedTaobaoClient taobaoClient;

    public SubUserApi(ImprovedTaobaoClient taobaoClient) {
        this.taobaoClient = taobaoClient;
    }

    /**
     * 查询指定账户的子账号列表
     *
     * @param nick
     * @param sessionKey
     * @return
     */
    public List<SubUserInfo> getSubUsers(String nick, String sessionKey) {
        SellercenterSubusersGetRequest request = new SellercenterSubusersGetRequest();
        request.setNick(nick);

        SellercenterSubusersGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getSubusers();
    }

    /**
     * 获取指定用户的权限集合
     *
     * @param nick
     * @param sessionKey
     * @return
     */
    public List<Permission> getPermissions(String nick, String sessionKey) {
        SellercenterUserPermissionsGetRequest request = new SellercenterUserPermissionsGetRequest();
        request.setNick(nick);

        SellercenterUserPermissionsGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getPermissions();
    }

    /**
     * 获取指定卖家的角色列表
     *
     * @param nick
     * @param sessionKey
     * @return
     */
    public List<Role> getRoles(String nick, String sessionKey) {
        SellercenterRolesGetRequest request = new SellercenterRolesGetRequest();
        request.setNick(nick);

        SellercenterRolesGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getRoles();
    }

    /**
     * 获取指定角色信息
     *
     * @param roleId
     * @param sessionKey
     * @return
     */
    public Role getRoleInfo(long roleId, String sessionKey) {
        SellercenterRoleInfoGetRequest request = new SellercenterRoleInfoGetRequest();
        request.setRoleId(roleId);

        SellercenterRoleInfoGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getRole();
    }

    /**
     * 查询指定的子账号的权限和角色信息
     *
     * @param nick
     * @param sessionKey
     * @return
     */
    public SubUserPermission getPermissionsAndRoles(String nick, String sessionKey) {
        SellercenterSubuserPermissionsRolesGetRequest request = new SellercenterSubuserPermissionsRolesGetRequest();
        request.setNick(nick);

        SellercenterSubuserPermissionsRolesGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getSubuserPermission();
    }

    /**
     * 获取指定卖家和指定角色的下属员工列表
     *
     * @param roleId
     * @param sessionKey
     * @return
     */
    public List<SubUserInfo> getRoleMembers(long roleId, String sessionKey) {
        SellercenterRolemembersGetRequest request = new SellercenterRolemembersGetRequest();
        request.setRoleId(roleId);

        SellercenterRolemembersGetResponse response = taobaoClient.execute(request, sessionKey);

        return response.getSubusers();
    }
}
