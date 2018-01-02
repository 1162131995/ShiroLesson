package cn.et.shiro.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import cn.et.shiro.entity.Menu;
import cn.et.shiro.entity.UserInfo;

public interface UserMapper {
	
	@Select("select user_name as userName pass_word as password from user_info where user_name=#{0}")
	public UserInfo selectUser(String userName);
	
	@Select("select r.role_name from user_info u " +
			"inner join user_role_relation urr on u.user_id=uur.user_id " +
			"inner join role r on uur.role_id=r.role_id " +
			"where user_name=#{0} ")
	public Set<String> selectRoleByName(String userName);
	
	@Select("select r.role_name from user_info u " +
			"inner join user_role_relation urr on u.user_id=uur.user_id " +
			"inner join role r on uur.role_id=r.role_id " +
			"inner join role_perms_relation rpr on r.role_id=rpr.role_id " +
			"inner join perms p on rpr.perm_id=p.perm_id " +
			"where user_name=#{0} ")
	public Set<String> selectPermsByName(String userName);
	
	@Select("select menu_id as menuid, menu_name as menuname, menu_url as menuurl," +
			" menu_filter as menufilter, is_menu as ismenu from menu")
	public List<Menu> selectMenu();
	
	@Select("select menu_id as menuid, menu_name as menuname, menu_url as menuurl, " +
			"menu_filter as menufilter, is_menu as ismenu from menu " +
			"where menuurl=#{0}")
	public List<Menu> selectMenuByUrl(String url);
	
	@Select("select menu_id as menuid, menu_name as menuname, menu_url as menuurl, " +
			"menu_filter as menufilter, is_menu as ismenu from menu m " +
			"inner join user_menu_relation umr on m.menu_id=umr.menu_id " +
			"inner join user_info u on umr.user_id=u.user_id" +
			"where u.user_id-#{0}")
	public List<Menu> selectMenuByName(String userName);
}
