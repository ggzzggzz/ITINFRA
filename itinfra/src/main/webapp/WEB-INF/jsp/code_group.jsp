<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="shortcut icon" href="dist/img/logo-white.ico">
  <!-- Font & Icon -->
  <link rel="stylesheet" href="dist/font/roboto/roboto.min.css" id="font-css">
  <link rel="stylesheet" href="plugins/material-design-icons-iconfont/material-design-icons.min.css">
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="dist/css/materialdesignicons.css">
  <link rel="stylesheet" href="dist/DataTables/datatables.css">
  <!-- Plugins -->
  <!-- CSS plugins goes here -->
  <!-- Main Style -->
  <link rel="stylesheet" href="plugins/simplebar/simplebar.min.css">
  <link rel="stylesheet" href="dist/css/style.min.css" id="main-css">
  <link rel="stylesheet" href="dist/css/sidebar-royal.min.css" id="theme-css">
  <!-- options: blue,cyan,dark,gray,green,pink,purple,red,royal,ash,crimson,namn,frost -->
  <link rel="stylesheet" href="dist/css/bootstrap-datepicker.min.css">
  <link rel="stylesheet" href="dist/css/style_new.css">
  <title>Infracube</title>
</head>
<body>
	<!-- alert modals:S -->
  
  <!-- 등록하기 -->
  <form class="group_insert" action="insertGroup.do" method="post" onsubmit="return CheckInsertForm()">
  <div class="modalz" id="newcode">
    <div class="modalz_body small">
      <div class="modalz_tit">
        신규등록
        <a class="pop-x-btn"></a>
      </div>
      <div class="modalz_con">
        <div class="forms_table_non">
        	<input type="hidden" value="GROUP" name="Group_Code">
          <table>
            <tr>
              <th class="th">그룹코드</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="A100" name="BCode" id="insert_B">
              </td>
            </tr>
            <tr>
              <th class="th">그룹코드명</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Title" id="insert_T">
              </td>
            </tr>
            <tr>
              <th class="th">정렬순서</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Code_Order" id="insert_C_O">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value1</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text1">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value2</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text2">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value3</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text3">
              </td>
            </tr>
            <tr>
              <th class="th">정수값</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Number" id="insert_E_N">
              </td>
            </tr>
            <tr>
              <th class="th">메모</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Note">
              </td>
            </tr>
            <tr>
              <th class="th">사용유무</th>
              <td>
                <select class="input" name="Use_YN">
                  <option value="Y">사용</option>
                  <option value="N">사용안함</option>
                </select>
              </td>
            </tr>
          </table>
          <input type="hidden" value="${sessionName}" name="Insert_Code">
        </div>
      </div>
      <div class="modalz_foot">
        <button class="newbtns bg1" type="submit">등록</button>
        <button  class="newbtns modalclose" type="reset">취소</button>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  </form>
  
  <!-- 수정하기::등록하기 폼과 같음(타이틀&버튼명만 다름) -->
  <form action="updateGroup.do" method="post" onsubmit="return CheckUpdateForm()">
  <div class="modalz" id="recode">
    <div class="modalz_body small">
      <div class="modalz_tit">
        등록수정
        <a class="pop-x-btn"></a>
      </div>
      <div class="modalz_con">
        <div class="forms_table_non">
        <input type="hidden" value="GROUP" name="Group_Code">
          <table>
            <tr>
              <th class="th">그룹코드</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="BCode" id="re_BCode" readonly>
              </td>
            </tr>
            <tr>
              <th class="th">그룹코드명</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Title" id="re_Title">
              </td>
            </tr>
            <tr>
              <th class="th">정렬순서</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Code_Order" id="re_Code_Order">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value1</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text1" id="re_Ext_Text1">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value2</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text2" id="re_Ext_Text2">
              </td>
            </tr>
            <tr>
              <th class="th">Text Value3</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Text3" id="re_Ext_Text3">
              </td>
            </tr>
            <tr>
              <th class="th">정수값</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Ext_Number" id="re_Ext_Number">
              </td>
            </tr>
            <tr>
              <th class="th">메모</th>
              <td>
                <input type="text" class="input" placeholder="입력하기" value="" name="Note" id="re_Note">
              </td>
            </tr>
            <tr>
              <th class="th">사용유무</th>
              <td>
                <select class="input" name="Use_YN" id="re_Use_YN">
                  <option value="Y">사용</option>
                  <option value="N">사용안함</option>
                </select>
              </td>
            </tr>
          </table>
          <input type="hidden" name="Update_Code" value="${sessionName}">
        </div>
      </div>
      <div class="modalz_foot">
        <button class="newbtns bg1" type="submit">수정</button>
        <button  class="newbtns modalclose" type="reset">취소</button>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  </form>
  <!-- alert modals:E -->
  <!-- Sidebar -->
  <div class="sidebar">

    <!-- Sidebar header -->
    <div class="sidebar-header">
      <a href="index.jsp" class="logo">
        <img src="dist/img/infracube_logo_m.png" alt="Logo" id="main-logo">
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
          <a class="nav-link has-icon treeview-toggle active show" href="#"><i data-feather="code"></i>기본코드관리</a>
          <ul class="nav">
            <li class="nav-item show"><a href="groupCode.do" class="nav-link">그룹코드관리</a></li>
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
          <a class="nav-link has-icon treeview-toggle" href="#"><i data-feather="book-open"></i>납품관리</a>
          <ul class="nav">
            <li class="nav-item"><a href="delivery.do" class="nav-link">납품목록</a></li>
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
          <label class="tit" id="admin-name">${sessionName}</label>
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
            <div class="sub_title">그룹코드관리</div>
            <button class="newbtn bg1 newcode" type="button">등록</button>
            <button class="newbtn bg1 recode" type="button">수정</button>
          </section>
        </div>
      </section>
      <div class="contants_body">
      	<form style="display: inline;" action="groupCode.do" method="post">
        <div class="gs_b_top">
          <ul>
            <li>
              <select class="input" name="searchOption">
                <option value="all" <c:out value="${searchOption == 'all'?'selected':''}"/> >전체</option>
                <c:forEach var="result" items="${searchgrouplist}" varStatus="status">
                	<option value="${result.title}" <c:out value="${searchOption == result.title?'selected':''}"/> >${result.title}</option>
                </c:forEach>
              </select>
            </li>
            <li>
              <button class="newbtnss bg1" type="submit">검색</button>
            </li>
          </ul>
        </div>
        </form>
        <div class="gs_booking">
          <div class="box_column">
            <div class="containers">
              <div class="tabels cols2">
                <table id="examples" class="display">
                  <thead>
                    <tr>
                      <th>그룹코드</th>
                      <th>그룹코드명</th>
                      <th>정렬</th>
                      <th>Text Value1</th>
                      <th>Text Value2</th>
                      <th>Text Value3</th>
                      <th>정수값</th>
                      <th>메모</th>
                      <th>사용유무</th>
                      <th>등록자</th>
                      <th>저장일시</th>
                    </tr>
                  </thead>  
                  <tbody>
                  	<c:forEach var="result" items="${groupList}" varStatus="status">
                  		<tr>
                  			<td>${result.bcode}</td>
                  			<td>${result.title}</td>
                  			<td>${result.codeorder}</td>
                  			<td>${result.exttext1}</td>
                  			<td>${result.exttext2}</td>
                  			<td>${result.exttext3}</td>
                  			<td>${result.extnum}</td>
                  			<td>${result.note}</td>
                  			<td>${result.useyn}</td>
                  			<td>${result.insertcode}</td>
                  			<td>${result.insertdate}</td>
                  		</tr>
                  	</c:forEach>
                  <!--
                    <tr>
                      <td>GROUP</td>
                      <td>사용여부</td>
                      <td>1</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>Y</td>
                      <td>관리자1</td>
                      <td>2021-07-01 10:50:55</td>
                    </tr>
                    <tr>
                      <td>GROUP</td>
                      <td>제조사</td>
                      <td>2</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>-</td>
                      <td>Y</td>
                      <td>관리자1</td>
                      <td>2021-07-01 10:50:55</td>
                    </tr>
                  -->
                  </tbody>
                </table>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /Main body -->
  </div>
  <!-- /Main -->

  <!-- Main Scripts -->
  <script src="dist/js/jquery.min.js"></script>
  <script src="dist/DataTables/datatables.js"></script>
  <script src="dist/js/bootstrap.bundle.min.js"></script>
  <script src="plugins/simplebar/simplebar.min.js"></script>
  <script src="plugins/feather-icons/feather.min.js"></script>
  <script src="dist/js/bootstrap-datepicker.min.js"></script>
  <script src="dist/js/script.min.js"></script>
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
      
      $('.pop-x-btn, .modalclose').click(function() {
          var tmp = $(this).parents().parents().parents()
          if (tmp.attr('class') == 'modalz act') {
              tmp.removeClass('act');
          } else {
              //tmp.removeClass('act');
          }
      });
      
      
      var tr
      
      $('.recode').click(function () {
    	  if(tr == null){
    		  alert('수정할 행을 선택하세요');
    	  } else{
    		  $('#recode').addClass('act');
    	  }
        });
      
      $('#examples tr').click(function() {
    		tr = $(this);
      	  	var td = tr.children();
      	  	$('.recode').click(function () {    	  		     	  		
	      	  	$('#re_BCode').val(td.eq(0).text());
	      		$('#re_Title').val(td.eq(1).text());
	      		$('#re_Code_Order').val(td.eq(2).text());
	      		$('#re_Ext_Text1').val(td.eq(3).text());
	      		$('#re_Ext_Text2').val(td.eq(4).text());
	      		$('#re_Ext_Text3').val(td.eq(5).text());
	      		$('#re_Ext_Number').val(td.eq(6).text());
	      		$('#re_Note').val(td.eq(7).text());
	      		$('#re_Use_YN').val(td.eq(8).text());
      	  });
    	});
    });

    function CheckInsertForm () {
    	if($('#insert_T').val() == "") {
    		alert('그룹코드명을 입력하세요');
    		return false;
    	}else if($('#insert_B').val() == "") {
    		alert('그룹코드를 입력하세요');
    		return false;
    	} else if((!$.isNumeric($('#insert_C_O').val())) && ($('#insert_C_O').val() != null && $('#insert_C_O').val() != "")) {
    		alert('정렬순서엔 숫자만 입력이 가능합니다');
    		return false;
    	} else if((!$.isNumeric($('#insert_E_N').val())) && ($('#insert_E_N').val() != null && $('#insert_E_N').val() != "")) {
    		alert('정수값엔 숫자만 입력이 가능합니다');
    		return false;
    	}
    }
    
    function CheckUpdateForm () {
    	if($('#re_Title').val() == "") {
    		alert('그룹코드명을 입력하세요');
    		return false;
    	} else if((!$.isNumeric($('#re_Code_Order').val())) && ($('#re_Code_Order').val() != null && $('#re_Code_Order').val() != "")) {
    		alert('정렬순서엔 숫자만 입력이 가능합니다');
    		return false;
    	} else if((!$.isNumeric($('#re_Ext_Number').val())) && ($('#re_Ext_Number').val() != null && $('#re_Ext_Number').val() != "")) {
    		alert('정수값엔 숫자만 입력이 가능합니다');
    		return false;
    	}
    }
    
  </script>
</body>
</html>