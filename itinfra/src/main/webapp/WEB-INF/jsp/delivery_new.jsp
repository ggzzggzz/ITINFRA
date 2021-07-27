<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="/dist/img/logo-white.ico">
  <!-- Font & Icon -->
  <link rel="stylesheet" href="/dist/font/roboto/roboto.min.css" id="font-css">
  <link rel="stylesheet" href="/plugins/material-design-icons-iconfont/material-design-icons.min.css">
  <link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="/dist/css/materialdesignicons.css">
  <link rel="stylesheet" href="/dist/DataTables/datatables.css">
  <!-- Plugins -->
  <!-- CSS plugins goes here -->
  <!-- Main Style -->
  <link rel="stylesheet" href="/plugins/simplebar/simplebar.min.css">
  <link rel="stylesheet" href="/dist/css/style.min.css" id="main-css">
  <link rel="stylesheet" href="/dist/css/sidebar-royal.min.css" id="theme-css">
  <!-- options: blue,cyan,dark,gray,green,pink,purple,red,royal,ash,crimson,namn,frost -->
  <link rel="stylesheet" href="/dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="/dist/css/style_new.css">
  <title>Infracube</title>
</head>
<body>
	<!-- alert modals:S -->

  <!-- 고객조회 -->
  <div class="modalz" id="userser">
    <div class="modalz_body">
      <div class="modalz_tit">
        고객조회
        <a class="pop-x-btn"></a>
      </div>
      <div class="modalz_con">
        <ul class="serc_box">
          <li><input id="selectUser" type="text" placeholder="검색어입력(고객명/담당자명/담당자연락처)"></li>
          <li><a id="selectUserButton" class="serbtn"></a></li>
        </ul>
        <div class="tabels no-info">
          <table id="example2" class="display">
            <thead>
              <tr>
                <th>고객코드</th>
                <th>고객명</th>
                <th>담당자명</th>
                <th>담당자연락처</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="result" items="${customerInfoList}" varStatus="status">
            	<tr>
            		<td>${result.ccode}</td>
            		<td>${result.cname}</td>
            		<td>${result.mname}</td>
            		<td>${result.mphone}</td>
            	</tr>
            </c:forEach>
            <!-- 
              <tr>
                <td>C10238D1124</td>
                <td>HP</td>
                <td>홍길동</td>
                <td>010-2023-1923</td>
              </tr>
              <tr>
                <td>C10238D1124</td>
                <td>HP</td>
                <td>홍길동</td>
                <td>010-2023-1923</td>
              </tr>
              <tr>
                <td>C10238D1124</td>
                <td>HP</td>
                <td>홍길동</td>
                <td>010-2023-1923</td>
              </tr>
            -->  
            </tbody>
          </table>
        </div>
      </div>
      <div class="modalz_foot">
      	<a id="close-customerinfo" href="#" class="newbtns modalclose">닫기</a>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  <!-- alert modals:E -->
  <!-- Sidebar -->
  <div class="sidebar">

    <!-- Sidebar header -->
    <div class="sidebar-header">
      <a href="index.html" class="logo">
        <img src="../../../dist/img/infracube_logo_m.png" alt="Logo" id="main-logo">
        <p>IT-Infra</p>System
      </a>
      <a href="#" class="nav-link nav-icon rounded-circle ml-auto" data-toggle="sidebar">
        <i class="material-icons">close</i>
      </a>
    </div>
    <!-- /Sidebar header -->

    <!-- Sidebar body -->
    <div class="sidebar-body">
      <ul class="nav treeview mb-4" data-accordion>
        <hr>
        <li class="nav-item">
          <a class="nav-link has-icon treeview-toggle" href="#"><i data-feather="code"></i>기본코드관리</a>
          <ul class="nav">
            <li class="nav-item"><a href="groupCode.do" class="nav-link">그룹코드관리</a></li>
            <li class="nav-item"><a href="baseCode.do" class="nav-link">기초코드관리</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link has-icon treeview-toggle" href="#"><i data-feather="user-check"></i>고객관리</a>
          <ul class="nav">
            <li class="nav-item"><a href="customer.do" class="nav-link">고객목록</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link has-icon treeview-toggle active show" href="#"><i data-feather="book-open"></i>납품관리</a>
          <ul class="nav">
            <li class="nav-item show"><a href="delivery.do" class="nav-link">납품목록</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link has-icon treeview-toggle" href="#"><i data-feather="lock"></i>시스템관리</a>
          <ul class="nav">
            <li class="nav-item"><a href="systemset.do" class="nav-link">관리자</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- /Sidebar body -->

  </div>
  <!-- /Sidebar -->

  <!-- Main -->
  <div class="main">

    <!-- Main header -->
    <div class="main-header">
      <a class="nav-link nav-link-faded rounded-circle nav-icon" href="#" data-toggle="sidebar">
        <i class="material-icons">menu</i>
      </a>
      <ul class="nav nav-circle ml-auto">
        <li class="nav-item d-none d-sm-block">
          <label class="tit">${sessionName}</label>
          <a href="logout.do">
            <small class="text-secondary text-danger">
              <i class="mr-1 ml-2" data-feather="log-out"></i>로그아웃
            </small>
          </a>
        </li>
      </ul>
    </div>
    <!-- /Main header -->

    <!-- Main body -->
    <div class="main_body">
      <section id="section8" class="main_bars">
        <div class="bgs-main">
          <section id="section5">
            <div class="sub_title">납품목록 신규등록</div>
            
          </section>
        </div>
      </section>
      <div class="contants_body">
        
        <div class="gs_booking">
          <div class="box_column">
            <div class="containers">
              <form action="processInsertDelivery.do" method="post" onsubmit="return CheckInsertForm()">
              <div class="forms_table_non">
              	<input type="hidden" id="Customer_Code" name="Customer_Code" value="">
                <table>
                  <tr>
                    <th class="th">고객명</th>
                    <td colspan="3">
                      <button class="newbtn bg1 userser" type="button">고객조회</button>
                      <input class="input w-25" type="hidden" id="Customer_Name" name="Customer_Name" value="" readonly>
                      <span id="please-click">고객조회버튼을 클릭해주세요.</span>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">사업명</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="Business_Name">
                    </td>
                    <th class="th">제조사</th>
                    <td>
                      <select class="input" name="Manufacturer">
                        <option value="HP">HP</option>
                        <option value="MS">MS</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">모델명</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="Model_Name">
                    </td>
                    <th class="th">시리얼번호</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="Serial_Num">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">OS</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="OS">
                    </td>
                    <th class="th">CPU</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="CPU">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">Memory</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="Memory">
                    </td>
                    <th class="th">HDD</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="" name="HDD">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">서비스유형</th>
                    <td>
                      <select class="input" name="Service_Type">
                        <option value="유상">유상</option>
                        <option value="무상">무상</option>
                      </select>
                    </td>
                    <th class="th">기간</th>
                    <td>
                      <select class="input" name="Term" id="Term">
                        <option value="1년">1년</option>
                        <option value="2년">2년</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">납품일</th>
                    <td>
                      <input type="text" class="input calender" id="DeliveryDatePic" placeholder="시작일" name="Delivery_Date">
                    </td>
                    <th class="th">서비스종료일</th>
                    <td>
                      <input type="text" class="input calender" id="FinishDatePic" placeholder="종료일" name="End_Date">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">사용여부</th>
                    <td>
                      <select class="input" name="Use_YN">
                        <option value="Y">예</option>
                        <option value="N">아니오</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">메모</th>
                    <td colspan="3">
                      <textarea class="textarea" name="Note"></textarea>
                    </td>
                  </tr>
                </table>
                <input type="hidden" value="${sessionName}" name="Insert_Delivery">
        		<!-- session.getAttribute("sessionName"); -->
              </div>
              
              <div class="modalz_foot">
                <button type="submit" class="newbtns bg1">저장</button>
                <button type="reset" onclick="history.go(-1)" class="newbtns modalclose">취소</button>
              </div>
			  </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /Main body -->
  </div>
  <!-- /Main -->

  <!-- Main Scripts -->
  <script src="/dist/js/jquery.min.js"></script>
  <script src="/dist/DataTables/datatables.js"></script>
  <script src="/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/plugins/simplebar/simplebar.min.js"></script>
  <script src="/plugins/feather-icons/feather.min.js"></script>
  <script src="/dist/js/bootstrap-datepicker.min.js"></script>
  <script src="/dist/js/script.min.js"></script>
  <!-- Plugins -->
  <!-- JS plugins goes here -->
  <script>
    $(document).ready(function () {
      $('#examples').DataTable({
        "paging": true,
        "searching": false,
        "info": true
      });
      $('#example2').DataTable({
        "paging": false,
        "searching": false,
        "info": false,
      });
    });
    $(document).ready(function () {
      
      $('.newcode').click(function () {
        $('#newcode').addClass('act');
      });
      $('.recode').click(function () {
        $('#recode').addClass('act');
      });

      $('.userser').click(function () {
        $('#userser').addClass('act');
      });
      
      $('.pop-x-btn, .modalclose').click(function() {
          var tmp = $(this).parents().parents().parents()
          if (tmp.attr('class') == 'modalz act') {
              tmp.removeClass('act');
          } else {
              //tmp.removeClass('act');
          }
      });
      
      $('#example2 tr').click(function () {
    	  var tr = $(this);
    	  var td = tr.children();
    	  console.log("클릭한 Row의 모든 데이터 : "+tr.text());
    	  var ccode = td.eq(0).text();
    	  var cname = td.eq(1).text();
    	  $('#close-customerinfo').click(function () {
    		  $('#Customer_Code').val(ccode);
    		  $('#Customer_Name').prop("type", "text");
    		  $('#Customer_Name').val(cname);
    		  $("#please-click").empty();
    	  });
      });
      
      // 기간이 변경될 때
      $("#Term").change(function () {
    	  var date = $("#DeliveryDatePic").datepicker("getDate");
    	  var year = parseInt($("#Term option:selected").val().replace("년",""));
    	  console.log(date);
      	  date.setFullYear(date.getFullYear() + year);
      	  date.setDate(date.getDate() - 1);
    	  $("#FinishDatePic").datepicker().datepicker("setDate", date);
      });
      
      // 납품일이 변경될 때
      $("#DeliveryDatePic").change(function () {
    	  var date = $("#DeliveryDatePic").datepicker("getDate");
    	  var year = parseInt($("#Term option:selected").val().replace("년",""));
    	  console.log(date);
      	  date.setFullYear(date.getFullYear() + year);
      	  date.setDate(date.getDate() - 1);
    	  $("#FinishDatePic").datepicker().datepicker("setDate", date);
      });
      
      $("#selectUserButton").click(function(){
    	 var params =  {
    			 search : $("#selectUser").val()
    	 }
    	 
    	 $.ajax({
    		 type:"POST",
    		 url:"/deliveryCustomerSearch.do",
    		 data:params,
    		 dataType: "json",
    		 success:function(result){
    			 $("#example2 > tbody:last > tr").remove();
    			 var tableData="";
    			 $.each(result,function(index,value){
    				 tableData += '<tr>';
    				 tableData += '<td>' + value.ccode +'</td>';
    				 tableData += '<td>' + value.cname +'</td>';
    				 tableData += '<td>' + value.mname +'</td>';
    				 tableData += '<td>' + value.mphone +'</td>';
    				 tableData += '</tr>';
    			 });
    			 $("#example2").append(tableData);
    		 },
    		 error:function(XMLHttpRequest, textstatus, errorThrown) {
    			 alert(XMLHttpRequest+"\n"
    					 +textstatus+"\n"
    					 +errorThrown+"\n");
    		 }
    	 });
      });
    });
    
    $(function () {
      	$("#DeliveryDatePic").datepicker().datepicker("setDate", new Date());
      	
      	// 종료일의 초깃값
      	var date = new Date();
        date.setFullYear(date.getFullYear() + 1);
     	date.setDate(date.getDate() - 1);
      	$("#FinishDatePic").datepicker().datepicker("setDate", date);
    });
    
    function CheckInsertForm () {
    	if($('input[name=Customer_Name]').val() == "") {
    		alert('고객명을 입력하세요');
    		return false;
    	}else if($('input[name=Business_Name]').val() == "") {
    		alert('사업명을 입력하세요');
    		return false;
    	}else if($('input[name=Model_Name]').val() == "") {
    		alert('모델명을 입력하세요');
    		return false;
    	}else if($('input[name=Serial_Num]').val() == "") {
    		alert('시리얼번호를 입력하세요');
    		return false;
    	}else if($('input[name=OS]').val() == "") {
    		alert('OS를 입력하세요');
    		return false;
    	}else if($('input[name=CPU]').val() == "") {
    		alert('CPU를 입력하세요');
    		return false;
    	}else if($('input[name=Memory]').val() == "") {
    		alert('Memory를 입력하세요');
    		return false;
    	}else if($('input[name=HDD]').val() == "") {
    		alert('HDD를 입력하세요');
    		return false;
    	}
    }
  </script>
</body>
</html>