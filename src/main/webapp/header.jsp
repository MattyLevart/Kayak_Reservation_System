<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta
          name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no"
  />
  <meta name="description" content=""/>
  <meta name="author" content=""/>

  <title>Zarezerwuj kajak</title>

  <!-- Custom fonts for this template-->
  <link
          href="<c:url value="/theme/vendor/fontawesome-free/css/all.css"/>"
          rel="stylesheet"
          type="text/css"
  />
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet"
  />

  <!-- Custom styles for this template-->
  <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet"/>
  <style>
    .bg-gradient-orange {
      background: linear-gradient(180deg, #f86e1b, #fc934e);
    }
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
    }
    .login-form {
      width: 100%;
      max-width: 400px;
      padding: 15px;
      margin: auto;
    }
    .login-form .form-control {
      margin-bottom: 10px;
    }
    .login-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
     .header-buttons {
       position: absolute;
       top: 10px;
       right: 10px;
     }
    .header-buttons a {
      margin-left: 10px;
    }
    .centered-button {
      display: flex;
      justify-content: center;
      margin-bottom: 10px;
    }
    .full-width-image {
      width: 100%;
      height: 55vh;
      object-fit: cover;
    }
     .confirmation-container {
       text-align: center;
       padding: 50px;
       background-color: #d4edda;
       border: 1px solid #c3e6cb;
       border-radius: 5px;
       margin-top: 50px;
     }
    .confirmation-container h1 {
      color: #155724;
    }
    .confirmation-container h2 {
      color: #0c5460;
    }
    .confirmation-container p {
      color: #0c5460;
    }
    .confirmation-container .btn {
      margin-top: 20px;
    }
  </style>
</head>

<body id="page-top">
<!--
Page
Wrapper -->
<div id="wrapper">
  <!-- Sidebar -->
  <ul
          class="navbar-nav bg-gradient-orange sidebar sidebar-dark accordion"
          id="accordionSidebar"
  >
    <c:choose>
      <c:when test="${sessionScope.SPRING_SECURITY_CONTEXT != null}">
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/user/reservations">
          <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-anchor"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Adrena<sup>lina</sup></div>
        </a>
      </c:when>
      <c:otherwise>
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
          <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-anchor"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Adrena<sup>lina</sup></div>
        </a>
      </c:otherwise>
    </c:choose>

    <!-- Divider -->
    <hr class="sidebar-divider my-0"/>

    <!-- Nav Item - Dashboard -->
    <c:if test="${sessionScope.SPRING_SECURITY_CONTEXT != null}">
      <p class="nav-link" style="text-align: center; color: #f0f0f0; margin-top: 20px; margin-bottom: 5px;">Panel użytkownika:</p>
      <li class="nav-item active">
        <a class="nav-link" href="/user/reservations">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Twoje rezerwacje</span>
        </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/user/details">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dane konta</span>
        </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/user/points-history">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Historia punktów</span>
        </a>
      </li>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p class="nav-link" style="text-align: center; color: #f0f0f0; margin-top: 20px; margin-bottom: 5px;">Panel administratora:</p>
        <li class="nav-item active">
          <a class="nav-link" href="/admin/reservations">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Nadchodzące Rezerwacje</span>
          </a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/admin/archive">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Archiwum Rezerwacji</span>
          </a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/admin/users">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Użytkownicy</span>
          </a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="/admin/kayaks">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Kajaki</span>
          </a>
        </li>
      </sec:authorize>

      <li class="nav-item active text-center">
        <sec:authorize access="isAuthenticated()">
          <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </form>
        </sec:authorize>
      </li>
    </c:if>

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
      <!-- Topbar -->
      <nav
              class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
      ></nav>
      <!-- End of Topbar -->
