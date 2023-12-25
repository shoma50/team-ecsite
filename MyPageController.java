package jp.co.internous.nexus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.nexus.model.domain.MstUser;
import jp.co.internous.nexus.model.mapper.MstUserMapper;
import jp.co.internous.nexus.model.session.LoginSession;

/**
 * マイページに関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/nexus/mypage")//nexusで表示でるように変更
public class MyPageController {
	
	/*
	 * フィールド定義
	 */
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	/*
	 * マイページ画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return マイページ画面
	 */
	
	@RequestMapping("/")//マイページに遷移するメソッドを入力
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		
		return "my_page";
		
	}
	
}
