/**   
 * @Title: TopCallbackController.java 
 * @Package com.thinkgem.jeesite.modules.top.web 
 * @Description: TODO
 * @author 10060484
 * @date 2013/03/21 14:18:31 
 * @version V1.0   
 */
package com.thinkgem.jeesite.modules.top.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.taobao.api.internal.util.WebUtils;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.AreaService;
import com.thinkgem.jeesite.modules.sys.service.OfficeService;
import com.thinkgem.jeesite.modules.sys.service.SystemService;
import com.thinkgem.jeesite.modules.top.entity.TopUser;
import com.thinkgem.jeesite.modules.top.service.TopUserService;
import com.thinkgem.jeesite.modules.top.utils.TopConifg;

/**
 * @author 10060484
 * 
 */
@Controller
@RequestMapping(value = "top")
public class TopCallbackController extends BaseController {

	@Autowired
	private SystemService systemService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private TopUserService topUserService;

	// private VasApi vasApi;

	public TopCallbackController() {
		// ImprovedTaobaoClient client = new
		// ImprovedTaobaoClient(TopConifg.getServerUrl(),
		// TopConifg.getAppKey(), TopConifg.getAppSecret());
		// vasApi = new VasApi(client);
	}

	@ResponseBody
	@RequestMapping(value = "callback")
	public String callback(@RequestParam("code") String code,
			HttpServletResponse response) {

		// 生成或更新用户
		TopUser topUser = getUser(code, response);
		

		// 登录
		systemService.login(topUser.getTaobaoUserNick(),
				topUser.getTaobaoUserNick());

		// 跳转
		return "redirect:" + Global.ADMIN_PATH;
	}

	@RequestMapping(value = "login")
	public String sendToLogin() {
		return String.format("redirect:" + TopConifg.getOauthUrl(),
				TopConifg.getAppKey(), TopConifg.getRedirectUrl());
	}

	private TopUser getUser(String code, HttpServletResponse response) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("client_id", TopConifg.getAppKey());
		params.put("response_type", "code");
		params.put("client_secret", TopConifg.getAppSecret());
		params.put("grant_type", "authorization_code");
		params.put("code", code);
		params.put("redirect_uri", TopConifg.getRedirectUrl());

		String res;
		try {
			res = WebUtils.doPost(TopConifg.getOauthCodeUrl(), params, 0, 0);
			
			if (StringUtils.isBlank(res)) {
				return null;
			}
		} catch (IOException e) {
			return null;
		}
		
		// 根据TOP回调的参数给用户赋值
		TopUser topUser = JsonMapper.getInstance().fromJson(
				WebUtils.decode(res), TopUser.class);

		if (topUserService.exists(topUser.getTaobaoUserNick())) {
			topUserService.save(topUser);
		} else {

			User user = new User();
			user.setLoginName(topUser.getTaobaoUserNick());
			user.setPassword(SystemService.entryptPassword(topUser
					.getTaobaoUserNick()));
			user.setName(topUser.getTaobaoUserNick());
			user.setTopUser(topUser);

			// 查询用户的版本
			// List<ArticleUserSubscribe> vasSubscribe = vasApi.getVasSubscribe(
			// topUser.getTaobaoUserNick(), TopConifg.getArticleCode());
			// for (ArticleUserSubscribe subscribe : vasSubscribe) {
			// subscribe.getItemCode();
			// subscribe.getDeadline();
			// }
			List<Role> roles = Lists.newArrayList();
			roles.add(systemService.findRoleByItemCode("001"));

			user.setRoleList(roles);
			user.setOffice(officeService.findByCode("001"));

			user.setArea(areaService.get(1L));

			// 保存
			systemService.saveUser(user);
		}

		return topUser;
	}

}
