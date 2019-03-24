package com.stockie.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.LayoutBean;
import com.stockie.bean.LayoutDetailBean;
import com.stockie.dao.LayoutDao;
import com.stockie.model.Layout;
import com.stockie.model.LayoutDetail;
import com.stockie.service.LayoutService;
import com.stockie.service.ProductService;

@Service(value="layoutService")
@Transactional(propagation = Propagation.SUPPORTS)
public class LayoutServiceImpl implements LayoutService {

	@Autowired
	LayoutDao layoutDao;
	
	@Autowired
	ProductService productService;
	
	@Override
	public LayoutBean getLayout(Long layoutId) {
		Layout layout = layoutDao.getLayout(layoutId);
		return prepareBean(layout);
	}
	
	public LayoutBean prepareBean(Layout layout)  {
		LayoutBean layoutBean = new LayoutBean();
		
		try {
			BeanUtils.copyProperties(layoutBean, layout);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		layoutBean.setLayoutDetailBeans(prepareLayoutDetailsBean(layout.getLayoutDetails()));
		
		return layoutBean;
	}
	
	private List<LayoutDetailBean> prepareLayoutDetailsBean(List<LayoutDetail> layoutDetails) {
		List<LayoutDetailBean> beans = null;
		if (layoutDetails != null & !layoutDetails.isEmpty()) {
			beans = new ArrayList<LayoutDetailBean>();
			for (LayoutDetail layoutDetail : layoutDetails) {
				beans.add(prepareLayoutDetailBean(layoutDetail));
			}
		}
		return beans;
	}
	
	private LayoutDetailBean prepareLayoutDetailBean(LayoutDetail layoutDetail) {
		LayoutDetailBean bean = new LayoutDetailBean();
		
		try {
			BeanUtils.copyProperties(bean, layoutDetail);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		bean.setProductBean(productService.prepareBean(layoutDetail.getProduct()));
		return bean;
	} 
	
}
