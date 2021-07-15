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

  <!-- alert:Start -->
  <div class="modalz" id="info_a1">
    <div class="modalz_body small">
      <div class="modalz_tit">
        대상선택
        <a class="pop-x-btn"></a>
      </div>
      <div class="modalz_con">
        <div class="alert_text">
          수정대상을 목록에서 선택하고 수정을 눌러주세요.
        </div>
      </div>
      <div class="modalz_foot">
        <a href="#" class="newbtns modalclose">확인</a>
      </div>
    </div>
    <div class="dim"></div>
  </div>
  <!-- 비밀번호 변경 alert:End -->
    
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
            <div class="sub_title">납품목록</div>
            <button class="newbtn bg1 newcode" type="button" onclick="location.href='deliveryNew.do'">등록</button>
            <button class="newbtn bg1 recode" type="button" onclick="location.href='deliveryEdit.do'">수정</button>
            <button class="newbtn bg1" type="button">엑셀</button>
          </section>
        </div>
      </section>
      <div class="contants_body">
        <div class="gs_b_top">
          <ul>
            <li style="padding-left: 10px;">
              <input type="checkbox" class="input_check">유지보수 종료일
            </li>
            <li><input type="text" class="input calender" id="sDatePic" placeholder="시작일"></li>
            <li>~</li>
            <li><input type="text" class="input calender" id="eDatePic" placeholder="종료일"></li>
            <li><input type="text" class="input" placeholder="검색어"></li>
            <li>
              <button class="newbtnss bg1">검색</button>
            </li>
          </ul>
        </div>
        <div class="gs_booking">
          <div class="box_column">
            <div class="containers">
              <div class="tabels cols2">
                <table id="examples" class="display">
                  <colgroup>
                    <col width="5%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="5%" />
                    <col width="10%" />
                    <col width="10%" />
                    <col width="5%" />
                    <col width="5%" />
                  </colgroup>
                  <thead>
                    <tr>
                      <th>순번</th>
                      <th>고객코드</th>
                      <th>고객명</th>
                      <th>사업명</th>
                      <th>제조사</th>
                      <th>모델명</th>
                      <th>시리얼번호</th>
                      <th>OS</th>
                      <th>CPU</th>
                      <th>Memory</th>
                      <th>HDD</th>
                      <th>납품일</th>
                      <th>서비스유형</th>
                      <th>기간</th>
                      <th>유지보수종료일</th>
                      <th>사용유무</th>
                      <th>등록자</th>
                      <th>저장일시</th>
                      <th>수정자</th>
                      <th>수정일시</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>C2107050001</td>
                      <td>HP</td>
                      <td>시스템구축</td>
                      <td>HPE</td>
                      <td>HP-500</td>
                      <td>HP3698</td>
                      <td>CentOS</td>
                      <td>CPU</td>
                      <td>234</td>
                      <td>300</td>
                      <td>2021-07-02</td>
                      <td>유상</td>
                      <td>1년</td>
                      <td>2022-07-01</td>
                      <td><label class="yesno yes">Y</label></td>
                      <td>관리자1</td>
                      <td>2021-07-01 10:50:55</td>
                      <td></td>
                      <td></td>
                    </tr>
                    
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
      $("#sDatePic").datepicker().datepicker("setDate", new Date());
      $("#eDatePic").datepicker().datepicker("setDate", new Date());
    });

  </script>
</body>
</html>