package com.atguigu.b2c.sale.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.b2c.sale.bean.AttrValue;
import com.atguigu.b2c.sale.bean.Class2Attr;
import com.atguigu.b2c.sale.bean.ObjSkuPro;
import com.atguigu.b2c.sale.mapper.SearchMapper;
@Service
public class SearchServiceImpl implements SearchService {

	 @Autowired
	 private SearchMapper searchMapper;
	
	public List<ObjSkuPro> get_ObjSkuPro(Integer flbh2) {
		
		return searchMapper.select_ObjSkuPro(flbh2);
	}

	public List<Class2Attr> get_attrByClass2_id(Integer flbh2) {
		return searchMapper.select_attrByClass2_id(flbh2);
	}

	public List<ObjSkuPro> get_search_attr(Map<String, Object> map) {
		
		StringBuffer sb = new StringBuffer();
		
		Integer flbh2 = Integer.parseInt(map.get("flbh2").toString());
		String orderBy  = (String)map.get("orderBy");
		List<AttrValue> list = (List<AttrValue>)map.get("list2");
		  if (list!=null&&list.size()!=0) {
			  
			  if(list.size()==1){
				  sb.append(" and s.shp_id in "
				  		+ "( select  t_mall_sku_attr_value.shp_id "
				  		+ " from t_mall_sku_attr_value where shxm_id = "
				  		+ ""+list.get(0).getShxm_id()+" and shxzh_id =  "+list.get(0).getId()+" ) ");
			   
			  }else{
				  sb.append(" and s.shp_id in ");
				  /*( select sku_0.sku_id from
				(select sku_id from t_mall_attr_value where attr_id =8 and value_id=24) sku_0 , 
				(select sku_id from t_mall_attr_value where attr_id =19 and value_id=50) sku_1
				where sku_1.sku_id=sku_0.sku_id)*/
				  
				  sb.append(" ( select sku_0.sku_id from ");
				  for (int i = 0; i < list.size(); i++) {
					  sb.append(" ( select t_mall_sku_attr_value.sku_id from t_mall_sku_attr_value where "
					  		+ " shxm_id = "+list.get(i).getShxm_id()+" and shxzh_id = "+list.get(i).getId()+"  ) sku_"+i+" ");
				      if(list.size()-1!=i){
				    	  sb.append("  ,  ");
				      }
				  }
				  sb.append(" where  ");
				  for (int i = 0; i < list.size(); i++) {
					if( list.size()-1>=i+1 ){
						sb.append(" sku_"+i+".sku_id = sku_"+(i+1)+".sku_id  "); 
					   if(list.size()-1>i+1){
						   sb.append("  and ");
					   }
					}
				}
				  sb.append(" )  ");
			  }
			  sb.append("  "+orderBy+"  " );
			 
			  String sql = sb.toString();
		return searchMapper.select_search_attr(flbh2,sql);
		  }else{
			  sb.append("  "+orderBy+"  " );
			  String sql = sb.toString();
			  return searchMapper.select_search_attr(flbh2,sql);
		  }
	}

	public ObjSkuPro show_pro_info(Integer sku_id) {
	
		return searchMapper.select_pro_by_sku_id(sku_id);
	}

	public List<ObjSkuPro> get_ObjSkuPro_by_shp_id(Integer shp_id) {
		
		return searchMapper.select_ObjSkuPro_by_shp_id(shp_id);
	}

	
	
}
