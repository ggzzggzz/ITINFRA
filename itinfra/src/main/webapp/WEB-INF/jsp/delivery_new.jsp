<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          <li><input type="text" placeholder="검색어입력"></li>
          <li><a href="#" class="serbtn"></a></li>
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
              
            </tbody>
          </table>
        </div>
      </div>
      <div class="modalz_foot">
        <a href="#" class="newbtns modalclose">닫기</a>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  
  <!-- alert modals:E -->
  <!-- Sidebar -->
  <div class="sidebar">

    <!-- Sidebar header -->
    <div class="sidebar-header">
      <a href="index.jsp" class="logo">
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
          <label class="tit">관리자1</label>
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
              
              <div class="forms_table_non">
                <table>
                  <tr>
                    <th class="th">고객명</th>
                    <td colspan="3">
                      <button class="newbtn bg1 userser" type="button">고객조회</button>
                      고객조회버튼을 클릭해주세요.
                    </td>
                  </tr>
                  <tr>
                    <th class="th">사업명</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                    <th class="th">제조사</th>
                    <td>
                      <select class="input">
                        <option>HP</option>
                        <option>MS</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">모델명</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                    <th class="th">시리얼번호</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">OS</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                    <th class="th">CPU</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">Memory</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                    <th class="th">HDD</th>
                    <td>
                      <input type="text" class="input" placeholder="입력" value="">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">서비스유형</th>
                    <td>
                      <select class="input">
                        <option>유상</option>
                        <option>무상</option>
                      </select>
                    </td>
                    <th class="th">기간</th>
                    <td>
                      <select class="input">
                        <option>1년</option>
                        <option>2년</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">납품일</th>
                    <td>
                      <input type="text" class="input calender" id="DeliveryDatePic" placeholder="시작일">
                    </td>
                    <th class="th">서비스종료일</th>
                    <td>
                      <input type="text" class="input calender" id="FinishDatePic" placeholder="시작일">
                    </td>
                  </tr>
                  <tr>
                    <th class="th">사용여부</th>
                    <td>
                      <select class="input">
                        <option>예</option>
                        <option>아니오</option>
                      </select>
                    </td>
                  </tr>
                  <tr>
                    <th class="th">메모</th>
                    <td colspan="3">
                      <textarea class="textarea"></textarea>
                    </td>
                  </tr>
                </table>
              </div>
              
              <div class="modalz_foot">
                <a href="#" class="newbtns bg1">저장</a>
                <a href="delivery.do" class="newbtns modalclose">취소</a>
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
    });

    $(function () {
      $("#DeliveryDatePic").datepicker().datepicker("setDate", new Date());
      $("#FinishDatePic").datepicker().datepicker("setDate", new Date());
    });

  </script>
</body>
</html>