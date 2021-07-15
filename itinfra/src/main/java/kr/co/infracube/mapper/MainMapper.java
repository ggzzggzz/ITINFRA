package kr.co.infracube.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CustomerDto;

@Mapper("mainMapper")
public interface MainMapper {
	//public CodeDto getGroupCode(CodeDto dto) throws Exception;
	public AdminDto processLogin(AdminDto admin) throws Exception;
	public List<AdminDto> listAdmins(AdminDto dto) throws Exception;
	public List<CustomerDto> listCustomers(CustomerDto dto) throws Exception;
	public int insertAdmin(AdminDto dto) throws Exception;
	public int insertCustomer(CustomerDto dto) throws Exception;
	public AdminDto infoAdmin(AdminDto admin) throws Exception;
	public int updateAdmin(AdminDto dto) throws Exception;
	public int updateCustomer(CustomerDto dto) throws Exception;
	public int passwordChange(AdminDto dto) throws Exception;
}
