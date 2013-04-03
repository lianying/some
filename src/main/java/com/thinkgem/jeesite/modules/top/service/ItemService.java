package com.thinkgem.jeesite.modules.top.service;

import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.top.dao.ItemDao;
import com.thinkgem.jeesite.modules.top.entity.Item;

/**
 * 淘宝商品Service
 * @author lay
 * @version 2013-03-18
 */
@Component
@Transactional(readOnly = true)
public class ItemService extends BaseService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
	private ItemDao itemDao;
	
	public Item get(Long id) {
		return itemDao.findOne(id);
	}
	
	
	public Page<Item> find(Page<Item> page, Item item) {
		DetachedCriteria dc = itemDao.createDetachedCriteria();

		return itemDao.find(page, dc);
	}
	
	@Transactional(readOnly = false)
	public void save(Item item) {
		itemDao.save(item);
	}
	
	@Transactional(readOnly = false)
	public void delete(Long id) {
		itemDao.deleteById(id);
	}
	
}
