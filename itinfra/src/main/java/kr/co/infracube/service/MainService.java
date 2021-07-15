package kr.co.infracube.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.mapper.MainMapper;

@Service
public class MainService {
	@Autowired
	MainMapper mainmapper;
	
//	public CodeDto getGroupCode(CodeDto dto) throws Exception{
//		return mainmapper.getGroupCode(dto);
//	}
	public AdminDto processLogin(AdminDto admin) throws Exception{
		return mainmapper.processLogin(admin);
	}
	
	public List<AdminDto> listAdmins(AdminDto dto) throws Exception{
		return mainmapper.listAdmins(dto);
	}
	public List<CustomerDto> listCustomers(CustomerDto dto) throws Exception{
		return mainmapper.listCustomers(dto);
	}
	public int insertAdmin(AdminDto dto) throws Exception{
		return mainmapper.insertAdmin(dto);
	}
	public int insertCustomer(CustomerDto dto) throws Exception{
		return mainmapper.insertCustomer(dto);
	}
	public AdminDto infoAdmin(AdminDto admin) throws Exception{
		return mainmapper.infoAdmin(admin);
	}
	public int updateAdmin(AdminDto dto) throws Exception{
		return mainmapper.updateAdmin(dto);
	}
	public int updateCustomer(CustomerDto dto) throws Exception{
		return mainmapper.updateCustomer(dto);
	}
	public int passwordChange(AdminDto dto) throws Exception{
		return mainmapper.passwordChange(dto);
	}
}
