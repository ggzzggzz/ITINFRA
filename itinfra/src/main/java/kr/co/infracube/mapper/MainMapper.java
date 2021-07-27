package kr.co.infracube.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CodeDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.dto.DeliveryDto;

@Mapper("mainMapper")
public interface MainMapper {
	public List<CodeDto> getGroupCode(CodeDto dto) throws Exception;
	public int insertCode(CodeDto dto) throws Exception;
	public CodeDto selectCode(CodeDto dto) throws Exception;
	public List<CodeDto> selectAllGTitle() throws Exception;
	public int updateCode(CodeDto dto) throws Exception;
	public List<CodeDto> getBaseCode(CodeDto dto) throws Exception;
	public List<CodeDto> groupInfo() throws Exception;
	public List<CodeDto> selectAllBTitle() throws Exception;
	public List<DeliveryDto> getDelivery(HashMap<String, String> paramMap) throws Exception;
	public List<CustomerDto> customerInfo() throws Exception;
	public List<Map<String,String>> selectCustomerInfo(HashMap<String, String> paramMap) throws Exception;
	public int processInsertDelivery(DeliveryDto dto) throws Exception;
	public DeliveryDto deliveryInfo(DeliveryDto dto) throws Exception;
	public int processUpdateDelivery(DeliveryDto dto) throws Exception;
	public AdminDto processLogin(AdminDto admin) throws Exception;
	public List<AdminDto> listAdmins(AdminDto dto) throws Exception;
	public List<CustomerDto> listCustomers(HashMap<String, String> hashMap) throws Exception;
	public int insertAdmin(AdminDto dto) throws Exception;
	public int insertCustomer(CustomerDto dto) throws Exception;
	public int updateAdmin(AdminDto dto) throws Exception;
	public int updateCustomer(CustomerDto dto) throws Exception;
	public int passwordChange(AdminDto dto) throws Exception;
}
